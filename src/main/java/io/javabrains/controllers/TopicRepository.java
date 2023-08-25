package io.javabrains.controllers;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic,String> {
    //getAllTopics()
    //getTopic(String id)
    // updateTopic(Topic t)
    //deleteTopic(String id)
}
