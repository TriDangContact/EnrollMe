package controllers;

import org.junit.Test;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Result;
import play.test.WithApplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.*;

//import static play.mvc.Results.ok;

public class StudentControllerTest extends WithApplication {

//    Environment Setting
//    https://www.playframework.com/documentation/2.6.x/JavaTestingWithGuice

    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }

    @Test
    public void StudentAllTest() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/student/all");
        Result result = route(app, request);
        assertEquals(OK, result.status());
        assertTrue(contentAsString(result).contains("User"));
    }

    @Test
    public void StudentNewTest(){
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/student/new");
        Result result = route(app, request);
        assertEquals(OK, result.status());
        assertTrue(contentAsString(result).contains("Create Student"));
    }

    @Test
    public void CourseSaveTest(){
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/student/save");
        Result result = route(app, request);
        assertEquals(NOT_FOUND, result.status());
//        assertTrue(contentAsString(result).contains("Edit Student"));
    }

//    @Test
//    public void CourseShowTest(){
//        Http.RequestBuilder request = new Http.RequestBuilder()
//                .method(GET)
//                .uri("/student/show/:id ");
//        Result result = route(app, request);
//        assertEquals(NOT_FOUND, result.status());
//        assertTrue(contentAsString(result).contains("Edit Student"));
//    }

}

