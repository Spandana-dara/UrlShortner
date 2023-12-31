package com.demo.urlshortner.model;

/**
 * Enum representing different tiers for users.
 * Each tier is associated with a different request limit, indicating how many requests a user of that tier can make.
 */
public enum Tier {
  TIER_1(1000), // Tier 1 user can make 1000 requests
  TIER_2(100);  // Tier 2 user can make 100 requests

  private final int requestLimit;

  Tier(int requestLimit) {
    this.requestLimit = requestLimit;
  }

  public int getRequestLimit() {
    return requestLimit;
  }
}