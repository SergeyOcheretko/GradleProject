package testSuite;

import BaseTest.BaseTest;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.InteractWithSelectAndAlertFieldsPage;

public class TestInteractWithSelectAndAlertFieldsSuite extends BaseTest {

    private InteractWithSelectAndAlertFieldsPage interactWithSelectAndAlertFieldsPage;

    @BeforeClass
    public void setUpBeforeClassSelectAndAlert() {
        interactWithSelectAndAlertFieldsPage = Selenide.page(InteractWithSelectAndAlertFieldsPage.class);
    }


    @Test(description = "Открытие страницы Letcode")
    public void openLetcodePage() {
        interactWithSelectAndAlertFieldsPage.open();
        interactWithSelectAndAlertFieldsPage.checkPageOpened();
    }

    @Test(description = "Open Drop-Down Page")
    public void openSelectPage() throws InterruptedException {
        interactWithSelectAndAlertFieldsPage.open();
        interactWithSelectAndAlertFieldsPage.clickOnTheEditButton("Drop-Down");
        interactWithSelectAndAlertFieldsPage.verifyOpenPage("Dropdown");

    }

    @Test(description = "Open Alert Page")
    public void openDialogPage() throws InterruptedException {
        interactWithSelectAndAlertFieldsPage.open();
        interactWithSelectAndAlertFieldsPage.clickOnTheEditButton("Dialog");
        interactWithSelectAndAlertFieldsPage.verifyOpenPage("Alert");
    }


    @Test(description = "Testing Dropdown page")
    public void testingDropdownPage() throws InterruptedException {
        interactWithSelectAndAlertFieldsPage.open();
        interactWithSelectAndAlertFieldsPage.clickOnTheEditButton("Drop-Down");
        interactWithSelectAndAlertFieldsPage.selectAppleUsingVisibleText();
        interactWithSelectAndAlertFieldsPage.checkThatAppleIsChosen();
        interactWithSelectAndAlertFieldsPage.selectMultipleOptionsFromDropDown();
    }

//@Test(description = "Testing Alert page")
//    public void testingAlertPage() throws InterruptedException {
//    interactWithSelectAndAlertFieldsPage.open();
//    interactWithSelectAndAlertFieldsPage.clickOnTheEditButton("Dialog");
//    interactWithSelectAndAlertFieldsPage.acceptTheAlert();
//   interactWithSelectAndAlertFieldsPage.dismissTheAlertPrintTheAlertText();
//    interactWithSelectAndAlertFieldsPage.typeYourNameAccept();
//   interactWithSelectAndAlertFieldsPage.sweetAlert();
//
//}


}








