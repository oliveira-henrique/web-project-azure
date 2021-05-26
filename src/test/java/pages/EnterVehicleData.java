package pages;

import java.util.HashMap;

import org.openqa.selenium.By;

import core.attachment.Attachment;
import core.driver.DriverManager;
import support.selenium.Action;
import support.selenium.Verifications;

public class EnterVehicleData extends DriverManager implements CommonTestingType {

	private By lblMenuEnterVehicleData = By.id("entervehicledata");
	private By cbbMake = By.id("make");
	private By cbbModel = By.id("model");
	private By txtCylinderCapacityCcm = By.id("cylindercapacity");
	private By txtEnginePerformanceKW = By.id("engineperformance");
	private By txtDateOfManufacture = By.id("dateofmanufacture");
	private By cbbNumberOfSeats = By.id("numberofseats");
	private By ckbRightHandDriveYes = By.xpath("//*[@id='righthanddriveyes']//following-sibling::span");
	private By ckbRightHandDriveNo = By.id("//*[@id='righthanddriveno']//following-sibling::span");
	private By cbbNumberOfSeats2 = By.id("numberofseatsmotorcycle");
	private By cbbFuelType = By.id("fuel");
	private By txtPayloadKg = By.id("payload");
	private By txtTotalWeightKg = By.id("totalweight");
	private By txtListPrice$ = By.id("listprice");
	private By txtLicensePlateNumber = By.id("licenseplatenumber");
	private By txtAnnualMileageMi = By.id("annualmileage");
	private By btnNext = By.id("nextenterinsurantdata");

	@Override
	public boolean isPresent() {
		attachments.add(new Attachment("png",null,scenario.get()));
		return Verifications.verifyElementIsVisible(lblMenuEnterVehicleData) 
				&& Verifications.verifyElementIsVisible(cbbMake);
	}

	public void insertData(HashMap data) {
		attachments.add(new Attachment("png",null,scenario.get()));
		Action.selectComboOptionByValue(cbbMake, data.get("make").toString());
		Action.selectComboOptionByValue(cbbModel, data.get("model").toString());
		Action.setText(txtCylinderCapacityCcm, data.get("cylinder_capacity_ccm"));
		Action.setText(txtEnginePerformanceKW, data.get("engine_performance_kw"));
		Action.setText(txtDateOfManufacture, data.get("date_of_manufacture"));
		Action.selectComboOptionByValue(cbbNumberOfSeats, data.get("number_of_seats").toString());
		if(data.get("right_hand_drive").toString().equals("Yes"))
			Action.clickOnElement(ckbRightHandDriveYes);
		if(data.get("right_hand_drive").toString().equals("No"))
			Action.clickOnElement(ckbRightHandDriveNo); 
		Action.selectComboOptionByValue(cbbNumberOfSeats2, data.get("number_of_seats2").toString());
		Action.selectComboOptionByValue(cbbFuelType, data.get("fuel_type").toString());
		Action.setText(txtPayloadKg, data.get("pay_load_kg"));
		Action.setText(txtTotalWeightKg, data.get("total_weight_kg"));
		Action.setText(txtListPrice$, data.get("list_price"));
		Action.setText(txtLicensePlateNumber, data.get("license_plate_number"));
		Action.setText(txtAnnualMileageMi, data.get("annual_mileage_mi"));
		attachments.add(new Attachment("png",null,scenario.get()));
		Action.clickOnElement(btnNext);
	}
}
