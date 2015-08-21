import org.junit.*;
import static org.junit.Assert.*;

public class VowelReplacerTest {

 @Test
 public void vowelReplacer_replacesVowelsWithDashes_correctString () {
   assertEquals("- h-v- tw- c-ts.", App.vowelReplacer("I have two cats."));
  }

  @Test
  public void vowelReplacer_replacesCapitalizedVowels_correctstring () {
   assertEquals("-ct--lly, - h-v- - d-g.", App.vowelReplacer("Actually, I have a dog."));
  }
 }
