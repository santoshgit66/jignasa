package com.todotracker.topic.controller;

import com.todotracker.topic.model.Topic;
import com.todotracker.topic.model.TopicRegistrationRequest;
import com.todotracker.topic.services.TopicService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/topics")
@AllArgsConstructor
public class TopicController {

    private final TopicService topicService;

    @PostMapping(value = "createTopic")
    public void createTopic(@RequestBody TopicRegistrationRequest topicRegistrationRequest) {
        log.info("new topic registration {}", topicRegistrationRequest);
        topicService.createTopic(topicRegistrationRequest);
    }

    @GetMapping(value = "/getAllTopics")
    @ResponseStatus(HttpStatus.OK)
    public List<Topic> getAllTopics() {
        List<Topic> allTopics = topicService.getAllTopics();
        return allTopics;
    }

    @PutMapping(value = "/updateTopic")
    @ResponseStatus(HttpStatus.OK)
    public void updateTopicById(@RequestBody Topic topic) {
        topicService.updateTopicByID(topic);
    }
}
