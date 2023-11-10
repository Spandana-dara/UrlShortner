package com.demo.urlshortner.repository;

import com.demo.urlshortner.model.Url;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Integer> {

  @Query(value = "select actualUrl from Url where shortUrl=?1", nativeQuery = true)
  String findByShortUrl(String id);
}
