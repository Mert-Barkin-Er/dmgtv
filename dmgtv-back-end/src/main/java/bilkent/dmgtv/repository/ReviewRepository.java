package bilkent.dmgtv.repository;

import bilkent.dmgtv.db.Friend;
import bilkent.dmgtv.db.Review;
import bilkent.dmgtv.db.User;
import bilkent.dmgtv.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
@Repository
public interface ReviewRepository extends BaseRepository<Review, UUID> {
    Optional<Review> findByUserIdAndMovieId(UUID userId, UUID movieId);
    List<Review> findAllByMovieId(UUID movieId);
    List<Review> findAllByUserId(UUID userId);
}

