package com.todotracker.topic.services;

import com.todotracker.topic.model.Topic;
import com.todotracker.topic.model.TopicRegistrationRequest;
import com.todotracker.topic.repository.TopicRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class TopicService {

    private final TopicRepository topicRepository;

    public void createTopic(TopicRegistrationRequest request) {

        String pattern = "dd-MM-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        String currentDate = dateFormat.format(new Date());

        Topic topic = Topic.builder()
                .topicName(request.getTopicName())
                .topicDescription(request.getTopicDescription())
                .topicStatus(request.getTopicStatus())
                .attachments(request.getAttachments())
                .modifiedDate(currentDate)
                .createdDate(currentDate)
                .externalURL(request.getExternalURL())
                .attachmentNames(request.getAttachmentNames())
                .category(request.getCategory())
                //Logged in user details
                .createdBy(request.getCreatedBy())
                .modifiedBy(request.getModifiedBy())
                .build();
        topicRepository.saveAndFlush(topic);
    }

    public List<Topic> getAllTopics() {
        List<Topic> topicsList = topicRepository.findAll();
        return topicsList;
    }

    public void updateTopicByID(Topic request) {
        Topic topic = topicRepository.getById(request.getTopicID());
        if (topic != null) {
            topic.setTopicName(request.getTopicName());
            topic.setTopicDescription(request.getTopicDescription());
        }
        topicRepository.save(topic);
    }
}
