package bilkent.dmgtv.controller;

import bilkent.dmgtv.controller.base.BaseController;
import bilkent.dmgtv.dto.MovieDto;
import bilkent.dmgtv.service.MovieService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movie")
public class MovieController extends BaseController<MovieDto>
{
	private final MovieService movieService;

	public MovieController(MovieService movieService)
	{
		super(movieService);
		this.movieService = movieService;
	}
}
