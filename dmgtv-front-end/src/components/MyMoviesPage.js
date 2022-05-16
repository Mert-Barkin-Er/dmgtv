import { Button, Card, CardContent, Dialog, List, ListItem, Typography } from "@mui/material";
import { useEffect, useState } from "react";
import RentedMovie from "./RentedMovie";
import UserNavbar from "./UserNavbar";
import axios from "axios";

export default function MyMoviesPage() {
    const [rentedMovies, setRentedMovies] = useState([]);

    useEffect(() => {
        (async function() {
            try {
                const response = await axios.get("http://localhost:8080/rent/getMovies/" + JSON.parse(sessionStorage.getItem("username")));
                console.log(response.data.data);
                setRentedMovies(response.data.data);
            }
            catch (error) {
                console.log(error);
            }
        })();
    }, []);

    return (
        <div>
            <UserNavbar/>
            <Typography variant="h5" component="div" style={{marginTop: "2.5%", marginBottom: "2.5%"}}>
                Rented movies
            </Typography>
            <List>
                {rentedMovies.map((movie, index) => (
                    <ListItem key={index}>
                        <RentedMovie id={movie.id} title={movie.title} productionYear={movie.productionYear}/>
                    </ListItem>
                ))}
            </List>
        </div>
    );
}