package com.selenium.navegation.steps;

import com.selenium.navegation.utils.BaseDriver;

import io.cucumber.java.en.Given;
import lombok.SneakyThrows;

public class SelecionarDriver {
  @SneakyThrows
  @Given("que selecione o driver {string}")
  public void que_selecione_o_driver(String driver) {
    if (BaseDriver.getDriver() != null) {
      Thread.sleep(6000);
      BaseDriver.killDriver();
    }
    if (driver.contains("WEB")) {
      BaseDriver.setUpDriverWeb();
    } else if (driver.contains("MOBILE")) {
      BaseDriver.setUpDriverMobile();
    }

  }

}
