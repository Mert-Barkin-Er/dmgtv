package bilkent.dmgtv.service;

import bilkent.dmgtv.dto.FriendDto;
import bilkent.dmgtv.service.base.BaseCrudService;

public interface FriendService extends BaseCrudService<FriendDto>
{
	FriendDto addFriend(String firstusername, String secondusername);
}
