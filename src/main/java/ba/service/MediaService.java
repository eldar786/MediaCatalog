package ba.service;

//import org.springframework.stereotype.Service;

import ba.enums.Genre;
import ba.model.Media;
import ba.repository.IMediaRepository;
import model.in.MediaIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MediaService {

    @Autowired
    IMediaRepository mediaRepository;

    public List<Media> getAllMedia() {
        return mediaRepository.findAll();
    }

    public List<Media> getByArtist(String artist) {
        return mediaRepository.findAllByArtist(artist);
    }

    public List<Media> getByCountry(String country) {
        return mediaRepository.findAllByCountry(country);
    }

    public List<Media> getByGenre(Genre genre){
        return mediaRepository.findAllByGenre(genre);
    }

    public List<Media> getByTitle(String title){
        return mediaRepository.findAllByTitle(title);
    }

    public List<Media> getByPublisher(String publisher){
        return mediaRepository.findAllByPublisher(publisher);
    }

    public Media createMedia(MediaIn mediaIn) {
        Media media = new Media(mediaIn);
        return mediaRepository.save(media);

    }

    public Media getMediaById(Long id) {
        return mediaRepository.getOne(id);
    }

    public void deleteMedia(Long id) {
        mediaRepository.deleteById(id);
    }

    public Media updateMedia(MediaIn mediaIn) {
        Media media = new Media(mediaIn);
        return mediaRepository.saveAndFlush(media);
    }

    public List<Media> getSearchMedia(MediaIn mediaIn) {
        List<Media> mediaList = new ArrayList<>();

        if (mediaIn.getArtist() != null) {
            return mediaRepository.getArtist(mediaIn.getArtist(), mediaIn.getCountry());
//                    , mediaIn.getPublisher(), mediaIn.getCountry(), mediaIn.getTitle(), mediaIn.getGenre());
        }
        return mediaRepository.getArtist(mediaIn.getArtist(), mediaIn.getCountry());
    }
}