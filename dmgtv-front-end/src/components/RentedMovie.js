import { Button, TextField, Rating, Card, CardContent, Dialog, DialogTitle, List, ListItem, Typography } from "@mui/material";
import { useState } from "react";

export default function RentedMovie(props) {
    const [rating, setRating] = useState();
    const [rateMovieDialogOpen, setRateMovieDialogOpen] = useState(false);
    const [reviewMovieDialogOpen, setReviewMovieDialogOpen] = useState(false);
    const [review, setReview] = useState("");
    const [editedReview, setEditedReview] = useState("");

    function reviewMovie(e) {
        e.preventDefault();
        setReview(editedReview);
        setReviewMovieDialogOpen(false);
    }

    return (
        <div>
            <Card>
                <CardContent>
                    <Typography>
                        {props.title}
                    </Typography>
                    <Typography>
                        {props.production_year}
                    </Typography>
                </CardContent>
            </Card>
            <Button onClick={() => {setRateMovieDialogOpen(true);}}>
                    Rate movie
            </Button>
            <Button onClick={() => {setReviewMovieDialogOpen(true);}}>
                    Review movie
            </Button>
            <Dialog open={rateMovieDialogOpen} onClose={() => {setRateMovieDialogOpen(false);}}>
                <DialogTitle style={{margin: "2.5%"}}>
                    Rate {props.title}
                </DialogTitle>
                <Rating size="large" onChange={(event, newValue) => {setRating(newValue);setRateMovieDialogOpen(false);}}/>
            </Dialog>
            <Dialog open={reviewMovieDialogOpen} onClose={() => {setReviewMovieDialogOpen(false);}}>
                <DialogTitle style={{margin: "2.5%"}}>
                    Review {props.title}
                </DialogTitle>
                <form noValidate autoComplete="off" onSubmit={(e) => {reviewMovie(e);}}>
                    <TextField multiline label="Comment" defaultValue={review} onChange={(e) => {setEditedReview(e.target.value);}}/>
                    <Button type="submit">Send review</Button>
                </form>
            </Dialog>
        </div>
    );
}