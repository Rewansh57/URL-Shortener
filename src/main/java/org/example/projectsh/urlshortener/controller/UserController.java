package org.example.projectsh.urlshortener.controller;

import lombok.RequiredArgsConstructor;
import org.example.projectsh.urlshortener.service.UrlService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UrlService urlService;

    @PostMapping("/long/url")
    public String longToShortUrl(@RequestBody String longUrl) {
        return urlService.encode(longUrl);
    }

}
