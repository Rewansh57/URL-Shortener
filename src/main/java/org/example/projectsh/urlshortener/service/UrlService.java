package org.example.projectsh.urlshortener.service;

import lombok.RequiredArgsConstructor;
import org.example.projectsh.urlshortener.model.Urls;
import org.example.projectsh.urlshortener.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class UrlService {
    private final UrlRepository urlRepository;
    private final Encoding encoding;



    public Urls encode(String url){
        Urls record=new Urls();
        String shortCode=encoding.encoder(url);
        record.setShortCode(shortCode);
        record.setUrl(url);
        record.setAccessCount(1);
        urlRepository.save(record);
        return record;

    }

    public Urls find(String shortUrl ) {
       Optional<Urls> recordByShort= urlRepository.findByShortUrl(shortUrl);
       if (recordByShort.isPresent()){
           return recordByShort.get();

       }
       else {
           return null;



        }



    }


    public Urls updateByShortUrl(String shortUrl, String changedLongUrl) {
        Optional<Urls> recordByShort= urlRepository.findByShortUrl(shortUrl);
        if (recordByShort.isPresent()){
            recordByShort.get().setUrl(changedLongUrl);
            urlRepository.save(recordByShort.get());
            return recordByShort.get();


        }
        else {
            return null;


        }
    }

    public Urls deleteShortUrl(String shortUrl) {
        Optional<Urls> recordByShort= urlRepository.findByShortUrl(shortUrl);
        if(recordByShort.isPresent()){
            recordByShort.get().setShortCode(null);
            urlRepository.save(recordByShort.get());
            return recordByShort.get();


        }
        else {
            return null;


        }
    }
}
