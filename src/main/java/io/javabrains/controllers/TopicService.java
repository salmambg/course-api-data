package io.javabrains.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
    public class TopicService {

        @Autowired
        private TopicRepository topicRepository;

//        private List<Topic> topics = new ArrayList<>(Arrays.asList(
//                new Topic("Spring", "Spring Framework","Spring FrameWork Description"),
//                new Topic("Java", "JavaCore Framework","Java Description"),
//                new Topic("Javascript", "JavaScript Framework","JavaScript Description")
//        ));

        public List<Topic> getAllTopics() {
            List<Topic> topics = new ArrayList<>();
            topicRepository.findAll().forEach(topics:: add);
            return topics;
        }

        public Topic getTopic(String id) {
            //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
            Optional<Topic> topic = topicRepository.findById(id);
            return topic.orElse(null);
        }

        public void addTopic(Topic topic) {
            topicRepository.save(topic);
        }

        public void updateTopic(String id, Topic topic) {
          topicRepository.save(topic);
        }
        public void deleteTopic(String id) {
            topicRepository.deleteById(id);
        }

}
