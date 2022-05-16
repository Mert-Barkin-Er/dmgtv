package bilkent.dmgtv.serviceimpl;

import bilkent.dmgtv.db.Friend;
import bilkent.dmgtv.db.User;
import bilkent.dmgtv.dto.FriendDto;
import bilkent.dmgtv.repository.FriendRepository;
import bilkent.dmgtv.repository.UserRepository;
import bilkent.dmgtv.repository.base.BaseRepository;
import bilkent.dmgtv.service.FriendService;
import bilkent.dmgtv.serviceimpl.base.BaseServiceImpl;
import bilkent.dmgtv.serviceimpl.mapper.FriendMapper;
import bilkent.dmgtv.serviceimpl.mapper.base.BaseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.UUID;

@Service
public class FriendServiceImpl extends BaseServiceImpl<Friend, FriendDto> implements FriendService
{
	private static final Logger LOGGER = LoggerFactory.getLogger(FriendServiceImpl.class);

	private final FriendMapper friendMapper;
	private final FriendRepository friendRepository;
	private final UserRepository userRepository;

	public FriendServiceImpl(FriendRepository friendRepository, FriendMapper friendMapper, UserRepository userRepository)
	{
		super(friendRepository, friendMapper);
		this.friendMapper = friendMapper;
		this.friendRepository = friendRepository;
		this.userRepository = userRepository;
	}

	public FriendDto add(String firstUsername, String secondUsername)
	{
		Optional<User> firstUser = userRepository.findByUsername(firstUsername);
		Optional<User> secondUser = userRepository.findByUsername(secondUsername);
		if (firstUser.isPresent() && secondUser.isPresent()){
			// we need to add the friend to the first user
			Friend friend = new Friend();
			friend.setFirstUser(firstUser.get());
			friend.setSecondUser(secondUser.get());
			super.create(FriendMapper.INSTANCE.entityToDto(friend));
			// we need to add the friend to the second user
			friend = new Friend();
			friend.setFirstUser(secondUser.get());
			friend.setSecondUser(firstUser.get());
			return super.create(FriendMapper.INSTANCE.entityToDto(friend));
		}
		else
		{
			throw new EntityNotFoundException("One/Both of the users not found");
		}
	}
}

