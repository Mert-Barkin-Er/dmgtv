import "../css/ProfilePage.css"
import React, {useState} from "react";
import TextField from '@mui/material/TextField';
import {Button} from "@mui/material";
import {AdapterDateFns} from '@mui/x-date-pickers/AdapterDateFns';
import { DesktopDatePicker } from '@mui/x-date-pickers/DesktopDatePicker';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';

export default function ProfileDetails() {
    const [username, setUsername] = useState(JSON.parse(sessionStorage.getItem('username')));
    const [fullname, setFullname] = useState("Doruk Kantarcıoğlu");
    const [password, setPassword] = useState("password");
    const [birthdate, setBirthdate] = useState(new Date(2001, 6, 3));
    const [editedFullname, setEditedFullname] = useState();
    const [editedPassword, setEditedPassword] = useState();
    const [editedBirthdate, setEditedBirthdate] = useState(new Date(2001, 6, 3));

    function handleFullname(e) {
        e.preventDefault();
        setFullname(editedFullname);
    }

    function handlePassword(e) {
        e.preventDefault();
        setPassword(editedPassword);
    }

    function handleBirthdate(e) {
        e.preventDefault();
        setBirthdate(editedBirthdate);
    }

    return (
        <LocalizationProvider dateAdapter={AdapterDateFns}>
            <div className="ProfileDetails">
                Edit profile details
                <div>
                    <TextField disabled label="Username" defaultValue={username} style={{marginTop: "5%"}}/>
                </div>
                <form noValidate autoComplete="off" onSubmit={(e) => {handlePassword(e);}} style={{marginTop: "5%"}}>
                    <TextField label="Password" type="password" defaultValue={password} onChange={(e) => {setEditedPassword(e.target.value);}}/>
                    <Button type="submit">Change password</Button>
                </form>
                <form noValidate autoComplete="off" onSubmit={(e) => {handleFullname(e);}} style={{marginTop: "5%"}}>
                    <TextField label="Full name" defaultValue={fullname} onChange={(e) => {setEditedFullname(e.target.value);}}/>
                    <Button type="submit">Change full name</Button>
                </form>
                <form noValidate autoComplete="off" onSubmit={(e) => {handleBirthdate(e);}} style={{marginTop: "5%"}}>
                    <DesktopDatePicker label="Birth date" value={editedBirthdate} renderInput={(params) => <TextField {...params}/>} onChange={(e) => {setEditedBirthdate(e);}} style={{marginTop: "5%"}}/>
                    <Button type="submit">Change birth date</Button>
                </form>
            </div>
        </LocalizationProvider>
    );
}
