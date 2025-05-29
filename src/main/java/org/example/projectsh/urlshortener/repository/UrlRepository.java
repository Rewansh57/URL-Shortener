package org.example.projectsh.urlshortener.repository;

import org.example.projectsh.urlshortener.model.Urls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<Urls,Long> {
    @Query("Select a from Urls a where a.url=:longUrl")
    Optional<Urls> findByShortUrl(@Param("longUrl") String longUrl);

}
