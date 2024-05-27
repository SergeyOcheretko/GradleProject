package BaseTest;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    public static final String BASE_URL = "https://letcode.in/test";


    @BeforeTest
    @Parameters({"browser"})
    public void beforeTest(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            Configuration.browser = "firefox";
        } else if (browser.equalsIgnoreCase("chrome")) {
            Configuration.browser = "chrome";
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        Configuration.timeout = 5000; // Устанавливаем время ожидания по умолчанию
        open(BASE_URL);
        getWebDriver().manage().window().maximize();
    }

    @AfterTest
    public void shutsDownTheBrowser() {
        WebDriver driver = getWebDriver();
        driver.quit();
    }
}

