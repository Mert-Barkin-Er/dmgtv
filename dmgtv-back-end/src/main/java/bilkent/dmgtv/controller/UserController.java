package bilkent.dmgtv.controller;

import bilkent.dmgtv.controller.base.BaseController;
import bilkent.dmgtv.db.LoginRequest;
import bilkent.dmgtv.db.RegisterRequest;
import bilkent.dmgtv.dto.UserDto;
import bilkent.dmgtv.dto.base.RestResponse;
import bilkent.dmgtv.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("user")
public class UserController extends BaseController<UserDto>
{
	private final UserService userService;

	public UserController(UserService userService) {
		super(userService);
		this.userService = userService;
	}

	/**
	 * gets the user with the given details, used for authentication
	 * @param loginRequest of the user
	 * @return the user with the given details.
	 */
	@PostMapping(value = "login")
	public ResponseEntity<RestResponse<UserDto>> login(@RequestBody LoginRequest loginRequest)
	{
		try
		{
			return new ResponseEntity<>(new RestResponse<>(userService.login(loginRequest), "Login",
					"Entity retrieval was successful"),
					HttpStatus.OK);
		}
		catch (EntityNotFoundException e)
		{
			return new ResponseEntity<>(new RestResponse<>(null, "Login",
					"Entity retrieval was unsuccessful due to an error"),
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(new RestResponse<>(null, "Login","Unexpected error"),
					HttpStatus.EXPECTATION_FAILED);
		}
	}

	/**
	 * gets the user with the given details, used for authentication
	 * @param registerRequest of the user
	 * @return the user with the given details.
	 */
	@PostMapping(value = "register")
	public ResponseEntity<RestResponse<UserDto>> register(@RequestBody RegisterRequest registerRequest)
	{
		try
		{
			return new ResponseEntity<>(new RestResponse<>(userService.register(registerRequest), "Register",
					"Entity registration was successful"),
					HttpStatus.OK);
		}
		catch (EntityNotFoundException e)
		{
			return new ResponseEntity<>(new RestResponse<>(null, "Register",
					"Username taken"),
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(new RestResponse<>(null, "Register","Unexpected error"),
					HttpStatus.EXPECTATION_FAILED);
		}
	}
}
