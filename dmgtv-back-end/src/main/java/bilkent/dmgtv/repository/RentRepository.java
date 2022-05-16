package bilkent.dmgtv.repository;

import bilkent.dmgtv.db.Rent;
import bilkent.dmgtv.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Transactional
@Repository
public interface RentRepository extends BaseRepository<Rent, UUID> {
	@Query(value = "select * from rent r where r.user_id = (select u.id from users u where u.username = ?1) and r.end_date is null", nativeQuery = true)
	List<Rent> findByUserUsernameAndEndDateIsNull(String username);
	@Query(value = "select * from rent r where r.user_id = (select u.id from users u where u.username = ?1) and r.movie_id = (select m.id from movie m where m.title = ?2) and r.end_date is null", nativeQuery = true)
	Rent findByUserUsernameAndMovieTitleAndEndDateIsNull(String username, String title);
}
