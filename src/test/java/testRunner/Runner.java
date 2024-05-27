package testRunner;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import org.testng.xml.XmlClass;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        TestNG testng = new TestNG();

        // Список тестовых классов
        List<String> testClasses = Arrays.asList(
                "testSuite.TestInteractWithInputAndButtonFieldsSuite",
                "testSuite.TestInteractWithSelectAndAlertFieldsSuite",
                "testSuite.TestInteractWithFramesAndIframeFieldsSuite"
        );

        // Создаем и добавляем сьюты в TestNG
        List<XmlSuite> suites = testClasses.stream()
                .map(className -> createSuite("SuiteFor" + className, className))
                .collect(Collectors.toList());

        testng.setXmlSuites(suites);
        testng.run();
    }

    private static XmlSuite createSuite(String suiteName, String className) {
        XmlSuite suite = new XmlSuite();
        suite.setName(suiteName);

        XmlTest test = new XmlTest(suite);
        test.setName(className);
        test.setXmlClasses(Collections.singletonList(new XmlClass(className)));

        return suite;
    }
}

