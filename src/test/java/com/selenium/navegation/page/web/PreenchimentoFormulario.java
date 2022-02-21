package com.selenium.navegation.page.web;

import java.util.List;
import java.util.Map;
import com.selenium.navegation.utils.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lombok.SneakyThrows;

public class PreenchimentoFormulario {
    private WebDriver driver = null;
    WebElement element = null;

    @FindBy(xpath = "(//input[contains(@type,'text')])[1]")
    private WebElement inserirTextoNomeCompleto;

    @FindBy(xpath = "(//input[contains(@type,'text')])[2]")
    private WebElement inserirTextoEmail;

    @FindBy(xpath = "//div[@class='quantumWizMenuPaperselectOption appsMaterialWizMenuPaperselectOption freebirdThemedSelectOptionDarkerDisabled exportOption isSelected']")
    private WebElement listaComida;

    @FindBy(css = "div[aria-label='Pão, resposta para Hamburguer'] div[class='quantumWizTogglePapercheckboxInk exportInk']")
    private WebElement listaComidaTipo;

    @FindBy(xpath = "//div[@aria-label='Carne, resposta para Xburguer']//div[@class='quantumWizTogglePapercheckboxInnerBox exportInnerBox']")
    private WebElement checkboxSandwich;

    @FindBy(xpath = "//input[@type='date']")
    private WebElement inputDataHoje;

    @FindBy(xpath = "//input[@aria-label='Hora']")
    private WebElement inputHoraMaisUmaHora;

    @FindBy(xpath = "//input[@aria-label='Minuto']")
    private WebElement inputMinuto;

    public PreenchimentoFormulario() {
        this.driver = BaseDriver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @SneakyThrows
    public void nomeCompleto(String nomeCompleto) {
        inserirTextoNomeCompleto.click();
        inserirTextoNomeCompleto.sendKeys(nomeCompleto);
        Thread.sleep(1000);
    }
    @SneakyThrows
    public void email(String email) {
        inserirTextoEmail.click();
        inserirTextoEmail.sendKeys(email);
        Thread.sleep(1000);
    }

    public void corFavorita(String cor) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inserirTextoEmail);
        switch (cor) {
            case "Vermelho":
                driver.findElement(By.cssSelector("#i13")).click();
                driver.findElement(By.cssSelector("#i13")).click();
                break;
            case "Verde":
                driver.findElement(By.cssSelector("#i19")).click();
                driver.findElement(By.cssSelector("#i19")).click();
                break;
            case "Azul":
                driver.findElement(By.cssSelector("#i16")).click();
                driver.findElement(By.cssSelector("#i16")).click();
                break;
            default:
                break;
        }
    }

    public void sobremesa(String sobremesa) {
        switch (sobremesa) {
            case "Sorvete":
                driver.findElement(By.cssSelector("#i27")).click();
                break;
            case "Bolo":
                driver.findElement(By.cssSelector("#i30")).click();
                break;
            case "Fruta":
                driver.findElement(By.cssSelector("#i33")).click();
                break;
            default:
                break;
        }
    }

    @SneakyThrows
    public void comida(String comida) {
        driver.findElement(By.cssSelector(".quantumWizMenuPaperselectContent")).click();
        List<WebElement> elements = driver.findElements(By.cssSelector(".quantumWizMenuPaperselectContent"));
        Thread.sleep(2000);
        for (WebElement element : elements) {
            if (element.getAttribute("innerHTML").contains(comida)) {
                driver.findElement(By.xpath(
                        "//div[@role='option']//span[@class='quantumWizMenuPaperselectContent exportContent'][normalize-space()='"
                                + comida + "']"))
                        .click();
                break;
            }

        }
        Thread.sleep(2000);
    }

    public void gostaAnimas(String gostaAnimas) {

        driver.findElement(By.xpath("//div[@aria-label='"+gostaAnimas+"']//div[@class='appsMaterialWizToggleRadiogroupRadioButtonContainer']")).click();

    }

    public void esportes(String tipo, String esportes) {

        driver.findElement(By.xpath("//div[contains(@aria-label,'" + tipo + ", resposta para " + esportes + "')]"))
                .click();

    }

    public void sandwich(Map<String, String> tipo, String sandwich) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(
                "//div[contains(@aria-label,'Bom, resposta para eSport')]")));

        if (tipo.get("Ovo") != null) {
            driver.findElement(By.xpath("//div[@aria-label='Ovo, resposta para " + sandwich + "']")).click();
        }
        if (tipo.get("Queijo") != null) {
            driver.findElement(By.xpath("//div[@aria-label='Queijo, resposta para " + sandwich +  "']")).click();
        }
        if (tipo.get("Pao") != null) {
            ((JavascriptExecutor) driver).executeScript("document.querySelector('body > div:nth-child(9) > div:nth-child(2) > form:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(8) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1)').scrollLeft = -133;");
            driver.findElement(By.xpath("//div[@aria-label='Pão, resposta para " + sandwich +  "']")).click();
        }
        if (tipo.get("Carne") != null) {
            driver.findElement(By.xpath("//div[@aria-label='Carne, resposta para " + sandwich +  "']")).click();
        }
        if (tipo.get("Salada") != null) {
            driver.findElement(By.xpath("//div[@aria-label='Salada, resposta para " + sandwich +  "']")).click();
        }

    }

    public void dataHoje(String data) {
        inputDataHoje.click();
        inputDataHoje.sendKeys(Keys.chord(Keys.ARROW_LEFT));
        inputDataHoje.sendKeys(Keys.chord(Keys.ARROW_LEFT));
        inputDataHoje.sendKeys(data);
    }

    public void horaMaisUmaHora(String hora) {
        inputHoraMaisUmaHora.click();
        inputHoraMaisUmaHora.sendKeys(hora);
    }

    public void minuto(String minuto) {
        inputMinuto.click();
        inputMinuto.sendKeys(minuto);
    }

}
