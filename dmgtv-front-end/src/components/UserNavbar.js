import { AppBar, CssBaseline, Toolbar } from "@mui/material";
import { Link } from "react-router-dom";

export default function UserNavbar() {
    return (
        <AppBar position="static">
            <CssBaseline/>
            <Toolbar>
                <Link to="/movies" style={{margin: "25px 50px"}}>
                    Movies
                </Link>
                <Link to="/profile" style={{margin: "25px 50px"}}>
                    Profile
                </Link>
                <Link to="/friends" style={{margin: "25px 50px"}}>
                    Friends
                </Link>
                <Link to="/" style={{margin: "25px 50px"}} onClick={() => {sessionStorage.clear();}}>
                    Log out
                </Link>
            </Toolbar>
        </AppBar>
    );
}