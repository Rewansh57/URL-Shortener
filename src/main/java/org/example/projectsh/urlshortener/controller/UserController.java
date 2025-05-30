package org.example.projectsh.urlshortener.controller;

import lombok.RequiredArgsConstructor;
import org.example.projectsh.urlshortener.model.Urls;
import org.example.projectsh.urlshortener.service.UrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UrlService urlService;

    @PostMapping("/long/url/short")
    public ResponseEntity<Urls> longToShortUrl(@RequestBody String longUrl) {
        try{
        return new ResponseEntity<>(urlService.encode(longUrl), HttpStatus.CREATED);}
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/url/short")
    public ResponseEntity<Urls> findLong(@RequestBody String shortUrl){
        if (urlService.find(shortUrl) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(urlService.find(shortUrl), HttpStatus.OK);

    }

    @PutMapping("/url/short/update")
    public ResponseEntity<Urls> changeShortUrlTarget(@RequestBody String shortUrl,@RequestBody String changedLongUrl){
        if (urlService.find(shortUrl)==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(urlService.updateByShortUrl(shortUrl,changedLongUrl), HttpStatus.OK);

    }
    @DeleteMapping("/url/short/delete")
    public ResponseEntity<Urls> deleteShort(@RequestBody String shortUrl){
        if(urlService.deleteShortUrl(shortUrl)==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

        return new ResponseEntity<>(urlService.deleteShortUrl(shortUrl), HttpStatus.OK);

        }





    }


