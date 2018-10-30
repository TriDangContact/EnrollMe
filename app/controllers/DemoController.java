package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class DemoController extends Controller {

    public Result facultyAll() {
        return ok(views.html.faculty.create.render());
    }

    public Result facultyNew() {
        return ok();
    }
}
