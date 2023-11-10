package com.demo.urlshortner.controller;

import com.demo.urlshortner.service.UrlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/url/shortner")
public class UrlController {

  @Autowired
  private UrlService urlService;

  @GetMapping("/{id}")
  public String getActualUrl(@PathVariable String id){
    return urlService.getActualUrl(id);
  }

}
