package xyz.kinyanjui.managementservice;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import xyz.kinyanjui.managementservice.configs.GlobalVariables;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort(){
        ProcessBuilder processBuilder = new ProcessBuilder();
        String port = processBuilder.environment().get(GlobalVariables.PORT);
        if (port != null)
            return Integer.parseInt(port);
        return 4567;
    }
    public static void main(String[] args){
        port(getHerokuAssignedPort());
        staticFileLocation(GlobalVariables.PUBLIC);

        get(GlobalVariables.HOME_PATH, ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, GlobalVariables.INDEX_HBS);
        }));

        get(GlobalVariables.EMPLOYEE_PATH, ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, GlobalVariables.EMPLOYEE_HBS);
        }));

        get(GlobalVariables.DEPARTMENT_PATH, ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, GlobalVariables.DEPARTMENT_HBS);
        }));

        get(GlobalVariables.ROLES_PATH, ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, GlobalVariables.ROLES_HBS);
        }));
    }

    public static String render(Map<String, Object> model, String path){
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, path));
    }
}
