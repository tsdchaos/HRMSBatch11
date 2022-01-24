package steps;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EditEmployeeSteps extends CommonMethods {
    @Then("user clicks on Edit button")
    public void user_clicks_on_edit_button() {
        click(addNewEmployeePage.saveButton);
    }

    @Then("edits required fields")
    public void edits_required_fields(DataTable dataTable)throws InterruptedException {
        List<Map<String, String>> employee = dataTable.asMaps();
        for(Map<String, String> emp:employee) {
            String dln = emp.get("DLN");
            String ssn = emp.get("SSN");
            String maritalStatus = emp.get("Marital");
            String dob = emp.get("DOB");
            String smoker = emp.get("Smoker");
            WebElement license = driver.findElement(By.id("personal_txtLicenNo"));
            sendText(license, dln);
            WebElement SSN = driver.findElement(By.id("personal_txtNICNo"));
            sendText(SSN, ssn);
            WebElement married = driver.findElement(By.id("personal_txtNICNo"));
            selectDropdown(married, maritalStatus);
            WebElement DOB = driver.findElement(By.id("personal_DOB"));
            sendText(DOB, dob);
            WebElement smoke = driver.findElement(By.id("personal_chkSmokeFlag"));
            if (smoker.equals("true")) {
                click(smoke);
            }
        }
    }

}
