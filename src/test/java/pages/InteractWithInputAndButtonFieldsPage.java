package pages;

import static com.codeborne.selenide.Condition .*;

import BaseTest.BaseTest;
import com.BasePage;
import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$;

import static com.Locators.*;
public class InteractWithInputAndButtonFieldsPage extends BasePage {

    public InteractWithInputAndButtonFieldsPage() {
        super();

    }

    public void open() {
        Selenide.open(BaseTest.BASE_URL);
    }


    public void checkPageOpened() {
        $("body").shouldHave(Condition.text("Practice and become pro in test automation"));
    }


    public void clickOnTheEditButton(String replacementText) {
        String modifiedXPath1 = UNIVERSAL_CLICK_PAGE_XPATH.replace("$1", replacementText);
        SelenideElement element = $(By.xpath(modifiedXPath1));
        element.click();
    }

    public void verifyOpenPage(String replacementText1) {
        $("h1").shouldHave(text(replacementText1));
    }

    public void enterYourFullName() {
        $(By.id("fullName")).setValue("Brad Pitt").sendKeys(Keys.TAB);
    }

    public void getAttribute() {
        String attributeValue = $(By.id("getMe")).getAttribute("attributeName");
        System.out.println("Attribute value: " + attributeValue);
    }

    public void clearField() {
        $(By.id("clearMe")).clear();
    }

    public void confirmEnabledField() {
        $(By.id("noEdit")).shouldBe(disabled);
    }

    public void confirmReadonleField() {
        $(By.id("dontwrite")).shouldBe(readonly);
    }

    public void gotoHomeAndComeBackHereUsingDriverCommand() {
        $(By.id("home")).click();
        WebDriverRunner.getWebDriver().navigate().back();

    }

    public void verifyButtonDisabled() {
        $(By.xpath("//button[@title='Disabled button']")).shouldNotBe(enabled);
    }

    public void clickAndHoldButton() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        // Выполняем скрипт для прокрутки страницы вниз
        js.executeScript("window.scrollBy(0, 250);");
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement($(By.xpath("//h2[.='Button Hold!']"))).clickAndHold().perform();

    }

    public void verifyThatButtonIsHolded() {
        $(By.xpath("//h2[contains(.,'Button has been long pressed')]")).should(exist);
    }
}