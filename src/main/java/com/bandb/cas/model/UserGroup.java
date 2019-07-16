package com.bandb.cas.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author buddika on 4/7/19
 * @project bandb-cas
 */
@Entity
@Table(name = "user_group")
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "group_id", updatable = false, nullable = false)
    private Long groupID;

    @ManyToMany(mappedBy = "user_group")
    private Set<User> users = new HashSet<>();

}
