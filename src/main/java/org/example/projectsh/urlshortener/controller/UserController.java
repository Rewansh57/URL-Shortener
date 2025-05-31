package org.example.projectsh.urlshortener.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.projectsh.urlshortener.model.Urls;
import org.example.projectsh.urlshortener.service.UrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserController {

    private final UrlService urlService;
    public UserController(final UrlService urlService) {
        this.urlService = urlService;
    }


    @Data
    public static class LongUrlRequest {
        private String longUrl;
    }

    @PostMapping("/long/url/short")
    public ResponseEntity<Urls> longToShortUrl(@RequestBody LongUrlRequest request) {
        System.out.println("Received request with longUrl: " + request.getLongUrl());
        try {
            Urls shortened = urlService.encode(request.getLongUrl());
            return new ResponseEntity<>(shortened, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/url/short")
    public ResponseEntity<Urls> findLong(@RequestParam String shortUrl) {
        Urls found = urlService.find(shortUrl);
        if (found == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(found, HttpStatus.OK);
    }


    @Data
    public static class UpdateUrlRequest {
        private String shortUrl;
        private String changedLongUrl;
    }

    @PutMapping("/url/short/update")
    public ResponseEntity<Urls> changeShortUrlTarget(@RequestBody UpdateUrlRequest request) {
        Urls found = urlService.find(request.getShortUrl());
        if (found == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Urls updated = urlService.updateByShortUrl(request.getShortUrl(), request.getChangedLongUrl());
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/url/short/delete")
    public ResponseEntity<Urls> deleteShort(@RequestParam String shortUrl) {
        Urls deleted = urlService.deleteShortUrl(shortUrl);
        if (deleted == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}
