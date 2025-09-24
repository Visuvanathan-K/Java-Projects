package bookstore.Entity;

import bookstore.Common.Constant;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  name;
    private String gender;
    private String email;
    private String phone_number;
    @Column(nullable = false)
    private String password;
    private Boolean is_active = true;
    private Integer login_count =0 ;
    private String user_type = Constant.user_type.NORMAL;
    private LocalDateTime login_at;
    private LocalDateTime created_date;
    private LocalDateTime updated_date;
    private String sso_type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public Integer getLogin_count() {
        return login_count;
    }

    public void setLogin_count(Integer login_count) {
        this.login_count = login_count;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public LocalDateTime getLogin_t() {
        return login_at;
    }

    public void setLogin_t(LocalDateTime login_t) {
        this.login_at = login_t;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }

    public LocalDateTime getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(LocalDateTime updated_date) {
        this.updated_date = updated_date;
    }

    public String getSso_type() {
        return sso_type;
    }

    public void setSso_type(String sso_type) {
        this.sso_type = sso_type;
    }

    @PrePersist
    public void onSave(){
        LocalDateTime localDateTime = LocalDateTime.now();

        this.created_date = localDateTime;
        this.updated_date = localDateTime;

    }
    @PreUpdate
    public void onUpdate(){
        LocalDateTime localDateTime = LocalDateTime.now();
        this.updated_date = localDateTime;
    }
}
