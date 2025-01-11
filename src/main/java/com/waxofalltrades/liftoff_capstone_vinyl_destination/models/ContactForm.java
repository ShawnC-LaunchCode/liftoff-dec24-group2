package com.waxofalltrades.liftoff_capstone_vinyl_destination.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class ContactForm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Name Required")
    @Size(min = 2, max = 120, message = "Must be between 2 and 120 characters")
    private String name;

    @NotBlank(message = "Email Required")
    @Email(message = "Must be Valid Email Address")
    private String emailAddress;

    @Column(columnDefinition = "TEXT")
    private String message;

    public ContactForm(int id, String name, String emailAddress, String message) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
