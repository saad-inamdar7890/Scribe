package org.application.scribe.object;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Request {
    @Id
    private String id; // Unique identifier for the request
    private LocalDateTime examDate; // Date and time of the exam
    private String examName; // Name of the exam
    private String examTime; // Time of the exam
    private String venue; // Venue of the exam

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Foreign key to User
    private User user; // Reference to the User object
}