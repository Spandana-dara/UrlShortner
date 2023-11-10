package com.demo.urlshortner.dto;

public class CreateShortUrlRequest {
  private String longUrl;
  private Long userId;

  // Standard getters and setters
  public String getLongUrl() {
    return longUrl;
  }

  public void setLongUrl(String longUrl) {
    this.longUrl = longUrl;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
}
