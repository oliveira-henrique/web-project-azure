package steps;


import org.junit.Assert;

import core.data.DataYaml;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.EnterInsurantData;
import pages.EnterProductData;
import pages.EnterVehicleData;
import pages.CommonPage;
import pages.SelectPriceOption;
import pages.SendQuote;

public class VehicleSteps {

    private CommonPage commonPage = new CommonPage();
    private EnterVehicleData enterVehicleData = new EnterVehicleData();
    private EnterInsurantData enterInsurantData = new EnterInsurantData();
    private EnterProductData enterProductData = new EnterProductData();
    private SelectPriceOption selectPriceOption = new SelectPriceOption();
    private SendQuote sendQuote = new SendQuote();
    
    @Dado("eu estou na tela Enter Vehicle Data")
    public void eu_estou_na_tela_Enter_Vehicle_Data() {
    	commonPage.acessaAplicacao();
    	Assert.assertTrue(enterVehicleData.isPresent());
        Assert.assertTrue(enterVehicleData.isPresent());
    }

    @Quando("eu informar os dados  Enter Vehicle Data")
    public void eu_informar_os_dados_Enter_Vehicle_Data() throws Exception {
    	enterVehicleData.insertData(DataYaml.getMapYamlValues("Vehicle", "vehicle_data"));
    }

    @Quando("eu informo os dados na tela Enter Insurant Data")
    public void eu_informo_os_dados_na_tela_Enter_Insurant_Data() throws Exception {
    	enterInsurantData.insertData(DataYaml.getMapYamlValues("Vehicle", "insurant_data"));
    }

    @Quando("eu informo os dados na tela Enter Product Data")
    public void eu_informo_os_dados_na_tela_Enter_Product_Data() throws Exception {
    	enterProductData.insertData(DataYaml.getMapYamlValues("Vehicle", "product_data"));
    	
    }

    @Quando("eu informo os dados na tela Select Price Option")
    public void eu_informo_os_dados_na_tela_Select_Price_Option() {
    	selectPriceOption.insertData();
    }

    @Quando("eu informo os dados na tela Send Quote")
    public void eu_informo_os_dados_na_tela_Send_Quote() throws Exception {
    	sendQuote.insertData(DataYaml.getMapYamlValues("Vehicle", "quote"));
    }
  
    @Entao("valida exibição da mensagem de sucesso")
    public void valida_exibição_da_mensagem_de_sucesso() {
    	Assert.assertTrue(sendQuote.validaIconSuccess());
    	Assert.assertEquals("Sending e-mail success!", sendQuote.validaMensageSuccess());
    }
}
