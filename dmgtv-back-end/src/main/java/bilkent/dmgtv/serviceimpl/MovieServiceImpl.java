package bilkent.dmgtv.serviceimpl;

import bilkent.dmgtv.db.Movie;
import bilkent.dmgtv.dto.MovieDto;
import bilkent.dmgtv.repository.MovieRepository;
import bilkent.dmgtv.service.MovieService;
import bilkent.dmgtv.serviceimpl.base.BaseServiceImpl;
import bilkent.dmgtv.serviceimpl.mapper.MovieMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl extends BaseServiceImpl<Movie, MovieDto> implements MovieService
{
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceImpl.class);

	private final MovieRepository movieRepository;
	private final MovieMapper movieMapper;

	public MovieServiceImpl(MovieRepository movieRepository, MovieMapper movieMapper)
	{
		super(movieRepository, MovieMapper.INSTANCE);
		this.movieRepository = movieRepository;
		this.movieMapper = movieMapper;
	}


}