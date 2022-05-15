import FriendList from "./FriendList";
import UserNavbar from "./UserNavbar";

const friends = [{"username": "doruk"}, {"username": "kurod"}, {"username": "dk"}, {"username": "doruk"}, {"username": "doruk"}];

export default function FriendsPage() {
    return (
        <div>
            <UserNavbar/>
            <FriendList friends={friends}/>
        </div>
    );
}