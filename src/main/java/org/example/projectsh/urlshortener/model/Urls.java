package org.example.projectsh.urlshortener.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Urls {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String shortCode;
    @CreatedDate
    @Column(updatable=false)
    private String creationDate;
    @LastModifiedDate
    private String lastAccessDate;
    private int accessCount;


}
