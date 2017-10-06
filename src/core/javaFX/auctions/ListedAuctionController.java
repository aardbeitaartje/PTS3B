package core.javaFX.auctions;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class ListedAuctionController {

    @FXML private Label lblAuctionTitle, lblCurrentOffer;
    @FXML private Text textAuctionDescription;
    @FXML private Label lblListedAuctionId;

    public void setTitle(final String title) {
        lblAuctionTitle.setText(title);
    }

    public void setDescription(final String description) { textAuctionDescription.setText(description); }

    public void setCurrentOffer(final double offer) { lblCurrentOffer.setText(String.valueOf(offer)); }

    public void setId(final int id) { lblListedAuctionId.setText(String.valueOf(id)); }

    public void hideIdLabel() { lblListedAuctionId.setVisible(false); }

    public void loadAuctionPage() {
        System.out.println("We should now load the auction's page with Id: " + getAuctionId());
    }

    private int getAuctionId() { return Integer.parseInt(lblListedAuctionId.getText()); }
}
