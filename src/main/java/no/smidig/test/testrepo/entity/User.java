package no.smidig.test.testrepo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    /**
     * Nå har je satt annotation på kolonene i databasen
     * **/

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

    @NotBlank(message = "Please register your email adress")
    @Column(unique=true, nullable=false)
    private String email;


    // jeg måte fjerne nullable=false på telefonnummeret
    @NotNull(message = "Please register your phone number")
    @Column(unique = true,nullable=false)
    private int phoneNumber;

    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private List<PostEntity> post = new ArrayList<>();


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Event> event = new ArrayList<>();



    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date created_At;
    @JsonFormat(pattern = "yyyy-MM-dd")
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
}
