package com.todotracker.topic.model;

import com.todotracker.user.model.User;
import com.todotracker.utils.statuses.Category;
import com.todotracker.utils.statuses.TopicStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.File;
import java.net.URL;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "topic_table")
public class Topic {

    @Id
    @SequenceGenerator(
            name = "topic_id_sequence",
            sequenceName = "topic_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "topic_id_sequence"
    )
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
