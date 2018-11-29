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

public class DemoControllerTest extends WithApplication {

    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }

    @Test
    public void DemoFacultyAllTest() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/demo/faculty/all");
        Result result = route(app, request);
        assertEquals(OK, result.status());

        assertTrue(contentAsString(result).contains("Users"));
        assertTrue(contentAsString(result).contains("Faculty ID"));
    }

    @Test
    public void DemoFacultyNewTest() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/demo/faculty/new");
        Result result = route(app, request);
        assertEquals(OK, result.status());

        assertTrue(contentAsString(result).contains("New Faculty"));
        assertTrue(contentAsString(result).contains("First Name"));
    }

    @Test
    public void DemoFacultyEditTest() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/demo/faculty/edit");
        Result result = route(app, request);
        assertEquals(OK, result.status());

//        assertTrue(contentAsString(result).contains("Edit Faculty"));
//        assertTrue(contentAsString(result).contains("Faculty ID:"));
    }

    @Test
    public void DemoFacultyViewTest() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/demo/faculty/view");
        Result result = route(app, request);
        assertEquals(OK, result.status());

        assertTrue(contentAsString(result).contains("View Faculty"));
        assertTrue(contentAsString(result).contains("Faculty ID:"));
    }

    @Test
    public void DemoStudentAllTest() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/demo/student/all");
        Result result = route(app, request);
        assertEquals(OK, result.status());

        assertTrue(contentAsString(result).contains("Users"));
        assertTrue(contentAsString(result).contains("Student ID"));
    }

    @Test
    public void DemoStudentNewTest() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/demo/student/new");
        Result result = route(app, request);
        assertEquals(OK, result.status());
    }

//    @Test
//    public void DemoStudentViewTest() {
//        Http.RequestBuilder request = new Http.RequestBuilder()
//                .method(GET)
//                .uri("/demo/student/view");
//        Result result = route(app, request);
//        assertEquals(OK, result.status());
//
//        assertTrue(contentAsString(result).contains("View Student"));
//        assertTrue(contentAsString(result).contains("Student ID:"));
//    }

    @Test
    public void DemoCourseAllTest() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/demo/course/all");
        Result result = route(app, request);
        assertEquals(OK, result.status());

        assertTrue(contentAsString(result).contains("All Courses"));
    }

    @Test
    public void DemoCourseNewTest() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/demo/course/new");
        Result result = route(app, request);
        assertEquals(OK, result.status());

        assertTrue(contentAsString(result).contains("New Course"));
        assertTrue(contentAsString(result).contains("Course ID"));
    }

    @Test
    public void DemoCourseEditTest() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/demo/course/edit");
        Result result = route(app, request);
        assertEquals(OK, result.status());

        assertTrue(contentAsString(result).contains("Edit Course"));
        assertTrue(contentAsString(result).contains("Course ID"));
    }

    @Test
    public void DemoCourseViewTest() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/demo/course/view");
        Result result = route(app, request);
        assertEquals(OK, result.status());

        assertTrue(contentAsString(result).contains("View Course"));
        assertTrue(contentAsString(result).contains("CourseID:"));
        assertTrue(contentAsString(result).contains("Schedule #:"));
        assertTrue(contentAsString(result).contains("Course Name:"));
    }

}

