package com.demo.urlshortner.controller;

import com.demo.urlshortner.dto.CreateShortUrlRequest;
import com.demo.urlshortner.model.User;
import com.demo.urlshortner.service.UrlShorteningService;
import com.demo.urlshortner.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/url/shortner")
//public class UrlController {
//
//  @Autowired
//  private UrlService urlService;
//
//  @GetMapping("/{id}")
//  public String getActualUrl(@PathVariable String id){
//    return urlService.getActualUrl(id);
//  }
//
//  @PostMapping
//  public Url generateShortUrl(@RequestBody String url){
//    return urlService.generateShortUrl(url);
//  }
//
//}

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;

@RestController
@RequestMapping("/api/urls")
public class UrlController {

  @Autowired
  private UserService userService; // Assuming you have a UserService

  @Autowired
  private UrlShorteningService urlShorteningService;

  @PostMapping("/shorten")
  public ResponseEntity<String> shortenUrl(@RequestBody CreateShortUrlRequest request) {
    User user = userService.getUserById(request.getUserId());
    if (user == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

    String shortUrl = urlShorteningService.createShortUrl(request.getLongUrl(), user);
    return ResponseEntity.ok(shortUrl);
  }

  @GetMapping("/{shortUrl}")
  public ResponseEntity<Void> redirectToLongUrl(@PathVariable String shortUrl) {
    String longUrl = urlShorteningService.getLongUrl(shortUrl);
    if (longUrl == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(longUrl)).build();
  }
}

