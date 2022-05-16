package bilkent.dmgtv.repository;

import bilkent.dmgtv.db.Buy;
import bilkent.dmgtv.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Transactional
@Repository
public interface BuyRepository extends BaseRepository<Buy, UUID>
{
	Boolean existsByMovieTitleAndUserUsername(String movieTitle, String userUsername);
	@Query(value = "select * from buy b where b.movie_id = (select m.id from movie m where m.title = ?1)) and b.user_id = (select u.id from users u where u.username = ?2)", nativeQuery = true)
	Buy getByMovieTitleAndUserUsername(String movieTitle, String userUsername);
}
