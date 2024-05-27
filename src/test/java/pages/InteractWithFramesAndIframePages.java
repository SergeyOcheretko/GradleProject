package pages;

import com.BasePage;
import com.codeborne.selenide.Selenide;
import BaseTest.BaseTest;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.Locators.INNER_HTML;
import static com.Locators.UNIVERSAL_CLICK_PAGE_XPATH;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class InteractWithFramesAndIframePages extends BasePage {

    public InteractWithFramesAndIframePages(){
        super();
    }
    public void openLetcode() {
        Selenide.open(BaseTest.BASE_URL);
    }



    public void clickOnTheEditButton(String replacementText) throws InterruptedException {
        // Создаем XPath с подстановкой replacementText
        String modifiedXPath = UNIVERSAL_CLICK_PAGE_XPATH.replace("$1", replacementText);

        // Находим элемент по сконструированному XPath
        SelenideElement element = $(By.xpath(modifiedXPath));

        // Прокручиваем страницу к элементу
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", element);

        // Выполняем JavaScript для клика на элементе
       ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].click();", element);

    }

    public void enterFirstName(String firstName) {
        SelenideElement frame = $(By.id("firstFr"));
        switchTo().frame(frame);

        $(By.xpath("//input[@placeholder='Enter name']")).sendKeys(firstName);



    }

    public void enterLastName(String lastName) {

    $(By.xpath("//input[@placeholder='Enter email']")).sendKeys(lastName);
    }

    public void enterEmail(String email) throws InterruptedException {

        SelenideElement frame = $(By.xpath("//iframe[@class='has-background-white']"));
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", frame);

        switchTo().frame(frame);
$(By.name("email")).sendKeys(email);

    }

    public void checkEnteredName() {
    $(By.cssSelector(".title.has-text-info")).shouldHave(text("Tom Hanks"));
    }

    public void verifyOpenPage(String replacementText1) {
        $("h1").shouldHave(text(replacementText1));

    }

    public void selectAllRadioButtons() {

    }
}






