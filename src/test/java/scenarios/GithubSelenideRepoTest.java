package scenarios;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubSelenideRepoTest {

    public static final String JUNIT5_EXAMPLE_CODE_PATH = "//*[text()='Using JUnit5 extend test class:']/parent::ol/following-sibling::div[contains(@class,'source-java')][1]";

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    final void shouldDisplayExampleCodeForJunit5OnTheSoftAssertionsPage() {
        open("https://github.com/selenide/selenide");
        $("[data-content=Wiki]").click();
        $$("#wiki-body li a").shouldHave(itemWithText("Soft assertions"));
        $(byText("Soft assertions")).click();
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
        $x(JUNIT5_EXAMPLE_CODE_PATH).shouldBe(visible);
    }
}
