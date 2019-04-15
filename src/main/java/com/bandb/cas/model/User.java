package com.bandb.cas.model;

/**
 * @author buddika on 4/7/19
 * @project bandb-cas
 */
import javax.persistence.*;

@Entity
@Table(name = "user")
public class User extends Audit{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", updatable = false, nullable = false)
    private Long userID;

    @Column(name = "cas_username")
    private String cASUsername;

    @Column(name = "cas_password")
    private String cASPassword;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getcASUsername() {
        return cASUsername;
    }

    public void setcASUsername(String cASUsername) {
        this.cASUsername = cASUsername;
    }

    public String getcASPassword() {
        return cASPassword;
    }

    public void setcASPassword(String cASPassword) {
        this.cASPassword = cASPassword;
    }
}
