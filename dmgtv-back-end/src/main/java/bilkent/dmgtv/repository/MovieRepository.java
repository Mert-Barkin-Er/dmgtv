package bilkent.dmgtv.repository;

import bilkent.dmgtv.db.Movie;
import bilkent.dmgtv.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Transactional
@Repository
public interface MovieRepository extends BaseRepository<Movie, UUID> {
    Optional<Movie> findByTitleAndProductionYear(String title, Integer year);
    Boolean existsByTitle(String title);
    Optional<Movie> findByTitle(String title);
}