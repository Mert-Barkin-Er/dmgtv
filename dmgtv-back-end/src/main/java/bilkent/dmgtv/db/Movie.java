package bilkent.dmgtv.db;

import bilkent.dmgtv.db.base.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movie")
public class Movie extends BaseEntity
{
	@Column(name = "title", columnDefinition = "varchar(64)")
	private String title;

	@Column(name = "production_year", columnDefinition = "integer")
	private int productionYear;

	@Column(name = "rating", columnDefinition = "numeric(2,1)")
	private double rating;

	@Column(name = "price_per_month", columnDefinition = "integer",nullable = false)
	private int price_per_month;

	@Column(name = "price_to_buy", columnDefinition = "integer")
	private int price_to_buy;

	@Column(name = "age_restricted" , columnDefinition = "boolean")
	private boolean ageRestricted;

	@Column(name = "imdb_rating", columnDefinition = "numeric(2,1)")
	private double imdbRating;

	@Column(name = "like_count", columnDefinition = "integer")
	private int likeCount;
}
