import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

public class DragAndDropTest {


    SelenideElement elementA = $("#column-a");
    SelenideElement elementB = $("#column-b");
    @Test
    void moveByDragAndDrop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //check firstly if blocks are in correct positions
        elementA.shouldHave(exactText("A"));
        elementB.shouldHave(exactText("B"));

        //move them (drag and drop) by wedElement.dragAndDrop
        elementA.dragAndDrop(DragAndDropOptions.to(elementB));

        //check if blocks are in correct positions after moving
        elementA.shouldHave(exactText("B"));
        elementB.shouldHave(exactText("A"));
    }

    @Test
    void moveByActions() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //check firstly if blocks are in correct positions
        elementA.shouldHave(exactText("A"));
        elementB.shouldHave(exactText("B"));

        //move them (drag and drop) by wedElement.dragAndDrop

        actions().dragAndDropBy(elementA, 200, 0).perform();

        //check if blocks are in correct positions after moving
        elementA.shouldHave(exactText("B"));
        elementB.shouldHave(exactText("A"));
    }
}
