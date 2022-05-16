package bilkent.dmgtv.service;

import bilkent.dmgtv.db.ReviewRequest;
import bilkent.dmgtv.dto.FriendDto;
import bilkent.dmgtv.dto.MovieDto;
import bilkent.dmgtv.dto.ReviewDto;
import bilkent.dmgtv.service.base.BaseCrudService;

public interface ReviewService extends BaseCrudService<ReviewDto>
{
    ReviewDto add(ReviewRequest reviewRequest);
    void calculateRating(String movieId);
}
