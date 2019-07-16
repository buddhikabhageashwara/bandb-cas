package com.bandb.cas.model;

/**
 * @author buddika on 4/7/19
 * @project bandb-cas
 */

import com.bandb.cas.util.enums.MultipleLoginPolicy;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cas_user")
public class User extends Audit{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", updatable = false, nullable = false)
    private Long userID;

    @Column(name = "cas_username")
    private String cASUsername;

    @Column(name = "cas_password")
    private String cASPassword;

    @Column(name = "password_created_at")
    private LocalDateTime passwordCreatedAt;

    @Column(name = "fail_attempt")
    private int failAttempt;

    @Column(name = "is_active", columnDefinition = "tinyint default false")
    private boolean isActive;

    @Column(name = "allow_multiple_login", columnDefinition = "tinyint default false")
    private boolean allowMultipleLogin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "profile_id")
    private Profile profile;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "user_user_group",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "group_id") }
    )
    Set<UserGroup> userGroups = new HashSet<>();

    public boolean isAllowMultipleLogin() {
        return allowMultipleLogin;
    }

    public void setAllowMultipleLogin(boolean allowMultipleLogin) {
        this.allowMultipleLogin = allowMultipleLogin;
    }

    public MultipleLoginPolicy getMultipleLoginPolicy() {
        return multipleLoginPolicy;
    }

    public void setMultipleLoginPolicy(MultipleLoginPolicy multipleLoginPolicy) {
        this.multipleLoginPolicy = multipleLoginPolicy;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "multiple_login_policy")
    private MultipleLoginPolicy multipleLoginPolicy;

    private String message;

    private String tRXID;

    public String gettRXID() {
        return tRXID;
    }

    public void settRXID(String tRXID) {
        this.tRXID = tRXID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

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
