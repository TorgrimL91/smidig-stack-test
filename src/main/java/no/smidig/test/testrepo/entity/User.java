package no.smidig.test.testrepo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please register a username")
    @Column(unique=true, nullable=false)
    private String userName;


    @NotNull(message = "Please register your name")
    private String firstName;

    @NotNull(message = "Please register your name")
    private String lastName;

    private int age;

    private String location;

    @NotBlank(message = "Please register your email address")
    @Column(unique=true, nullable=false)
    private String email;



    @NotNull(message = "Please register your phone number")
    @Column(unique = true,nullable=false)
    private int phoneNumber;

    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    @OrderBy("created_at DESC ")
    private List<PostEntity> post = new LinkedList<>();


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    @OrderBy("created_at DESC ")
    private List<Event> event =  new LinkedList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    @OrderBy("created_at DESC ")
    private List<Comment> comment =  new LinkedList<>();



    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss")
    private Date created_At;
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss")
    private Date updated_At;






    public User() {
    }

    @PrePersist
    protected void onCreate(){
        this.created_At = new Date();
    }



    @PreUpdate
    protected void onUpdate(){
        this.updated_At = new Date();
    }


    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    public Date getUpdated_At() {
        return updated_At;
    }

    public void setUpdated_At(Date updated_At) {
        this.updated_At = updated_At;
    }

    public List<PostEntity> getPost() {
        return post;
    }

    public void setPost(List<PostEntity> post) {
        this.post = post;
    }

    public List<Event> getEvent() {
        return event;
    }

    public void setEvent(List<Event> event) {
        this.event = event;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }
}
