package bilkent.dmgtv.service;

import bilkent.dmgtv.dto.BuyDto;
import bilkent.dmgtv.service.base.BaseCrudService;

public interface BuyService extends BaseCrudService<BuyDto>
{
	BuyDto buyMovie(String movieTitle, String username);
}
