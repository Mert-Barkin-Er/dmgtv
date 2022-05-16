package bilkent.dmgtv.serviceimpl;

import bilkent.dmgtv.db.LoginRequest;
import bilkent.dmgtv.db.RegisterRequest;
import bilkent.dmgtv.db.User;
import bilkent.dmgtv.dto.UserDto;
import bilkent.dmgtv.repository.UserRepository;
import bilkent.dmgtv.service.UserService;
import bilkent.dmgtv.serviceimpl.base.BaseServiceImpl;
import bilkent.dmgtv.serviceimpl.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

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

	public UserDto get(String username) throws EntityNotFoundException
	{
		if (username == null)
		{
			LOGGER.warn("Username cannot be empty");
			throw new EntityNotFoundException();
		}
		Optional<User> userOptional = userRepository.findByUsername(username);
		if (!userOptional.isPresent()) {
			LOGGER.warn("No such user");
			throw new EntityNotFoundException();
		}
		UserDto candidateUser = userMapper.entityToDto(userOptional.get());
		return candidateUser;
	}

	public UserDto login(LoginRequest loginRequest) throws EntityNotFoundException
	{
		if (loginRequest.getUsername() == null || loginRequest.getPassword() == null )
		{
			LOGGER.warn("Credentials cannot be empty");
			throw new EntityNotFoundException();
		}
		Optional<User> userOptional = userRepository.findByUsername(loginRequest.getUsername());
		if (!userOptional.isPresent()) {
			LOGGER.warn("No such user");
			throw new EntityNotFoundException();
		}
		UserDto candidateUser = userMapper.entityToDto(userOptional.get());
		if (!candidateUser.getPassword().equals(loginRequest.getPassword()))
		{
			LOGGER.warn("Password does not match");
			throw new EntityNotFoundException();
		}
		return candidateUser;
	}

	public UserDto register(RegisterRequest registerRequest) throws EntityNotFoundException
	{
		Optional<User> userOptional = userRepository.findByUsername(registerRequest.getUsername());
		if (userOptional.isPresent()) {
			LOGGER.warn("Username taken");
			throw new EntityNotFoundException();
		}
		UserDto userDto = new UserDto(registerRequest.getUsername(), registerRequest.getPassword(),
				registerRequest.getFullName(), new Date(registerRequest.getYear() - 1900,
				registerRequest.getMonth(), registerRequest.getDate()));
		return super.create(userDto);
	}
}
