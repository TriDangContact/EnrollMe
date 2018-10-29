package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class SiteController extends Controller {

    public Result faq() {
        return ok(views.html.site.faq.render());
    }
}
