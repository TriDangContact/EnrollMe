package views.course;

import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.junit.Test;
import play.api.test.TestServer;
import play.libs.ws.WSClient;
import play.libs.ws.WSResponse;
import play.test.WithBrowser;
import play.test.WithServer;
import scala.Option;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionStage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.testServer;

public class CourseAllViewTest extends WithBrowser {

    @Test
    public void runInBrowser() {
//        System.out.println("-------------------------------------------------------");
//        System.out.println("=============Test Start! ==============================");
//        System.out.println("-------------------------------------------------------");

        browser.goTo("/course");
        assertNotNull(browser.$("title").text());
        assertNotNull(browser.$("h1").text());
        assertNotNull(browser.$("div").text());
        assertEquals("All Courses",browser.$("title").text());

//        System.out.println("------------------------------------------------------------------");
//        System.out.println("=================Test data information! ===========================");
//        System.out.println("------------------------------------------------------------------");

        FluentList<FluentWebElement> TableElement = browser.$("table");
        FluentList<FluentWebElement> colItems = TableElement.$("th");
        List<String> TableColumnItems = new ArrayList<>();

        for (FluentWebElement colItem: colItems
        ) {
            TableColumnItems.add(colItem.text());
//            System.out.println("Col:" + colItem.text());
//            System.out.println("div:\n" + browser.$("div").text());
        }
        assertTrue(TableColumnItems.contains("Course ID"));
        assertTrue(TableColumnItems.contains("Schedule#"));
        assertTrue(TableColumnItems.contains("Course Name"));
        assertTrue(TableColumnItems.contains("Units"));
        assertTrue(TableColumnItems.contains("Day"));
        assertTrue(TableColumnItems.contains("Time"));
        assertTrue(TableColumnItems.contains("Location"));
        assertTrue(TableColumnItems.contains("Instructor"));
        assertTrue(TableColumnItems.contains("Seats"));

//        System.out.println("Title:");
//        System.out.println(browser.$("title").text());
//        System.out.println("----------===========================================------------");
//        System.out.println("div:\n" + browser.$("div").text());
//        System.out.println("-----------===========================================------------");
//        System.out.println("hi:\n" + browser.$("h1").text());
//        System.out.println("-----------===========================================------------");

    }

}
