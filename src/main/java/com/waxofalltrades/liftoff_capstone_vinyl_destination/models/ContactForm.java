package com.waxofalltrades.liftoff_capstone_vinyl_destination.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class ContactForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name Required")
    @Size(min = 2, max = 120, message = "Must be between 2 and 120 characters")
    private String name;

    @NotBlank(message = "Email Required")
    @Email(message = "Must be Valid Email Address")
    private String emailAddress;

    @NotBlank(message = "Heading Required")
    private String heading;

    @NotBlank(message = "Message Required")
    @Column(columnDefinition = "TEXT")
    private String message;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime submissionDateTime;

    public ContactForm(int id, String name, String emailAddress, String heading, String message, LocalDateTime submissionDateTime) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.heading = heading;
        this.message = message;
        this.submissionDateTime = submissionDateTime;
    }

    public ContactForm() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotBlank(message = "Name Required") @Size(min = 2, max = 120, message = "Must be between 2 and 120 characters") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name Required") @Size(min = 2, max = 120, message = "Must be between 2 and 120 characters") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Email Required") @Email(message = "Must be Valid Email Address") String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(@NotBlank(message = "Email Required") @Email(message = "Must be Valid Email Address") String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public @NotBlank(message = "Heading Required") String getHeading() {
        return heading;
    }

    public void setHeading(@NotBlank(message = "Heading Required") String heading) {
        this.heading = heading;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getSubmissionDateTime() {
        return submissionDateTime;
    }

    public void setSubmissionDateTime(LocalDateTime submissionDateTime) {
        this.submissionDateTime = submissionDateTime;
    }
}
