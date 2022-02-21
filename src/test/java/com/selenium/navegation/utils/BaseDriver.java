package com.selenium.navegation.utils;

import io.cucumber.java.After;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseDriver {

    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public static String remote_url = "http://localhost:4445/wd/hub";

    @SneakyThrows
    public static void setUpDriverMobile() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Pixel 2");

        Map<String, Object> chromeOptionsMobile = new HashMap<>();
        chromeOptionsMobile.put("mobileEmulation", mobileEmulation);
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMobile);
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true));

        RemoteWebDriver ChromeDriver = new RemoteWebDriver(URI.create(remote_url).toURL(), capabilities);

        driver.set(ChromeDriver);
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @SneakyThrows
    public static void setUpDriverWeb() {
        ChromeOptions capabilities = new ChromeOptions();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true));
        RemoteWebDriver ChromeDriver = new RemoteWebDriver(
                URI.create(remote_url).toURL(),
                capabilities);
        driver.set(ChromeDriver);
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public static void killDriver() {
        driver.get().quit();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}
