import "../css/ProfilePage.css"
import React, {useState } from "react";
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemText from '@mui/material/ListItemText';
import IconButton from '@mui/material/IconButton';
import DeleteIcon from '@mui/icons-material/Delete';

const myWishlist = [{"id": 0, "title": "Godfather"}, {"id": 1, "title": "Showshank Redemption"}, {"id": 2, "title": "Pulp Fiction"}, {"id": 3, "title": "Matrix"}];

export default function Wishlist() {
    const [wishlist, setWishlist] = useState(myWishlist);

    function removeMovie(movie) {
        let index = wishlist.indexOf(movie);
        setWishlist(wishlist.slice(0, index).concat(wishlist.slice(index + 1)));
    }

    return (
        <div className="Wishlist">
            Wishlist
            <List>
                {wishlist.map((movie, key) => (
                    <ListItem key={key} secondaryAction={
                        <IconButton edge="end" aria-label="delete" onClick={() => {removeMovie(movie);}}>
                            <DeleteIcon/>
                        </IconButton>}>
                        <ListItemText primary={movie.title}/>
                    </ListItem>))
                }
            </List>
        </div>
    );
}