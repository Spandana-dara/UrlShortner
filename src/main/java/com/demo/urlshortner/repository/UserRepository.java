package com.demo.urlshortner.repository;


import com.demo.urlshortner.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This class represents UserRepository interface.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
