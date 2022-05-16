package bilkent.dmgtv.service;

import bilkent.dmgtv.dto.FriendDto;
import bilkent.dmgtv.dto.UserDto;
import bilkent.dmgtv.service.base.BaseCrudService;

import java.util.List;

public interface FriendService extends BaseCrudService<FriendDto>
{
	FriendDto addFriend(String firstusername, String secondusername);
	List<UserDto> getFriends(String username);
}
