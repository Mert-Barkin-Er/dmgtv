package bilkent.dmgtv.repository;


import bilkent.dmgtv.db.Request;
import bilkent.dmgtv.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Transactional
@Repository
public interface RequestRepository extends BaseRepository<Request, UUID>
{
}
