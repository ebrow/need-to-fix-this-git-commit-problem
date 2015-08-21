import org.junit.*;
import static org.junit.Assert.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.lang.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AnagramTest { //extends FluentTest {
    public WebDriver webDriver = new HtmlUnitDriver();
    public WebDriver getDefaultDriver() {
        return webDriver;
  }

    //@ClassRule
    //public static ServerRule server = new ServerRule();

    @Test
    public void sortWords_CheckReturnedArrayOfWords_true() {
        Anagram newAnagram = new Anagram();
        String input = "cat mac tac cam";
        assertEquals("acm", newAnagram.sortWords(input)[1]);
    }
}
