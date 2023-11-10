package com.demo.urlshortner.model;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Entity class representing the URL mapping.
 * This class maps shortened URLs to their corresponding original (long) URLs and associates them with a user.
 */
@Entity
public class UrlMapping {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String longUrl;
  private String shortUrl;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  public UrlMapping() {

  }

  public UrlMapping(String longUrl, String shortUrl, User user) {
    this.longUrl = longUrl;
    this.shortUrl = shortUrl;
    this.user = user;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLongUrl() {
    return longUrl;
  }

  public void setLongUrl(String longUrl) {
    this.longUrl = longUrl;
  }

  public String getShortUrl() {
    return shortUrl;
  }

  public void setShortUrl(String shortUrl) {
    this.shortUrl = shortUrl;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }


}

