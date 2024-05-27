package testSuite;

import BaseTest.BaseTest;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.InteractWithFramesAndIframePages;

public class TestInteractWithFramesAndIframeFieldsSuite extends BaseTest {

    private InteractWithFramesAndIframePages interactWithFramesAndCheckboxesPage;


    @BeforeClass
    public void setUpBeforeClassInputAndButton() {
        interactWithFramesAndCheckboxesPage = Selenide.page(InteractWithFramesAndIframePages.class);
    }


    @Test(description = "Open Frame Pages")
    public void openFramePage() throws InterruptedException {
        interactWithFramesAndCheckboxesPage.openLetcode();
        interactWithFramesAndCheckboxesPage.clickOnTheEditButton("Inner HTML");
        interactWithFramesAndCheckboxesPage.verifyOpenPage("Frame");
    }

     @Test(description = "Testing Frame page")
     public void testingFramePage() throws InterruptedException {
         interactWithFramesAndCheckboxesPage.openLetcode();
         interactWithFramesAndCheckboxesPage.clickOnTheEditButton("Inner HTML");
         interactWithFramesAndCheckboxesPage.enterFirstName("Tom");
         interactWithFramesAndCheckboxesPage.enterLastName("Hanks");
         interactWithFramesAndCheckboxesPage.checkEnteredName();
         interactWithFramesAndCheckboxesPage.enterEmail("s.eroeer@gmail.com");

     }


     @Test(description = "Open Radio & Checkbox page")
    public void openRadioCheckboxPage() throws InterruptedException {
         interactWithFramesAndCheckboxesPage.openLetcode();
         interactWithFramesAndCheckboxesPage.clickOnTheEditButton("Toggle");
         interactWithFramesAndCheckboxesPage.verifyOpenPage("Radio & Checkbox");
     }

@Test(description = "Testing Radio & Checkbox page")
 public void testingRadioCheckboxPage() throws InterruptedException {
    interactWithFramesAndCheckboxesPage.openLetcode();
    interactWithFramesAndCheckboxesPage.clickOnTheEditButton("Toggle");
    interactWithFramesAndCheckboxesPage.selectAllRadioButtons();
    }

}
