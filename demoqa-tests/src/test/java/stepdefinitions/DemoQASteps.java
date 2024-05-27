package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;

public class DemoQASteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("I am on the demoqa page")
    public void i_am_on_the_demoqa_page() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\andre\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("https://demoqa.com");
    }

    @When("I click on the {string} button")
    public void i_click_on_the_button(String buttonText) {
        String xpath = "//button[text()='" + buttonText + "']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        WebElement button = driver.findElement(By.xpath(xpath));
        button.click();
    }

    @Then("I should see the button click result")
    public void i_should_see_the_button_click_result() {
        String resultId = "button-click-result";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(resultId)));
        WebElement result = driver.findElement(By.id(resultId));
        Assert.assertTrue(result.isDisplayed());
        driver.quit();
    }

    @When("I select {string} from the dropdown")
    public void i_select_from_the_dropdown(String option) {
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        dropdown.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//option[text()='" + option + "']"));
        dropdownOption.click();
    }

    @Then("{string} should be selected")
    public void should_be_selected(String option) {
        WebElement selectedOption = driver.findElement(By.xpath("//option[@selected='selected']"));
        Assert.assertEquals(option, selectedOption.getText());
        driver.quit();
    }

    @When("I upload a file named {string}")
    public void i_upload_a_file_named(String fileName) {
        WebElement uploadButton = driver.findElement(By.id("uploadButton"));
        uploadButton.sendKeys("path/to/project/structure/" + fileName);
    }

    @Then("I should see the file uploaded")
    public void i_should_see_the_file_uploaded() {
        WebElement uploadedFile = driver.findElement(By.id("uploadedFilePath"));
        Assert.assertTrue(uploadedFile.isDisplayed());
        driver.quit();
    }

    @When("I select a new date")
    public void i_select_a_new_date() {
        WebElement datePicker = driver.findElement(By.id("datePicker"));
        datePicker.click();
        WebElement newDate = driver.findElement(By.xpath("//date[@value='new_date_value']"));
        newDate.click();
    }

    @Then("the new date should be displayed")
    public void the_new_date_should_be_displayed() {
        WebElement selectedDate = driver.findElement(By.id("selectedDate"));
        Assert.assertTrue(selectedDate.isDisplayed());
        driver.quit();
    }
}
