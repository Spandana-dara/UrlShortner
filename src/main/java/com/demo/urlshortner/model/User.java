package com.demo.urlshortner.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String username;

  @Enumerated(EnumType.STRING)
  private Tier tier;

  private int requestCount;

  public User() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Tier getTier() {
    return tier;
  }

  public void setTier(Tier tier) {
    this.tier = tier;
  }

  public int getRequestCount() {
    return requestCount;
  }

  public void setRequestCount(int requestCount) {
    this.requestCount = requestCount;
  }

  public void incrementRequestCount() {
    this.requestCount++;
  }
}
