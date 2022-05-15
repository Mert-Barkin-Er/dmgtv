import { Button, Card, CardContent, Dialog, List, ListItem, Typography } from "@mui/material";
import { useState } from "react";
import RentedMovie from "./RentedMovie";
import UserNavbar from "./UserNavbar";

const myMovies = [
    {"movie_id": 1, "title": "Test movie 1", "production_year": 2001, "rating": 4.3, "price_per_month": 23, "price_to_buy": 45, "age_restricted": true, "imdb_rating": 3.8, "like_count": 5},
    {"movie_id": 2, "title": "Test movie 2", "production_year": 1995, "rating": 4.8, "price_per_month": 29, "price_to_buy": 99, "age_restricted": false, "imdb_rating": 3.9, "like_count": 34}
];

export default function MyMoviesPage() {
    const [rentedMovies, setRentedMovies] = useState(myMovies);

    return (
        <div>
            <UserNavbar/>
            <Typography variant="h5" component="div" style={{marginTop: "2.5%", marginBottom: "2.5%"}}>
                Rented movies
            </Typography>
            <List>
                {rentedMovies.map((movie, index) => (
                    <ListItem key={index}>
                        <RentedMovie title={movie.title} production_year={movie.production_year}/>
                    </ListItem>
                ))}
            </List>
        </div>
    );
}