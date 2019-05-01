package model.in;

import ba.enums.Genre;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

public class MediaIn {
    @NotNull
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String publisher;

    @NotNull
    private String artist;

    @NotNull
    private String country;

    @NotNull
    private Genre genre;

    @NotNull
    private LocalDate publishingDate;

    @NotNull
    private Long userId;

    @NotNull
    private String name;

    @NotNull
    private Date dateCreated;


    public MediaIn() {
        super();
    }


    public MediaIn(Long id, String title, String publisher, String artist, String country, Genre genre, LocalDate publishingDate, Long userId, String name, Date dateCreated) {
        super();
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.artist = artist;
        this.country = country;
        this.genre = genre;
        this.publishingDate = publishingDate;
        this.userId = userId;
        this.name = name;
        this.dateCreated = dateCreated;
    }

    public Long getId() {
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getPublisher(){
        return publisher;
    }

        public String getArtist() {
        return artist;
    }

    public String getCountry() {
        return country;
    }

    public Genre getGenre(){
        return genre;
    }

    public LocalDate getPublishingDate(){
        return publishingDate;
    }

    public Long getUserId() {
        return userId;
    }


    public String getName() {
        return name;
    }


    public Date getDateCreated() {
        return dateCreated;
    }
}