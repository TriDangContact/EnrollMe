package controllers;

import models.Login;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

public class LoginController extends Controller {


    private final FormFactory formFactory;

    @Inject
    public LoginController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    public Result login() {
        Form<Login> loginForm = this.formFactory.form(Login.class);
        return ok(views.html.login.render(loginForm));
    }

}
