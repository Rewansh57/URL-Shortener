package org.example.projectsh.urlshortener.service;

import lombok.RequiredArgsConstructor;
import org.example.projectsh.urlshortener.repository.UrlRepository;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UrlService {
    private final UrlRepository urlRepository;


    public String encode(String url){
        Encoding e=new Encoding();







    }

}
