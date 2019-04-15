package com.bandb.cas.repository;

import com.bandb.cas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author buddika on 4/7/19
 * @project bandb-cas
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByUserId(Long userId);

}
