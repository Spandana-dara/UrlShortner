package com.demo.urlshortner.service;

import com.demo.urlshortner.model.User;

/**
 * This represents an interface for user related operations.
 */
public interface UserService {

  /**
   * Retrieves a user by their ID.
   *
   * @param userId The ID of the user to retrieve.
   * @return The User object if found, otherwise null.
   */
  User getUserById(Long userId);

  /**
   * Determines whether a user is allowed to make a request based on their tier and request count.
   *
   * @param user The user whose request allowance is being checked.
   * @return True if the user can make a request, false otherwise.
   */
  boolean allowRequest(User user);

}
