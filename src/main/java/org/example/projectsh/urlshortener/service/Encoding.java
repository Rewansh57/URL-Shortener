package org.example.projectsh.urlshortener.service;


import lombok.RequiredArgsConstructor;
import org.example.projectsh.urlshortener.model.Urls;
import org.example.projectsh.urlshortener.repository.UrlRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.random.RandomGenerator;

@Component
@RequiredArgsConstructor
public class Encoding {
    private final  UrlRepository urlRepository;
    private final int maxLength = 7;
    private final String alphabet = "23456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";


    public String encoder(String url) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < maxLength; i++) {


            int random = RandomGenerator.getDefault().nextInt(0, alphabet.length());
            result.append(alphabet.charAt(random));


        }
        Optional<Urls> option = urlRepository.findByShortCode(result.toString());
        if (option.isPresent()) {
            return encoder(url);

        } else {
            return result.toString();

        }


    }

}
