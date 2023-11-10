package com.demo.urlshortner.service;

import com.demo.urlshortner.model.UrlMapping;
import com.demo.urlshortner.model.User;
import com.demo.urlshortner.repository.UrlMappingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class UrlShorteningService {

  @Autowired
  private UrlMappingRepository urlMappingRepository;

  /**
   * Creates a shortened URL and stores it along with the original URL.
   *
   * @param longUrl The original URL to be shortened.
   * @param user The user who is creating the short URL.
   * @return The shortened URL.
   */
  public String createShortUrl(String longUrl, User user) {
    String shortId = generateUniqueShortId();
    UrlMapping urlMapping = new UrlMapping();
    urlMapping.setLongUrl(longUrl);
    urlMapping.setShortUrl("http://short.url/" + shortId);
    urlMapping.setUser(user);
    urlMappingRepository.save(urlMapping);
    return urlMapping.getShortUrl();
  }

  /**
   * Retrieves the original URL based on the shortened URL.
   *
   * @param shortUrl The shortened URL.
   * @return The original URL, if found.
   */
  public String getLongUrl(String shortUrl) {
    return urlMappingRepository.findByShortUrl(shortUrl);
  }

  /**
   * Generates a unique short identifier for the URL.
   *
   * @return A unique short ID.
   */
  private String generateUniqueShortId() {
    // Simple implementation. In a real-world scenario, you should also check for uniqueness.
    return UUID.randomUUID().toString().substring(0, 6);
  }
}

