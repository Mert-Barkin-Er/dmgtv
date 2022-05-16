package bilkent.dmgtv.repository;

import bilkent.dmgtv.db.Rent;
import bilkent.dmgtv.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Transactional
@Repository
public interface RentRepository extends BaseRepository<Rent, UUID> {
	List<Rent> findByUserUsernameAndEndDateIsNull(String username);
	Rent findByUserUsernameAndMovieTitleAndEndDateIsNull(String username, String title);
}
