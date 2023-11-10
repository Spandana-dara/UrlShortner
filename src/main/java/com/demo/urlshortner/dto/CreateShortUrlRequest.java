package com.demo.urlshortner.dto;


/**
 * Data Transfer Object (DTO) for creating a short URL request.
 * This class is used to encapsulate the data received in a request to create a new short URL.
 */
public class CreateShortUrlRequest {
  private String longUrl;
  private Long userId;

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
