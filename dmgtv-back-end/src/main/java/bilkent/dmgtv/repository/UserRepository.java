package bilkent.dmgtv.repository;

import bilkent.dmgtv.db.User;
import bilkent.dmgtv.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Transactional
@Repository
public interface UserRepository extends BaseRepository<User, UUID>
{
	User findByUsername(String username);
}
