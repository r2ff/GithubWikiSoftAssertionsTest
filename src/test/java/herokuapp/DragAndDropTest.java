package herokuapp;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class DragAndDropTest {

    @BeforeAll
    static void setupConfig() {
        //log.info("@BeforeAll method");
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @Test
    void dragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-a").shouldHave(text("B"));
    }

    //не работает
    @Test
    void dragAndDropWithActionsTest() {

        open("https://the-internet.herokuapp.com/drag_and_drop");
        var dragdropaction = actions().clickAndHold($("#column-a")).moveToElement($("column-b")).release($("#column-b")).build();
        dragdropaction.perform();
        $("#column-a").shouldHave(text("B"));

    }

}
