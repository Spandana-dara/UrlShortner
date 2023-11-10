package com.demo.urlshortner.service;

import com.demo.urlshortner.model.User;
import com.demo.urlshortner.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Service class to manage user-related operations.
 */
@Service
@Primary
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public User getUserById(Long userId) {
    return userRepository.findById(userId).orElse(null);
  }

  @Override
  public boolean allowRequest(User user) {
    // Check if the user's request count exceeds their tier limit
    if (user.getRequestCount() > user.getTier().getRequestLimit()) {
      return false;
    }
    user.incrementRequestCount();
    userRepository.save(user);
    return true;
  }
}

