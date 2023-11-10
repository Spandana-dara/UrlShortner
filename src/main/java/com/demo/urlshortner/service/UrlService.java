package com.demo.urlshortner.service;

import com.demo.urlshortner.repository.UrlRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

  @Autowired
  private UrlRepository urlRepository;
  public String getActualUrl(String id) {
    return urlRepository.findByShortUrl(id);
  }
}
