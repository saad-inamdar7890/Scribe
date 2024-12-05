package org.application.scribe.object;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    private String id;
    private String name;
    private String school;
    private String course;
    private String contact;


}
