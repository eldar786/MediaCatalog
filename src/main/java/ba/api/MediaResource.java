package ba.api;

import ba.enums.Genre;
import ba.service.MediaService;
import model.in.MediaIn;
import modelout.MediaOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/media", produces = MediaType.APPLICATION_JSON)

@Configuration
@EnableWebMvc

public class MediaResource {

    @Autowired
    MediaService mediaService;


    @PostMapping(path = "/records", consumes = MediaType.APPLICATION_JSON)
    @ResponseBody
    public MediaOut createImenik(@RequestBody MediaIn mediaIn) {
        return new MediaOut(mediaService.createMedia(mediaIn));
    }

    @CrossOrigin
    @GetMapping(path = "/records")
    @ResponseBody
    public List<MediaOut> getAllMedia() {
        return mediaService.getAllMedia().stream().map(MediaOut::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/records/{id}")
    @ResponseBody
    public MediaOut getMediaById(@PathVariable Long id) {
        return new MediaOut(mediaService.getMediaById(id));
    }

    @PutMapping(path = "/records/{id}", consumes = MediaType.APPLICATION_JSON)
    @ResponseBody
    public MediaOut updateImenik(@PathVariable("id") Long id, @RequestBody MediaIn imenikModelIn) {
        return new MediaOut(mediaService.updateMedia(imenikModelIn));
    }

    @DeleteMapping(path = "/records/{id}", consumes = MediaType.APPLICATION_JSON)
    @ResponseBody
    public void deleteImenik(@PathVariable("id") Long id) {
        mediaService.deleteMedia(id);
    }


    //  SEARCH BY MULTIPLE PARAMETERS
    @PostMapping(path = "/searchmultiple", consumes = MediaType.APPLICATION_JSON)
    @ResponseBody
    public List<MediaOut> searchMultiple(@RequestBody MediaIn mediaIn) {
        return mediaService.getSearchMedia(mediaIn).stream().map(MediaOut::new).collect(Collectors.toList());
    }

    //    SEARCH BY GENRE
    @GetMapping(path = "/genre/{genre}")
    @ResponseBody
    public  List<MediaOut> getByGenre(@PathVariable("genre") Genre genre) {
        return mediaService.getByGenre(genre).stream().map(MediaOut::new).collect(Collectors.toList());
    }

    //    SEARCH BY COUNTRY
    @GetMapping(path = "/country/{country}")
    @ResponseBody
    public  List<MediaOut> getByCountry(@PathVariable("country") String country) {
        return mediaService.getByCountry(country).stream().map(MediaOut::new).collect(Collectors.toList());
    }

//    SEARCH BY ARTIST
    @CrossOrigin
    @GetMapping(path = "/artist/{artist}")
    @ResponseBody
    public  List<MediaOut> getByArtist(@PathVariable("artist") String artist) {
        return mediaService.getByArtist(artist).stream().map(MediaOut::new).collect(Collectors.toList());
    }

    //    SEARCH BY TITLE
    @GetMapping(path = "/title/{title}")
    @ResponseBody
    public  List<MediaOut> getByTitle(@PathVariable("title") String title) {
        return mediaService.getByTitle(title).stream().map(MediaOut::new).collect(Collectors.toList());
    }

    //    SEARCH BY PUBLISHER
    @GetMapping(path = "/publisher/{publisher}")
    @ResponseBody
    public List<MediaOut> getByPublisher(@PathVariable("publisher") String publisher){
        return mediaService.getByPublisher(publisher).stream().map(MediaOut::new).collect(Collectors.toList());
    }
}