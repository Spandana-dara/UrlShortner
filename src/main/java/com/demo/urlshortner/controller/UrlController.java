package com.demo.urlshortner.controller;

import com.demo.urlshortner.dto.CreateShortUrlRequest;
import com.demo.urlshortner.model.User;
import com.demo.urlshortner.service.UrlShorteningService;
import com.demo.urlshortner.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Collections;
import java.util.List;

/**
 * Controller for URL shortening service.
 * This class handles web requests for URL shortening and redirection.
 */
@RestController
@RequestMapping("/api/urls")
public class UrlController {

  @Autowired
  private UserService userService;

  @Autowired
  @Qualifier("urlShorteningServiceImpl")
  private UrlShorteningService urlShorteningService;

  /**
   * Endpoint for creating a shortened URL.
   * This method handles POST requests to shorten a given URL.
   *
   * @param request Contains the long URL and user ID.
   * @return ResponseEntity with either the shortened URL or an error message.
   */
  @PostMapping("/shorten")
  public ResponseEntity<String> shortenUrl(@RequestBody CreateShortUrlRequest request) {
    User user = userService.getUserById(request.getUserId());
    if (user == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

    String shortUrl = urlShorteningService.createShortUrl(request.getLongUrl(), user);
    return ResponseEntity.ok(shortUrl);
  }

  /**
   * Endpoint for redirecting a shortened URL to its original URL.
   * This method handles GET requests to redirect a shortened URL.
   *
   * @param shortUrl The shortened URL.
   * @return ResponseEntity that redirects to the original long URL or an error if not found.
   */
  @GetMapping("/{shortUrl}")
  public ResponseEntity<Void> redirectToLongUrl(@PathVariable String shortUrl) {
    String longUrl = urlShorteningService.getLongUrl(shortUrl);
    if (longUrl == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(longUrl)).build();
  }


  /**
   * Endpoint to get the history of URLs shortened by a specific user.
   *
   * @param request The request body containing the user ID.
   * @return ResponseEntity with a list of shortened URLs or an appropriate error message.
   */
  @PostMapping("/user/history")
  public ResponseEntity<List<String>> getUserShortenedUrlsHistory(@RequestBody CreateShortUrlRequest request) {
    Long userId = request.getUserId();
    List<String> urls = urlShorteningService.getUserShortenedUrls(userId);

    if (urls == null || urls.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
    }

    return ResponseEntity.ok(urls);
  }
}

