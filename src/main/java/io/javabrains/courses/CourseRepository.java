package io.javabrains.courses;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,String> {
    //getAllTopics()
    //getTopic(String id)
    // updateTopic(Topic t)
    //deleteTopic(String id)
}
