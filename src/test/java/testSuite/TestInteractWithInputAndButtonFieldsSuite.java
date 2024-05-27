package testSuite;

import BaseTest.BaseTest;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.InteractWithInputAndButtonFieldsPage;

public class TestInteractWithInputAndButtonFieldsSuite extends BaseTest {

    private InteractWithInputAndButtonFieldsPage interactWithInputAndButtonFieldsPage;

    @BeforeClass
    public void setUpBeforeClassInputAndButton() {
        interactWithInputAndButtonFieldsPage = Selenide.page(InteractWithInputAndButtonFieldsPage.class);
    }

    @Test(description = "Открытие страницы Letcode")
    public void openLetcodePage() {
        interactWithInputAndButtonFieldsPage.open();
        interactWithInputAndButtonFieldsPage.checkPageOpened();
    }

    @Test(description = "Open Input Page")
    public void openInputPage() throws InterruptedException {
        interactWithInputAndButtonFieldsPage.open();
        interactWithInputAndButtonFieldsPage.clickOnTheEditButton("Edit");
        interactWithInputAndButtonFieldsPage.verifyOpenPage("Input");

    }


    @Test(description = "Open Button Page")
    public void openButtonPage() throws InterruptedException {
        interactWithInputAndButtonFieldsPage.open();
        interactWithInputAndButtonFieldsPage.clickOnTheEditButton("Click");
        interactWithInputAndButtonFieldsPage.verifyOpenPage("Button");

    }

    @Test(description = "Working with Input page")
    public void interactWithinputPage() {
        interactWithInputAndButtonFieldsPage.open();
        interactWithInputAndButtonFieldsPage.clickOnTheEditButton("Edit");
        interactWithInputAndButtonFieldsPage.enterYourFullName();
        interactWithInputAndButtonFieldsPage.getAttribute();
        interactWithInputAndButtonFieldsPage.clearField();
        interactWithInputAndButtonFieldsPage.confirmEnabledField();
        interactWithInputAndButtonFieldsPage.confirmReadonleField();
    }

   @Test(description = "Working with Button page")
    public void interactWithButtonPage() throws InterruptedException {
       interactWithInputAndButtonFieldsPage.open();
       interactWithInputAndButtonFieldsPage.clickOnTheEditButton("Click");
       interactWithInputAndButtonFieldsPage.gotoHomeAndComeBackHereUsingDriverCommand();
       interactWithInputAndButtonFieldsPage.verifyOpenPage("Button");
      interactWithInputAndButtonFieldsPage.verifyButtonDisabled();
       interactWithInputAndButtonFieldsPage.clickAndHoldButton();
       interactWithInputAndButtonFieldsPage.verifyThatButtonIsHolded();
    }

}
