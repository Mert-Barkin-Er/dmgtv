import axios from "axios";
import { useEffect, useState } from "react";
import FriendList from "./FriendList";
import UserNavbar from "./UserNavbar";

//const friends = [{"username": "doruk"}, {"username": "kurod"}, {"username": "dk"}, {"username": "doruk"}, {"username": "doruk"}];

export default function FriendsPage() {
    const [friends, setFriends] = useState([]);

    useEffect(() => {
        (async function() {
            try {
                const response = await axios.get("http://localhost:8080/friend/getFriends/" + JSON.parse(sessionStorage.getItem("username")));
                console.log(response.data.data);
                setFriends(response.data.data);
            }
            catch (error) {
                console.log(error);
            }
        })();
    }, []);

    return (
        <div>
            <UserNavbar/>
            <FriendList friends={friends}/>
        </div>
    );
}