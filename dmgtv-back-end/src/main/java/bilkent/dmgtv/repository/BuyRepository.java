package bilkent.dmgtv.repository;

import bilkent.dmgtv.db.Buy;
import bilkent.dmgtv.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Transactional
@Repository
public interface BuyRepository extends BaseRepository<Buy, UUID>
{
	Boolean existsByMovieTitleAndUserUsername(String movieTitle, String userUsername);
	Buy getByMovieTitleAndUserUsername(String movieTitle, String userUsername);
}
