import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

public class SolutionEnterprizeGitHub {

    @Test
    void jUnit5codechecker() {

        Configuration.holdBrowserOpen = true;
        //open Selenide in Github
        open("https://github.com");

        $$(".header-menu-wrapper ul li button").filterBy(Condition.text("Solutions")).first()
            .hover();
        $("#solutions-for-heading").parent().$("ul li a").click();

        $("#hero-section-brand-heading").shouldHave(Condition.text("The AI-powered"));
    }
}