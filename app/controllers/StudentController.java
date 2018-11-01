package controllers;

import models.Major;
import models.Student;
import play.data.Form;
import play.data.FormFactory;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;
import repository.MajorRepository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionStage;

public class StudentController extends Controller {

    private final FormFactory formFactory;
    private final MajorRepository majorRepository;
    private final HttpExecutionContext httpExecutionContext;

    @Inject
    public StudentController(FormFactory formFactory, MajorRepository majorRepository, HttpExecutionContext httpExecutionContext) {
        this.formFactory = formFactory;
        this.majorRepository = majorRepository;
        this.httpExecutionContext = httpExecutionContext;
    }

    public Result all() {
        return ok(views.html.student.list.render());
    }

    public Result show(Long id) {
        Student student = Student.find.byId(id);
        return ok(views.html.student.view.render(student));
    }

    public CompletionStage<Result> create() {
        Form<Student> studentForm = this.formFactory.form(Student.class);
        // Run majors db operation and then render the form
        return majorRepository.options().thenApplyAsync((Map<String, String> majors) -> {
            // This is the HTTP rendering thread context
            return ok(views.html.student.create.render(studentForm, majors));
        }, httpExecutionContext.current());
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
