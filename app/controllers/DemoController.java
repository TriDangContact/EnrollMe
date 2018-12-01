package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class DemoController extends Controller {

//    Faculty components
    public Result facultyAll() {
        return ok(views.html.faculty.all.render());
    }

    public Result facultyNew() {
        return ok(views.html.faculty.create.render());
    }

    public Result facultyCreate() { return ok(); }

    public Result facultyView() { return ok(views.html.faculty.view.render()); }

    public Result facultyEdit() { return ok(views.html.faculty.edit.render()); }

    public Result facultyDelete() { return ok(); }


//    Course components
    public Result courseAll() { return ok(views.html.course.all.render()); }

    public Result courseNew() { return ok(views.html.course.create.render()); }

    public Result courseCreate() { return ok(); }

    public Result courseView() { return ok(views.html.course.view.render()); }

    public Result courseEdit() { return ok(views.html.course.edit.render()); }

    public Result courseDelete() { return ok(); }


}
