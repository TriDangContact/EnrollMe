package controllers;

import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

public class UserController extends Controller {

    private final FormFactory formFactory;

    @Inject
    public UserController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    public Result newUser() {
        Form<User> userForm = this.formFactory.form(User.class);
        return ok(views.html.user.create.render(userForm));
    }

    public Result create() {
        Form<User> userForm = this.formFactory.form(User.class);
        User user = userForm.bindFromRequest().get();
        user.save();

        return ok();
    }

    public Result edit() {
        return ok();
    }

    public Result delete() {
        return ok();
    }
}
