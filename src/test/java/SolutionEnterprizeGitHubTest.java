import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

public class SolutionEnterprizeGitHubTest {

    @Test
    void hoverAndEnterprizePageOpening() {

        open("https://github.com");

        $$(".header-menu-wrapper ul li button").filterBy(Condition.text("Solutions")).first()
            .hover();
        $("#solutions-for-heading").parent().$("ul li a").click();

        $("#hero-section-brand-heading").shouldHave(Condition.text("The AI-powered"));
    }
}