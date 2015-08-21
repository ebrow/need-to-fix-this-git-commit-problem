import java.util.ArrayList;

public class Definition {
  private static ArrayList<Define> defines = new ArrayList<Define>();

  private String mDefine;
  private int mId;
  private ArrayList<Word> mWord;


  public Define(String name) {
    mPhrase = phrase;
    defines.add(this);
    mId = defines.size();
    mWords = new ArrayList<Word>();
  }

  public String getPhrase() {
    return mPhrase;
  }

  public int getId() {
    return mId;
  }

  public static ArrayList<Define> all() {
    return defines;
  }

  public ArrayList<Word> getWords() {
    return mWords;
  }

  public static void clear() {
    defines.clear();
  }

  public void addTask(Task task) {
    mWords.add(word);
  }

  public static Define find(int id) {
    try {
      return defines.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }
}
