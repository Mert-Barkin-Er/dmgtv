package bilkent.dmgtv.repository;

import bilkent.dmgtv.db.Movie;
import bilkent.dmgtv.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Transactional
@Repository
public interface MovieRepository extends BaseRepository<Movie, UUID> {
    @Query(value = "select * from movie m where m.title = ?1 and m.production_year = ?2", nativeQuery = true)
    Optional<Movie> findByTitleAndProductionYear(String title, Integer year);
    Boolean existsByTitle(String title);
    @Query(value = "select * from movie m where m.title = ?1", nativeQuery = true)
    Optional<Movie> findByTitle(String title);
}