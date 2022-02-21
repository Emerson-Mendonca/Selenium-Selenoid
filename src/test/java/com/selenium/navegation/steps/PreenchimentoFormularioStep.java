package com.selenium.navegation.steps;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.selenium.navegation.page.web.PreenchimentoFormulario;
import com.selenium.navegation.utils.BaseDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;

public class PreenchimentoFormularioStep {

    private static WebDriver driver = null;
    private PreenchimentoFormulario preenchimentoFormulario = new PreenchimentoFormulario();

    @Given("que o usuario esteja na pagina inicial")
    public void que_o_usuario_esteja_na_pagina_inicial() {
        driver = BaseDriver.getDriver();
        driver.get(
                "https://docs.google.com/forms/d/e/1FAIpQLSfWfPcADbvEPrGDePWhY-agioR1TAyFZTW-hwNTucN28-VACg/viewform");
    }

    @Given("preencher o campo qual seu nome completo {string}")
    public void preencher_o_campo_qual_seu_nome_completo(String nomeCompleto) {
        preenchimentoFormulario.nomeCompleto(nomeCompleto);
    }

    @Given("preencher o campo qual qual seu email {string}")
    public void preencher_o_campo_qual_qual_seu_email(String email) {
        preenchimentoFormulario.email(email);
    }

    @Given("preencher o campo qual qual sua cor favorita {string}")
    public void preencher_o_campo_qual_qual_sua_cor_favorita(String corFavorita) {
        preenchimentoFormulario.corFavorita(corFavorita);
    }

    @Given("preencher o campo qual qual sua sobremesa favorita {string}")
    public void preencher_o_campo_qual_qual_sua_sobremesa_favorita(String sobremesaFavorita) {
        preenchimentoFormulario.sobremesa(sobremesaFavorita);
    }

    @Given("preencher o campo qual qual sua comida favorita  {string}")
    public void preencher_o_campo_qual_qual_sua_comida_favorita(String comidaFavorita) {
        preenchimentoFormulario.comida(comidaFavorita);
    }

    @Given("preencher o campo qual o quanto voce gosta de animas de um {int} a {int} {string}")
    public void preencher_o_campo_qual_o_quanto_voce_gosta_de_animas_de_um_a(Integer int1, Integer int2,
            String gostaAnimas) {
        preenchimentoFormulario.gostaAnimas(gostaAnimas);
    }

    @Given("preencher o campo qual considere os esportes")
    public void preencher_o_campo_qual_considere_os_esportes(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            preenchimentoFormulario.esportes(columns.get("tipo").toString(), columns.get("esportes").toString());
        }
    }

    @Given("preencher o campo qual quais os ingredientes do sandwich")
    public void preencher_o_campo_qual_quais_os_ingredientes_do_sandwich(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            Map<String, String> tipo = new HashMap<>();
            tipo.put("Pao", columns.get("Pao"));
            tipo.put("Carne", columns.get("Carne"));
            tipo.put("Queijo", columns.get("Queijo"));
            tipo.put("Ovo", columns.get("Ovo"));
            tipo.put("Salada", columns.get("Salada"));
            preenchimentoFormulario.sandwich(tipo, columns.get("sandwich"));
        }
    }

    @Given("preencher o campo que dia e hoje")
    public void preencher_o_campo_que_dia_e_hoje() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String data = formato.format(new Date());
        preenchimentoFormulario.dataHoje(data);
    }

    @Then("preencher o campo daqui uma hora que horas serao")
    public void preencher_o_campo_daqui_uma_hora_que_horas_serao() {

        Calendar rightNow = Calendar.getInstance();

        preenchimentoFormulario.horaMaisUmaHora(String.valueOf(  rightNow.get(Calendar.HOUR_OF_DAY) + 1 ));

        preenchimentoFormulario.minuto( String.valueOf( rightNow.get(Calendar.MINUTE) ));

    }

}
