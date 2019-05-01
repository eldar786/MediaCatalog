package modelout;

import ba.enums.Genre;
import ba.model.Media;

import java.time.LocalDate;
import java.util.Date;

public class MediaOut {

    private static final long serialVersionUID = 3575340408212784078L;
    private Long id;
    private String title;
    private String publisher;
    private String artist;
    private String country;
    private Genre genre;
    private LocalDate publishingDate;
    private Long userId;
    private String name;
    private Date dateCreated;

    public MediaOut() {

    }

    public MediaOut(Media media) {
        this.userId = media.getUserId();
        this.title = media.getTitle();
        this.publisher = media.getPublisher();
        this.artist = media.getArtist();
        this.country = media.getCountry();
        this.genre = media.getGenre();
        this.publishingDate = media.getPublishingDate();
        this.id = media.getId();
        this.name = media.getName();
        this.dateCreated = media.getDateCreated();
    }

    public Long getUserId() {
        return userId;
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

    public String getName() {
        return name;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
}