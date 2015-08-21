import java.util.ArrayList;
import java.time.LocalDateTime;

public class Category { //class Category
    private int mId;
    private String mName;
    private static ArrayList<Category> instances = new ArrayList<Category>();
    private ArrayList<Task> mTasks;

  public Category(String name) {
    mName = name;
    instances.add(this); //add(this) adds this Category object being created to the ArrayListCategory
    mId = instances.size(); //persists across all unit tests
    mTasks = new ArrayList<Task>();// number of objects in array list
  }// constructor has all the instructions for making a new instance of the class task
  //constructors are named after the class, they are actually methods

  public String getName(){
    return mName;
  }

  public int getId(){
    return mId;
  }

  public ArrayList<Task> getTasks() {
    return mTasks;
  }

  public void addTask(Task task){
    mTasks.add(task); //this method will get input from elsewhere
  }

  public static ArrayList<Category> all() {
    return instances;
  }

  public static void clear() {
    instances.clear(); //dumps everything out of instances object
  }

  public static Category find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }
} //class Task
