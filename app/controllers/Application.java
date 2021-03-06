package controllers;

import play.Routes;
import play.mvc.*;
import views.html.error;
import views.html.index;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("Welcome to MindsEye"));
    }

    /**
     * May find helpful here:
     *     https://stackoverflow.com/q/11133059
     *     https://www.playframework.com/documentation/2.1.1/JavaGuide6
     * @return
     */
    public Result javascriptRoutes() {
        response().setContentType("text/javascript");
        return ok(
            Routes.javascriptRouter("jsRoutes",
                controllers.routes.javascript.Visit.getAll()
            )
        );
    }

    public Result handleError(int id){
        Result res = null;
        switch(id){
            case 400:
                res = badRequest(error.render(id + " Bad Request"));
                break;
            case 500:
                res = badRequest(error.render(id + " Internal Error"));
                break;
        }
        return res;
    }
}
