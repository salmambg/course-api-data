package io.javabrains.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // whatever you return is get automatically converted to json and sent back as the http response
public class TopicController {
    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic>getAllTopics() {
        return topicService.getAllTopics();

    }
    @RequestMapping("/topics/{id}") //this is a path
    public Topic getTopic(@PathVariable String id) { //by making curly braces and put a token as a variable part for Spring MVC
        // now spring to send that variable in the argument of the method , we have to use another annotation path variable to get the variable from the path
        return topicService.getTopic(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic,@PathVariable String id) {
        topicService.updateTopic(id ,topic);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
    }
}
