package com.waxofalltrades.liftoff_capstone_vinyl_destination.dto;

public class UserDto {

    private String email;
    private String password;
    private String role;
    private String fullname;

    public UserDto(String fullname, String role, String password, String email) {
        this.fullname = fullname;
        this.role = role;
        this.password = password;
        this.email = email;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
