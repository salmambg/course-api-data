package io.javabrains.courses;

import io.javabrains.controllers.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // whatever you return is get automatically converted to json and sent back as the http response
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @RequestMapping("/topics/{topicId}/courses/{id}") //this is a path
    public Course getCourse(@PathVariable String id) { //by making curly braces and put a token as a variable part for Spring MVC
        // now spring to send that variable in the argument of the method , we have to use another annotation path variable to get the variable from the path
        return courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/courses/{id}/topics/{topicId}") // topicId -> java
    public String addCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
        course.setTopic(new Topic(topicId, "", "" ));
        courseService.addCourse(course);
        return "Save Course Successfully";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/courses/{id}")
    public String updateTopic(@RequestBody Course course, @PathVariable String id) {
        courseService.updateCourse(id, course);
        return "Update Course Successfully";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/courses/{id}")
    public String deleteTopic(@PathVariable String id) {
        courseService.deleteCourse(id);
        return "Delete Course Successfully";
    }
}
