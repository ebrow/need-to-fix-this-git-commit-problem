import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
  staticFileLocation("/public");
  String layout = "templates/layout.vtl";

  get("/", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("words", request.session().attribute("words"));
    model.put("template", "templates/index.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/words", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("words", Word.all());
    model.put("template", "templates/words.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("words/new", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/define-words-form.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  // post("/words", (request, response) -> {
  //   HashMap<String, Object> model = new HashMap<String, Object>();
  //   String description = request.queryParams("description");
  //   Word newWord = new Word(description);
  //   model.put("words", newWord);
  //   model.put("template", "templates/success.vtl");
  //   return new ModelAndView(model, layout);
  // },  new VelocityTemplateEngine());

  post("/words", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    Define define = Define.find(Integer.parseInt(request.queryParams("defineId")));

    String description = request.queryParams("description");
    Word newWord = new Word(description);
    Define.addWord(newWord);
    //Define.addWord(newWord);

    model.put("words", define.getWords());
    model.put("define", define);
    model.put("template", "templates/define.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

 get("/words/:id", (request, response) -> {
   HashMap<String, Object> model = new HashMap<String, Object>();
   Word Word = Word.find(Integer.parseInt(request.params(":id")));
   model.put("word", word);
   model.put("template", "templates/word.vtl");
   return new ModelAndView(model, layout);
 }, new VelocityTemplateEngine());

  get("/defines", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("define", Define.all());
    model.put("template", "templates/define.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("defines/new", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/defines-form.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/defines", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    String name = request.queryParams("name");
    Define newDefine = new Define(name);
    model.put("define", newDefine);
    model.put("template", "templates/success.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/defines/:id", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    Define Define = Define.find(Integer.parseInt(request.params(":id")));
    model.put("define", define);

    model.put("template", "templates/Define.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/defines/:id/Words/new", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    Define Define = Define.find(Integer.parseInt(request.params(":id")));
    ArrayList<Word> words = Define.getWords();

    model.put("define", define);
    model.put("words", words);
    model.put("template", "templates/define-words-form.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());


 }
}
