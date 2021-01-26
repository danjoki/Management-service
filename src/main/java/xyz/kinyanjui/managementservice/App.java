package xyz.kinyanjui.managementservice;

import xyz.kinyanjui.managementservice.configs.GlobalVariables;

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
    }
}
