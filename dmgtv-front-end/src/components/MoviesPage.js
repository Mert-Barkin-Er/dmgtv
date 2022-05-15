import MUIDataTables from "mui-datatables";
import { Button, Switch } from "@mui/material";
import UserNavbar from "./UserNavbar";
import { useState } from "react";

const myMovies = [
    {"movie_id": 1, "title": "Test movie 1", "production_year": 2001, "rating": 4.3, "price_per_month": 23, "price_to_buy": 45, "age_restricted": true, "imdb_rating": 3.8, "like_count": 5},
    {"movie_id": 2, "title": "Test movie 2", "production_year": 1995, "rating": 4.8, "price_per_month": 29, "price_to_buy": 99, "age_restricted": false, "imdb_rating": 3.9, "like_count": 34}
];

export default function MoviesPage() {

    const [movies, setMovies] = useState(myMovies);

    const columns = [
        {
            name: "title",
            label: "Title",
            options: {
                filter: false,
                sort: true
            }
        },
        {
            name: "production_year",
            label: "Production Year",
            options: {
                filter: true,
                sort: true
            }
        },
        {
            name: "rating",
            label: "Rating",
            options: {
                filter: true,
                sort: true
            }
        },
        {
            name: "price_per_month",
            label: "Price Per Month",
            options: {
                filter: true,
                sort: true
            }
        },
        {
            name: "price_to_buy",
            label: "Price To Buy",
            options: {
                filter: true,
                sort: true
            }
        },
        {
            name: "age_restricted",
            label: "Age restricted",
            options: {
                filter: true,
                sort: true,
                customBodyRender: (value, tableMeta, updateValue) => {
                    console.log(value);
                    return (
                        <div>
                            <Switch checked={value}/>
                        </div>
                    );
                }
            }
        },
        {
            name: "imdb_rating",
            label: "IMDB Rating",
            options: {
                filter: true,
                sort: true
            }
        },
        {
            name: "like_count",
            label: "Like count",
            options: {
                filter: true,
                sort: true
            }
        },
        {
            name: "actions",
            label: "Actions",
            options: {
                customBodyRender: (value, tableMeta, updateValue) => {
                    return (
                        <div>
                            <Button onClick={() => {console.log(value, tableMeta);}}>
                                Rent
                            </Button>
                            <Button onClick={() => {console.log(value, tableMeta);}}>
                                Buy
                            </Button>
                        </div>
                    );
                }
            }
        }
    ];

    const options = {download: false, print: false, selectableRows: "none"};

    return (
        <div>
            <UserNavbar/>
            <MUIDataTables title="Movie List" data={movies} columns={columns} options={options}/>
        </div>
    );
}