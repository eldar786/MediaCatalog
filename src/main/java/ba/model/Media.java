package ba.model;


import ba.enums.Genre;
import model.in.MediaIn;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "media", schema = "erp_mlm")
public class Media {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "artist")
    private String artist;

    @Column(name = "country")
    private String country;

    @Column(name = "genre")
    private Genre genre;

    @Column(name = "publishing_date")
    private LocalDate publishingDate;

    @Column(name="date_created", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    private Date dateCreated;

    @Column(name = "user_id", nullable = false, columnDefinition = "INT DEFAULT '0'")
    private Long userId;

    @Column(name = "name", nullable = true, length = 30)
    private String name;

    public Media() {

    }

    public Media(Long id, String title, String publisher, String artist, String country, Genre genre, LocalDate publishingDate, Date dateCreated, Long userId, String name) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.artist = artist;
        this.country = country;
        this.genre = genre;
        this.publishingDate = publishingDate;
        this.dateCreated = dateCreated;
        this.userId = userId;
        this.name = name;

    }

    public Media(MediaIn MediaIn) {
        this.id = MediaIn.getId();
        this.title = MediaIn.getTitle();
        this.publisher = MediaIn.getPublisher();
        this.artist = MediaIn.getArtist();
        this.country = MediaIn.getCountry();
        this.genre = MediaIn.getGenre();
        this.publishingDate = MediaIn.getPublishingDate();
        this.dateCreated = MediaIn.getDateCreated();
        this.userId = MediaIn.getUserId();
        this.name = MediaIn.getName();
    }

    public Long getId() {
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getArtist(){
        return artist;
    }

    public String getCountry(){
        return country;
    }

    public Genre getGenre(){
        return genre;
    }

    public LocalDate getPublishingDate(){
        return publishingDate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }


    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
