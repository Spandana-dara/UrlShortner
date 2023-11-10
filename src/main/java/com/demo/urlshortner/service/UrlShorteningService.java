package com.demo.urlshortner.service;

import com.demo.urlshortner.model.User;

import java.util.List;

public interface UrlShorteningService {

  /**
   * Creates a shortened URL and stores it along with the original URL.
   *
   * @param longUrl The original URL to be shortened.
   * @param user    The user who is creating the short URL.
   * @return The shortened URL.
   */
  String createShortUrl(String longUrl, User user);

  /**
   * Retrieves the original URL based on the shortened URL.
   *
   * @param shortUrl The shortened URL.
   * @return The original URL, if found.
   */
  String getLongUrl(String shortUrl);

  /**
   * Generates all short urls generated by the user.
   *
   * @param userId unique short id.
   * @return list of short urls.
   */
  List<String> getUserShortenedUrls(Long userId);

}
