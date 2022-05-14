import { AppBar, CssBaseline, Toolbar } from "@mui/material";
import { Link } from "react-router-dom";

export default function Navbar() {
    return (
        <AppBar position="static">
            <CssBaseline/>
            <Toolbar>
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