import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import static java.lang.System.out;
import java.lang.*;

import java.util.Map;
import java.util.HashMap;

import spark.ModelAndView;

import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class Anagram{
  public static void main(String[] args) {

  }
//method takes in a user input and returns a String[] with every word worted into alphabetical order
  public static String[] sortWords(String userInput) {

    String [] splitInput= userInput.split(" ");
    String [] sortedWords = new String[100];
    for(int i = 0; i < splitInput.length; i++) {

        char[] word = splitInput[i].toCharArray();
        Arrays.sort(word);
        String strWord = String.valueOf(word);
        sortedWords[i] = strWord;
        }
    return sortedWords;
    }
}
