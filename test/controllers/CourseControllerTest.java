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
//import static play.mvc.Results.ok;
import static play.test.Helpers.*;

public class CourseControllerTest extends WithApplication {

//    Environment Setting
//    https://www.playframework.com/documentation/2.6.x/JavaTestingWithGuice

    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }

    @Test
    public void CourseIndexTest() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/course");
        Result result = route(app, request);
        assertEquals(OK, result.status());
        assertTrue(contentAsString(result).contains("All Courses"));


//        request = request.uri("/course/new");
//        result = route(app, request);
//
//        assertEquals(OK, result.status());
//        assertTrue(contentAsString(result).contains("New Course"));
//
//
//        request = request.uri("/course/edit");
//        result = route(app, request);
//
//        assertEquals(OK, result.status());
//        assertTrue(contentAsString(result).contains("Edit Course"));
//
//        request = request.method(POST).uri("/course/create");
//        result = route(app, request);
//
//
//        assertEquals(OK, result.status());
//        assertTrue(contentAsString(result).contains("New Course"));

//        System.out.println("-------/course/create-----------------------------------------------------------");
//        System.out.println("-------/course/create Status:" + result.status());
        //        assertEquals(new CourseController().edit(),result);

    }

    @Test
    public void CourseNewTest(){
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/course/new");
        Result result = route(app, request);
        assertEquals(OK, result.status());
        assertTrue(contentAsString(result).contains("New Course"));
    }

    @Test
    public void CourseEditTest(){
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/course/edit");
        Result result = route(app, request);
        assertEquals(OK, result.status());
        assertTrue(contentAsString(result).contains("Edit Course"));
    }

    @Test
    public void CourseCreateTest(){
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(POST)
                .uri("/course/create");
        Result result = route(app, request);
        assertEquals(OK, result.status());
        assertTrue(contentAsString(result).contains("New Course"));
    }

}

