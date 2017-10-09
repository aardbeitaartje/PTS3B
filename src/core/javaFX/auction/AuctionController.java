package core.javaFX.auction;


import core.javaFX.menu.MenuController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logic.timers.AuctionCountdownTimer;
import models.Bid;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;

public class AuctionController extends MenuController {

    @FXML private Label lblAuctionTitle, lblAuctionSeller, lblTimer;
    @FXML private Text textAuctionDescription;
    @FXML private ImageView imgviewSelectedPicture, imgviewPicture1, imgviewPicture2, imgviewPicture3;
    @FXML private VBox vboxBids;

    private Timer auctionCountdown;

    @Override
    public void initialize(URL location, ResourceBundle resources) { }

    public void setTitle(final String title) { lblAuctionTitle.setText(title); }

    public void setDescription(final String description) { textAuctionDescription.setText(description); }

    public void setSeller(final String seller) { lblAuctionSeller.setText(seller); }

    public void setImages(final List<Image> images) {
        //TODO: set the selected image and fill the other imageviews with either placeholder images or the actual corresponding images
    }

    public void setBids(final List<Bid> bids, final double startBid) {
        if (bids != null && bids.size() > 0){
            for (final Bid bid : bids){
                final Label lblBid = new Label(bid.getAmount() + " - " + bid.getProfile().getUsername() + " - " + bid.getDate());
                vboxBids.getChildren().add(lblBid);
            }
        }else{
            final Label lblNoBids1 = new Label("Be the first one to place a bid!");
            final Label lblNoBids2 = new Label("The price to start bidding at is " + startBid);
            vboxBids.getChildren().add(lblNoBids1);
            vboxBids.getChildren().add(lblNoBids2);
        }
    }

    public void initializeCountdownTimer() {
        auctionCountdown = new Timer();
        auctionCountdown.schedule(new AuctionCountdownTimer(this), 0, 1000);
    }

    public void setTimer(final String timer) { lblTimer.setText(timer); }
}
