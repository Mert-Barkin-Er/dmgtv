import FriendList from "./FriendList";
import Navbar from "./Navbar";

const friends = [{"username": "doruk"}, {"username": "kurod"}, {"username": "dk"}, {"username": "doruk"}, {"username": "doruk"}];

export default function FriendsPage() {
    return (
        <div>
            <Navbar/>
            <FriendList friends={friends}/>
        </div>
    );
}