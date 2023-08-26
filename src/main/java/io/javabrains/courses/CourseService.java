package io.javabrains.courses;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
    public class CourseService {

        @Autowired
        private CourseRepository courseRepository;

//        private List<Topic> topics = new ArrayList<>(Arrays.asList(
//                new Topic("Spring", "Spring Framework","Spring FrameWork Description"),
//                new Topic("Java", "JavaCore Framework","Java Description"),
//                new Topic("Javascript", "JavaScript Framework","JavaScript Description")
//        ));

        public List<Course> getAllCourses() {
            return courseRepository.findAll();
        }


        public Course getCourse(String id) {
            //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
            Optional<Course> course = courseRepository.findById(id);
            return course.orElse(null);
        }

        public void addCourse(Course course) {
            courseRepository.save(course);
        }

        public Course getCourseById(String id) {
            Optional<Course> course = courseRepository.findById(id);
            return course.orElse(null);
        }

        public void updateCourse(String id , Course course) {
            Course dbCourse = getCourseById(id);
            dbCourse.setName(course.getName());
            dbCourse.setDescription(course.getDescription());
            courseRepository.save(dbCourse);
        }
        public void deleteCourse(String id) {
            courseRepository.deleteById(id);
        }

}
