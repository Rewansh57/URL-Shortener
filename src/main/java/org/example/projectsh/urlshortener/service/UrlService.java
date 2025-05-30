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



    public String encode(String url){
        Urls record=new Urls();
        String shortCode=encoding.encoder(url);
        record.setShortCode(shortCode);
        record.setUrl(url);
        record.setAccessCount(1);
        urlRepository.save(record);
        return shortCode;

    }

    public String find(String shortUrl ) {
       Optional<Urls> recordByShort= urlRepository.findByShortUrl(shortUrl);
       if (recordByShort.isPresent()){
           return recordByShort.get().getUrl();
       }
       else {
           throw new NullPointerException("No such url was shorted :"+shortUrl);

        }



    }


    public String updateByShortUrl(String shortUrl, String changedLongUrl) {
        Optional<Urls> recordByShort= urlRepository.findByShortUrl(shortUrl);
        if (recordByShort.isPresent()){
            recordByShort.get().setUrl(changedLongUrl);
            return recordByShort.get().getUrl();



        }
        else {
            throw new NullPointerException("No such short url was present :"+shortUrl);

        }
    }
}
