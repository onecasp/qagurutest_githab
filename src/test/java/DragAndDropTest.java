import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

public class DragAndDropTest {


    @Test
    void MoveByDragAndDrop() {
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

    @Test
    void MoveByActions() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //check firstly if blocks are in correct positions
        $("#column-a").shouldHave(exactText("A"));
        $("#column-b").shouldHave(exactText("B"));

        //move them (drag and drop) by wedElement.dragAndDrop
        SelenideElement element = $("#column-a");
        actions().dragAndDropBy(element, 200, 0).perform();

        //check if blocks are in correct positions afer moving
        $("#column-a").shouldHave(exactText("B"));
        $("#column-b").shouldHave(exactText("A"));
    }
}
