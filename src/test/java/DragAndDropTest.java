import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.Test;

public class DragAndDropTest {


    @Test
    void DragAndDropBySelenide() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //check firstly if blocks are in correct positions
        $("#column-a").shouldHave(exactText("A"));
        $("#column-b").shouldHave(exactText("B"));

        //move them (drag and drop) by wedElement.dragAndDrop
        $("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));

        //check if blocks are in correct positions afer moving
        $("#column-a").shouldHave(exactText("B"));
        $("#column-b").shouldHave(exactText("A"));
    }
}
