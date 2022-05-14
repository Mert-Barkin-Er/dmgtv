package bilkent.dmgtv.serviceimpl;

import bilkent.dmgtv.db.User;
import bilkent.dmgtv.dto.UserDto;
import bilkent.dmgtv.repository.UserRepository;
import bilkent.dmgtv.service.UserService;
import bilkent.dmgtv.serviceimpl.base.BaseServiceImpl;
import bilkent.dmgtv.serviceimpl.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserDto> implements UserService
{
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	private final UserRepository userRepository;

	private final UserMapper userMapper;

	public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
		super(userRepository, UserMapper.INSTANCE);
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}
}
