import static com.codeborne.selenide.Condition.exactOwnTextCaseSensitive;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.textCaseSensitive;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.CollectionCondition;
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
        $("#wiki-body").shouldHave(text("Welcome to the selenide wiki!"));

        // - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $$("[data-filterable-for=wiki-pages-filter] li a").should(
            CollectionCondition.containExactTextsCaseSensitive("SoftAssertions"));

        //раскрыть список, чтоб сделать элемент clickable
        $(".wiki-more-pages-link button").click();

        //кликнуть на "SoftAssertions"
        $$("[data-filterable-for=wiki-pages-filter] li a").filterBy(text("SoftAssertions")).first()
            .click();

        //убедимся, что мы на нужной странице
        $(".repository-content h1").shouldHave(text("SoftAssertions"));

        //искомые строки кода
        String JUnit5Code1 = "@ExtendWith({SoftAssertsExtension.class})\n"
            + "class Tests {\n"
            + "  @Test\n"
            + "  void test() {\n"
            + "    Configuration.assertionMode = SOFT;\n"
            + "    open(\"page.html\");\n"
            + "\n"
            + "    $(\"#first\").should(visible).click();\n"
            + "    $(\"#second\").should(visible).click();\n"
            + "  }\n"
            + "}";

        String JUnit5Code2 = "class Tests {\n"
            + "  @RegisterExtension \n"
            + "  static SoftAssertsExtension softAsserts = new SoftAssertsExtension();\n"
            + "\n"
            + "  @Test\n"
            + "  void test() {\n"
            + "    Configuration.assertionMode = SOFT;\n"
            + "    open(\"page.html\");\n"
            + "\n"
            + "    $(\"#first\").should(visible).click();\n"
            + "    $(\"#second\").should(visible).click();\n"
            + "  }\n"
            + "}";

        //проверка наличия кода
        $("#wiki-body").shouldHave(text(JUnit5Code1));
        $("#wiki-body").shouldHave(text(JUnit5Code2));
    }
}
