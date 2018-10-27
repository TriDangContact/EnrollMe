package controllers;

import models.Student;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

public class StudentController extends Controller {

    private final FormFactory formFactory;

    @Inject
    public StudentController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    public Result newUser() {
        Form<Student> studentForm = this.formFactory.form(Student.class);
        return ok(views.html.user.create.render(studentForm));
    }

    public Result create() {
        Form<Student> studentForm = this.formFactory.form(Student.class);
        Student studnet = studentForm.bindFromRequest().get();
        studnet.save();

        return ok();
    }

    public Result edit() {
        return ok();
    }

    public Result delete() {
        return ok();
    }
}
