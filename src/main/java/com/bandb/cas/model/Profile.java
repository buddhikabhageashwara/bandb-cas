package com.bandb.cas.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author buddika on 4/7/19
 * @project bandb-cas
 */
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "profile_id", updatable = false, nullable = false)
    private Long profileID;
}
