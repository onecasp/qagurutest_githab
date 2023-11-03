import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.Test;

public class DragAndDrop {


    @Test
    void jUnit5codechecker() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(exactText("A"));
        $("#column-b").shouldHave(exactText("A"));
    }
}
