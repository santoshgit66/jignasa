package com.todotracker.topic.model;

import com.todotracker.user.model.User;
import com.todotracker.utils.statuses.Category;
import com.todotracker.utils.statuses.TopicStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import java.io.File;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TopicRegistrationRequest {
    private Integer topicID;
    private String topicName;
    private String topicDescription;
    private String[] attachmentNames;
    private File[] attachments;
    private String externalURL;
    private String createdDate;
    private String modifiedDate;
    @OneToOne(cascade = CascadeType.ALL)
    private User createdBy;
    @OneToOne(cascade = CascadeType.ALL)
    private User modifiedBy;
    private TopicStatus topicStatus;
    private Category category;
}
