package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class CourseController extends Controller {

    public Result index() {
        return ok(views.html.course.show.render());
    }

    public Result newCourse() {
        return ok(views.html.course.create.render());
    }

    public Result create() {
        return ok(views.html.course.create.render());
    }

    public Result edit() {
        return ok(views.html.course.edit.render());
    }
}
