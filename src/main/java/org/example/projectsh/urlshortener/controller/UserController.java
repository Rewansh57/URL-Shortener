package org.example.projectsh.urlshortener.controller;

import lombok.RequiredArgsConstructor;
import org.example.projectsh.urlshortener.service.UrlService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UrlService urlService;

    @PostMapping("/long/url/short")
    public String longToShortUrl(@RequestBody String longUrl) {
        return urlService.encode(longUrl);
    }

    @GetMapping("/url/short")
    public String findLong(@RequestBody String shortUrl){
        return urlService.find(shortUrl);

    }

    @PutMapping("/url/short/update")
    public String changeShortUrlTarget(@RequestBody String shortUrl,@RequestBody String changedLongUrl){
        return urlService.updateByShortUrl(shortUrl,changedLongUrl);

    }

}
