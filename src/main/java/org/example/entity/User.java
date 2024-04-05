package entity;

import jakarta.persistence.*;

@Table(name="galaxy_user")
@Entity
public class User {
    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;
    @Column(name = "login")
    private String login;
    @Column(name="password")
    private String password;

    public String getPassword() {
        return password;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setId(long id) {
        this.id = id;
    }
}