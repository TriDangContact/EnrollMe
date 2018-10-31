package controllers;

import models.Major;
import models.Student;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;

public class StudentController extends Controller {

    private final FormFactory formFactory;

    @Inject
    public StudentController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    public Result all() {
        return ok(views.html.student.list.render());
    }

    public Result show(Long id) {
        Student student = Student.find.byId(id);
        return ok(views.html.student.view.render(student));
    }

    public Result create() {
        Form<Student> studentForm = this.formFactory.form(Student.class);
        List<Major> majors = Major.find.all();
        HashMap<String, String> options = new HashMap<>();
        for (Major major : majors) {
            options.put(Integer.toString(major.getId()), major.getName());
        }
        return ok(views.html.student.create.render(studentForm, options));
    }

    public Result save() {
        Form<Student> studentForm = this.formFactory.form(Student.class);
        Student student = studentForm.bindFromRequest().get();
        student.save();

        return redirect("/student/show/" + student.getId());
    }

    public Result edit(Long id) {
        return ok();
    }

    public Result delete(Long id) {
        return ok();
    }
}
