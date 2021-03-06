import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Arrays;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/home.vtl");

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/results", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/results.vtl");

      String userInput = request.queryParams("phrase");
      String vowelReplacer = vowelReplacer(userInput);
      model.put("vowelReplacer", vowelReplacer);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }


  public static String vowelReplacer (String userInput) {
    String phrase = userInput;
    String phraseResults = phrase.replaceAll("[AEIOUaeiou]", "-");
    return phraseResults;

  }
}
