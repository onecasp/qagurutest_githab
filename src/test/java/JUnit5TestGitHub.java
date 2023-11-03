import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;

public class JUnit5TestGitHub {

    @Test
    void jUnit5codechecker() {


        //open Selenide in Github
        open("https://github.com/selenide/selenide");

        // got to Wiki
        $("#wiki-tab").click();

        //check that we are on Wiki page
        $("#wiki-body").shouldHave(Condition.text("Welcome to the selenide wiki!"));

        // - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-box").$("a").shouldHave(Condition.text("SoftAssertions"));
        $("#wiki-pages-box").shouldHave(Condition.text("SoftAssertions"));

        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
    }

}
