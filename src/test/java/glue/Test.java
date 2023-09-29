package glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test {

    private ChromeDriver driver;

    @Given("Se abre el programa de la calculadora")
    public void se_abre_el_programa_de_la_calculadora() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\John Sebastian\\IdeaProjects\\PruebaSelenium\\src\\test\\java\\resource\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        driver.manage().window().maximize();

    }
    @When("ingreso el {int} y el {int}")
    public void ingreso_el_y_el(Integer number1, Integer number2) {
        WebElement inputField = driver.findElement(By.xpath("//form[@id='calcForm']/div[1]//input[@class='element text medium']"));
        inputField.clear();
        inputField.sendKeys(String.valueOf(number1));
        WebElement inputField1 = driver.findElement(By.xpath("//form[@id='calcForm']/div[2]//input[@class='element text medium']"));
        inputField1.clear();
        inputField1.sendKeys(String.valueOf(number2));
    }
    @Then("escojo el operador de multiplicacion y debe coincidir con {string} en la calculadora")
    public void escojo_el_operador_de_multiplicacion_y_debe_coincidir_con_en_la_calculadora(String expectedResult) {
        WebElement dropdown = driver.findElement(By.id("selectOperationDropdown"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Multiply");
        WebElement Clickear = driver.findElement(By.id("calculateButton"));
        Clickear.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement resultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numberAnswerField")));
        String actualResult = resultElement.getAttribute("value");
        Assert.assertEquals(expectedResult, actualResult);

    }
    @Given("Se abre el programa de la calculadora para division")
    public void se_abre_el_programa_de_la_calculadora_para_division() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\John Sebastian\\IdeaProjects\\PruebaSelenium\\src\\test\\java\\resource\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        driver.manage().window().maximize();
    }
    @When("ingreso el {int} y el {int} para dividir")
    public void ingreso_el_y_el_para_dividir(Integer number3, Integer number4) {
        WebElement inputField = driver.findElement(By.xpath("//form[@id='calcForm']/div[1]//input[@class='element text medium']"));
        inputField.clear();
        inputField.sendKeys(String.valueOf(number3));
        WebElement inputField1 = driver.findElement(By.xpath("//form[@id='calcForm']/div[2]//input[@class='element text medium']"));
        inputField1.clear();
        inputField1.sendKeys(String.valueOf(number4));
    }
    @Then("escojo el operador de división y debe coincidir con {string} en la calculadora")
    public void escojo_el_operador_de_división_y_debe_coincidir_con_en_la_calculadora(String Result) {

        WebElement dropdown = driver.findElement(By.id("selectOperationDropdown"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Divide");
        WebElement Clickear = driver.findElement(By.id("calculateButton"));
        Clickear.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement resultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numberAnswerField")));
        String actualResult = resultElement.getAttribute("value");
        Assert.assertEquals(Result, actualResult);
    }

}




