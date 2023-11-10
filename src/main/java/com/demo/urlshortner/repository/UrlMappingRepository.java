package com.demo.urlshortner.repository;

import com.demo.urlshortner.model.Url;
import com.demo.urlshortner.model.UrlMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlMappingRepository extends JpaRepository<UrlMapping, Integer> {
  String findByShortUrl(String shortUrl);
}
