import { Button, List, ListItem, ListItemText, TextField } from "@mui/material";
import { useState } from "react";


export default function FriendList(props) {
    const [friends, setFriends] = useState(props.friends);
    const [friendUsername, setFriendUsername] = useState();

    function removeFriend(friend) {
        let index = friends.indexOf(friend);
        setFriends(friends.slice(0, index).concat(friends.slice(index + 1)));
    }

    function addFriend(e) {
        e.preventDefault();
        setFriends([...friends, {"username": friendUsername}]);
    }

    return (
        <div>
            Friend List
            <List style={{maxHeight: '250px', overflow: 'auto', marginBottom: "5%"}}>
                {friends.map((friend) => (
                    <ListItem>
                        <ListItemText primary={friend.username}/>
                        <Button onClick={() => {removeFriend(friend);}}>Remove friend</Button>
                    </ListItem>
                    ))
                }
            </List>
            Add a friend
            <form noValidate autoComplete="off" onSubmit={(e) => {addFriend(e);}}>
                <TextField label="Friend's username" onChange={(e) => {setFriendUsername(e.target.value);}}></TextField>
                <Button type="submit">Add friend</Button>
            </form>
        </div>
    );
}
