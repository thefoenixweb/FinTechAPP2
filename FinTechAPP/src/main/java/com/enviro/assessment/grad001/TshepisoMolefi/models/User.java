package com.enviro.assessment.grad001.TshepisoMolefi.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    private int user_id;
    @NotEmpty(message = "The First name field cannot be empty")
    @Size(min=3, message = "The First name field must greater that 3 characters")
    private String first_name;
    @NotEmpty(message = "The Last name field cannot be empty")
    @Size(min=3, message = "The First name field must greater that 3 characters")
    private String last_name;
    
    @NotEmpty
    
    private String user1;
    @NotEmpty
    @NotNull
    private String password;
    @NotEmpty(message = "The address field cannot be empty")
    private String address; 
    @NotEmpty(message = "contact field cannot be empty")
    private String contact;
    private String token;
    private String code;
    @NotEmpty(message = "The age field cannot be empty")
    private String age;
    private int verified;
    private LocalDate verified_at;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setAddress(String address) {
    	this.address = address; 
    	}
    
    public String getAddress() {
    	return address; 
    }
    
    public void setAge(String age) {
    	this.age = age;
    }
    
    public String getAge() {
    	return age; 
    }
    
    public void setContact(String contact) {
    	this.contact = contact;
    }
    
    public String getContact() {
    	return contact;
    }
    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getVerified() {
        return verified;
    }

    public void setVerified(int verified) {
        this.verified = verified;
    }

    public LocalDate getVerified_at() {
        return verified_at;
    }

    public void setVerified_at(LocalDate verified_at) {
        this.verified_at = verified_at;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}
