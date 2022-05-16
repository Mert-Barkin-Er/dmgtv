package bilkent.dmgtv.repository;

import bilkent.dmgtv.db.Movie;
import bilkent.dmgtv.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
@Repository
public interface MovieRepository extends BaseRepository<Movie, UUID> {
    @Query(value = "select * from movie m where m.title = ?1 and m.production_year = ?2", nativeQuery = true)
    Optional<Movie> findByTitleAndProductionYear(String title, Integer year);
    @Query(value = "select case when count(*) > 0 then true else false end from movie m where m.title = ?1", nativeQuery = true)
    Boolean existsByTitle(String title);
    @Query(value = "select * from movie m where m.title = ?1", nativeQuery = true)
    Optional<Movie> findByTitle(String title);
    @Query(value = "select * from movie m where m.production_year >= ?1 and m.production_year <= ?2", nativeQuery = true)
    List<Movie> findAllByProductionYearGreaterThanEqualAndProductionYearLessThanEqual(Integer start, Integer end);
}