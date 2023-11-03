import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.Test;

public class JUnit5CodeCheckTest {
    @Test
    void jUnit5CodeChecker() {

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

        open("https://github.com/selenide/selenide");

        $("#wiki-tab").click();

        $("#wiki-body").shouldHave(text("Welcome to the selenide wiki!"));

        $$("[data-filterable-for=wiki-pages-filter] li a").should(
            CollectionCondition.containExactTextsCaseSensitive("SoftAssertions"));

        $(".wiki-more-pages-link button").click();

        $$("[data-filterable-for=wiki-pages-filter] li a").filterBy(text("SoftAssertions")).first()
            .click();

        $(".repository-content h1").shouldHave(text("SoftAssertions"));

        $("#wiki-body").shouldHave(text(JUnit5Code1));
        $("#wiki-body").shouldHave(text(JUnit5Code2));
    }

}
