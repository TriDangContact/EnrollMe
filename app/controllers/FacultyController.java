package controllers;

import models.Faculty;
import models.Department;
import play.data.Form;
import play.data.FormFactory;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;
//import repository.DepartmentRepository;
//import repository.FacultyRepository;

import javax.inject.Inject;
import java.util.Map;
import java.util.concurrent.CompletionStage;

public class FacultyController extends Controller {

    private final FormFactory formFactory;
    //private final DepartmentRepository departmentRepository;
    //private final FacultyRepository facultyRepository;
    private final HttpExecutionContext httpExecutionContext;

    @Inject
    public FacultyController(FormFactory formFactory,
                             //DepartmentRepository departmentRepository,
                             //FacultyRepository facultyRepository,
                             HttpExecutionContext httpExecutionContext) {
        this.formFactory = formFactory;
        //this.departmentRepository = departmentRepository;
        //this.facultyRepository = facultyRepository;
        this.httpExecutionContext = httpExecutionContext;
    }


    public Result all() {
        return ok(views.html.faculty.all.render());
    }

    public Result show(Long id) {
        Faculty faculty = Faculty.find.byId(id);
        return ok(views.html.faculty.view.render(faculty));
    }
    /*
    public CompletionStage<Result> create() {
        Form<Faculty> facultyForm = this.formFactory.form(Faculty.class);
        // Run majors db operation and then render the form
        return departmentRepository.options().thenApplyAsync((Map<String, String> department) ->
                ok(views.html.faculty.create.render(facultyForm, department)), httpExecutionContext.current());
    }

    public CompletionStage<Result> save() {
        Form<Faculty> facultyForm = this.formFactory.form(Faculty.class).bindFromRequest();
        Faculty faculty = facultyForm.get();

        return facultyRepository.insert(faculty).thenApplyAsync(facultyId ->
                redirect(routes.facultyController.show(facultyId)), httpExecutionContext.current()
        );
    }

    public CompletionStage<Result> edit(Long id) {
        CompletionStage<Map<String, String>> majorsOptions = majorRepository.options();

        return studentRepository.lookup(id).thenCombineAsync(majorsOptions, (studentOptional, majors) -> {
            Student student = studentOptional.get();
            Form<Student> studentForm = this.formFactory.form(Student.class).fill(student);
            return ok(views.html.student.edit.render(id, studentForm, majors));
        }, httpExecutionContext.current());
    }

    public CompletionStage<Result> update(Long id) {
        Form<Student> studentForm = this.formFactory.form(Student.class).bindFromRequest();
        Student student = studentForm.get();

        return studentRepository.update(id, student).thenApplyAsync(studentId ->
                redirect(routes.StudentController.show(studentId.get())), httpExecutionContext.current()
        );
    }
*/
    public Result delete(Long id) {
        return ok();
    }
    
}
