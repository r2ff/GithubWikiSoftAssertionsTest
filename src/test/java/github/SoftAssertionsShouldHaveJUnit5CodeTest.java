package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class SoftAssertionsShouldHaveJUnit5CodeTest {

    @BeforeAll
    static void setupConfig() {
        //log.info("@BeforeAll method");
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @Test
    void softAssertionsShouldHaveJUnit5CodeTest() {

        open("https://github.com/selenide/selenide");
        $(byText("Wiki")).click();
        $(withText("more pages")).scrollTo().click();
        $$("#wiki-pages-box li").findBy(text("SoftAssertions")).click();
        $$("#wiki-body").findBy(text("Using JUnit5 extend test class")).shouldBe(visible);
        sleep(5000);
    }
}
