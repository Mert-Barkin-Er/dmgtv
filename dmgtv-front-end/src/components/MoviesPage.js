import MUIDataTables from "mui-datatables";
import { Button, Switch, Snackbar } from "@mui/material";
import UserNavbar from "./UserNavbar";
import { useState, useEffect } from "react";
import axios from "axios";

export default function MoviesPage() {
    const [movies, setMovies] = useState([]);
    const [rentSuccessful, setRentSuccessful] = useState(false);
    const [buySuccessful, setBuySuccessful] = useState(false);

    useEffect(() => {
        (async function() {
            try {
                const response = await axios.get("http://localhost:8080/movie/read");
                console.log(response.data);
                setMovies(response.data);
            }
            catch (error) {
                console.log(error);
            }
        })();
    }, []);

    function rentMovie(title) {
        const currentUser = JSON.parse(sessionStorage.getItem("username"));
        const rentURL = "http://localhost:8080/rent/rentMovie/" + title + "/" + currentUser;
        axios.post(rentURL).then((res) => {
            setRentSuccessful(true);
        }).catch((err) => {
            console.log(err);
            setRentSuccessful(false);
        });
    }

    function buyMovie(title) {
        const currentUser = JSON.parse(sessionStorage.getItem("username"));
        const rentURL = "http://localhost:8080/buy/buyMovie/" + title + "/" + currentUser;
        axios.post(rentURL).then((res) => {
            setBuySuccessful(true);
        }).catch((err) => {
            console.log(err);
            setBuySuccessful(false);
        });
    }

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
            name: "productionYear",
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
            name: "pricePerMonth",
            label: "Price Per Month",
            options: {
                filter: true,
                sort: true
            }
        },
        {
            name: "priceToBuy",
            label: "Price To Buy",
            options: {
                filter: true,
                sort: true
            }
        },
        {
            name: "ageRestricted",
            label: "Age restricted",
            options: {
                filter: true,
                sort: true,
                customBodyRender: (value, tableMeta, updateValue) => {
                    return (
                        <div>
                            <Switch checked={value}/>
                        </div>
                    );
                }
            }
        },
        {
            name: "imdbRating",
            label: "IMDB Rating",
            options: {
                filter: true,
                sort: true
            }
        },
        {
            name: "likeCount",
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
                            <Button onClick={() => {rentMovie(tableMeta.rowData[0]);}}>
                                Rent
                            </Button>
                            <Button onClick={() => {buyMovie(tableMeta.rowData[0]);}}>
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
            <Snackbar open={rentSuccessful} autoHideDuration={2000} message="Movie rented successfully!" onClose={() => {setRentSuccessful(false);}}/>
            <Snackbar open={buySuccessful} autoHideDuration={2000} message="Movie bought successfully!" onClose={() => {setBuySuccessful(false);}}/>
        </div>
    );
}