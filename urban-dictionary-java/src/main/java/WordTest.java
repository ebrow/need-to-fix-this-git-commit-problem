
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class WordTest {

  @Test
  public void Word_instantiatesCorrectly_true() {
    Word myWord = new Word("static");
    assertEquals(true, myWord instanceof Word);
  }

  @Test
  public void Word_instantiatesWithDescription_true() {
    Word myWord = new Word("static");
    assertEquals("static", myWord.getDescription());
  }

  @Test
    public void isCompleted_isFalseAfterInstantiaon_false() {
      Word myWord = new Word("static");
      assertEquals(false, myWord.isCompleted());
    }

    @Test
    public void getCreateAt_instantiatesWithCurrentTime_today() {
      Word myWord = new Word("static");
      assertEquals(LocalDateTime.now().getDayOfWeek(), myWord.getCreatedAt().getDayOfWeek());
    }

    @Test
    public void all_returnsAllInstancesOfWord_true() {
      Word firstWord = new Word("static");
      Word secondWord = new Word("void");
      assertTrue(Word.all().contains(firstWord));
      assertTrue(Word.all().contains(secondWord));
    }

    @Test
    public void newId_WordsInstantiateWithAnID_true() {
      Word myWord = new Word("static");
      assertEquals(Word.all().size(), myWord.getId());
    }

    @Test
    public void find_returnsWordWithSameId_secondWord() {
      Word firstWord = new Word("static");
      Word secondWord = new Word("void");
      assertEquals(Word.find(secondWord.getId()), secondWord);
    }

    @Test
    public void find_returnsNullWhenNoWordFound_null() {
      assertTrue(Word.find(999) == null);
    }

    @Test
    public void clear_emptiesAllWordsFromArrayList() {
      Word myWord = new Word("int");
      Word.clear();
      assertEquals(Word.all().size(), 0);
    }

 }
