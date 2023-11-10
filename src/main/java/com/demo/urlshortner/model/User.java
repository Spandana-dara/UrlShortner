package com.demo.urlshortner.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/**
 * Entity class representing the User.
 */
@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String username;

  @Enumerated(EnumType.STRING)
  private Tier tier;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<UrlMapping> urlMappings = new HashSet<>();

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
