import { Button, TextField } from "@mui/material";
import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import "../css/LoginPage.css";

export default function LoginPage() {
    const [username, setUsername] = useState();
    const navigate = useNavigate();

    function handleLogin(e) {
        e.preventDefault();
        sessionStorage.setItem('username', JSON.stringify(username));
        if (username === "admin") {
            navigate("/employee");
        }
        else {
            navigate("/profile");
        }
    }

    return (
        <>
        <div className="LoginPage">
                Proceed to log into DMGTV:
            <form noValidate autoComplete="off" onSubmit={(e) => {handleLogin(e);}} style={{marginTop: "5%"}}>
                <TextField label="Username" onChange={(e) => {setUsername(e.target.value)}}/>
                <TextField label="Password" type="password"/>
                <Button type="submit" style={{ marginTop: "1.5%" }}>Authenticate</Button>
            </form>
        </div>
        <div className="Button"> </div>
        <div className="TextField1"> </div>
        <div className="TextField2"> </div>
        </>
    );
}