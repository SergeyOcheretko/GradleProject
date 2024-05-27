package pages;

import com.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import BaseTest.BaseTest;

import static com.codeborne.selenide.Condition.*;
import static com.Locators.UNIVERSAL_CLICK_PAGE_XPATH;
import static com.codeborne.selenide.Selenide.*;

public class InteractWithSelectAndAlertFieldsPage extends BasePage {

    public InteractWithSelectAndAlertFieldsPage() {
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


    public void selectAppleUsingVisibleText() throws InterruptedException {
        final String DROPDOWN_ID = "fruits";

        $(By.id(DROPDOWN_ID)).selectOption("Apple");
        Thread.sleep(5000);

    }

    public void checkThatAppleIsChosen() {
        $(By.xpath("//p[contains(.,'You have selected Apple')]")).shouldHave(exactText("You have selected Apple"));
    }

    public void selectMultipleOptionsFromDropDown() {
        $(By.id("superheros")).selectOption("Ant-Man", "Aquaman", "The Avengers", "Batman");


    }

    public void acceptTheAlert() {
        // Click on the element which triggers the dialog
        $(By.id("accept")).click();

        // Accept the alert
        confirm();
    }

    public void dismissTheAlertPrintTheAlertText() {
        $(By.id("confirm")).click();

        dismiss("Are you happy with LetCode?");

    }

    public void typeYourNameAccept() throws InterruptedException {
        $(By.id("prompt")).click();
        prompt("Brad Pitt");
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");

    }

    public void sweetAlert() {
    $(By.id("modern")).click();
    $(By.cssSelector("button[aria-label='close']")).click();
    }
}



