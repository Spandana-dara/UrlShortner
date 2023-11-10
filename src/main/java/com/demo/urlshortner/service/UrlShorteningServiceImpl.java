package com.demo.urlshortner.service;

import com.demo.urlshortner.model.UrlMapping;
import com.demo.urlshortner.model.User;
import com.demo.urlshortner.repository.UrlMappingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Service class for Url Shortner.
 */
@Service
public class UrlShorteningServiceImpl implements UrlShorteningService {

  @Autowired
  private UrlMappingRepository urlMappingRepository;

  @Override
  public String createShortUrl(String longUrl, User user) {
    String shortId = generateUniqueShortId();
    UrlMapping urlMapping = new UrlMapping();
    urlMapping.setLongUrl(longUrl);
    urlMapping.setShortUrl("http://short.url/" + shortId);
    urlMapping.setUser(user);
    urlMappingRepository.save(urlMapping);
    return urlMapping.getShortUrl();
  }

  @Override
  public String getLongUrl(String shortUrl) {
    return urlMappingRepository.findByShortUrl(shortUrl).orElse("default value");
  }

  @Override
  public List<String> getUserShortenedUrls(Long userId) {
    List<UrlMapping> mappings = urlMappingRepository.findByUserId(userId);

    return mappings.stream()
            .map(UrlMapping::getShortUrl)
            .collect(Collectors.toList());
  }

  private String generateUniqueShortId() {
    //Simple implementation
    return UUID.randomUUID().toString().substring(0, 6);
  }

}

