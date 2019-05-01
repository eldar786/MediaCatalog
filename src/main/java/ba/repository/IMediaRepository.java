package ba.repository;

import ba.enums.Genre;
import ba.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

    public interface IMediaRepository extends JpaRepository<Media, Long>, JpaSpecificationExecutor<Media> {


    List<Media> findAllByArtist(String artist);

    List<Media> findAllByCountry(String country);

    List<Media> findAllByTitle(String title);

    List<Media> findAllByGenre(Genre genre);

    List<Media> findAllByPublisher(String publisher);

        @Query("SELECT m " +
        "FROM Media m " +
        "WHERE m.artist = :artist  AND m.country = :country")
       List <Media> getArtist(@Param("artist")String artist, @Param("country") String country);
    }