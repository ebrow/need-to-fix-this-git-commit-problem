
import java.util.ArrayList;

import org.junit.*;
import static org.junit.Assert.*;

public class DefineTest {

  @Test
  public void getName_returnsName_true() {
    Define testDefine = new Define("void");
    assertEquals("void", testDefine.getName());
  }

  @Test
  public void getId_returnsDefineId() {
    Define testDefine = new Define("char");
    assertTrue(Define.all().size() == testDefine.getId());
  }

  @Test
  public void getWords_initiallyReturnsEmptyArrayList() {
    Define testDefine = new Define("char");
    assertTrue(testDefine.getWords() instanceof ArrayList);
  }

  @Test
  public void all_returnsAllInstancesOfWord_true() {
    Define firstDefine = new Define("public");
    Define secondDefine = new Define("boolean");
    assertTrue(Define.all().contains(firstDefine));
    assertTrue(Define.all().contains(secondDefine));
  }

  @Test
  public void clear_removesAllDefineInstancesFromMemory() {
    Define testDefine = new Define("public");
    Define.clear();
    assertEquals(Define.all().size(), 0);
  }

  @Test
  public void find_returnsDefineWithSameId() {
    Define testDefine = new Define("public");
    assertEquals(Define.find(testDefine.getId()), testDefine);
  }

  @Test
  public void addWord_addsWordToList() {
    Define testDefine = new Define("instance variable");
    Word testWord = new Word("char");
    testDefine.addWord(testWord);
    assertTrue(testDefine.getWords().contains(testWord));
  }
}
