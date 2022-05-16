package bilkent.dmgtv.repository;

import bilkent.dmgtv.db.User;
import bilkent.dmgtv.dto.UserDto;
import bilkent.dmgtv.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Transactional
@Repository
public interface UserRepository extends BaseRepository<User, UUID>
{
	@Query(value = "select * from users u where u.username = ?1", nativeQuery = true)
	Optional<User> findByUsername(String username);
	@Query(value = "select case when count(*) > 0 then true else false end from users u where u.username = ?1", nativeQuery = true)
	Boolean existsByUsername(String username);
}
