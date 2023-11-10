package com.demo.urlshortner.interceptor;

import com.demo.urlshortner.model.User;
import com.demo.urlshortner.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

@Component
public class RateLimitingInterceptor implements HandlerInterceptor {

  @Autowired
  private UserService userService;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
    Long userId = extractUserIdFromRequest(request);
    User user = userService.getUserById(userId);

    if (user != null && !userService.allowRequest(user)) {
      response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Rate limit exceeded");
      return false;
    }
    return true;
  }

  // Method to extract user ID from the request
  private Long extractUserIdFromRequest(HttpServletRequest request) {
    // Extract and return the user ID
    long userId = 1;
    return userId;
  }
}

