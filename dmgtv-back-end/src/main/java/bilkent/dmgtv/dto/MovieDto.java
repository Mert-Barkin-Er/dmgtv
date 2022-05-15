package bilkent.dmgtv.dto;

import bilkent.dmgtv.dto.base.BaseDto;
import lombok.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto extends BaseDto<UUID>
{
	private String title;
	private int productionYear;
	private double rating;
	private int price_per_month;
	private int price_to_buy;
	private boolean ageRestricted;
	private double imdbRating;
	private int likeCount;
}
