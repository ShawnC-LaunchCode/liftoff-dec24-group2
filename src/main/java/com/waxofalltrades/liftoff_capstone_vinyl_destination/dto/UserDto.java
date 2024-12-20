package com.waxofalltrades.liftoff_capstone_vinyl_destination.dto;

public class UserDto {

    private String email;
    private String password;
    private String role;
    private String firstName;
    private String lastName;

    public UserDto(String firstName, String role, String password, String email, String lastName) {
        this.firstName = firstName;
        this.role = role;
        this.password = password;
        this.email = email;
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
