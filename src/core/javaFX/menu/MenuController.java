package core.javaFX.menu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML public Pane paneMenu;
    @FXML public Pane paneContent;
    @FXML public Pane paneBackground;
    @FXML public Label lblClose;

    @FXML public ImageView imgviewProfile;
    @FXML public ImageView imgviewAuctions;
    @FXML public ImageView imgviewFavorites;
    @FXML public ImageView imgviewAddAuction;

    protected ImageView selectedMenu;

    protected Image profileIcon;
    protected Image auctionsIcon;
    protected Image favoritesIcon;
    protected Image addAuctionIcon;
    protected Image closeIcon;

    protected Image profileIconHovered;
    protected Image auctionsIconHovered;
    protected Image favoritesIconHovered;
    protected Image addAuctionIconHovered;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setIcons();

        selectedMenu = imgviewProfile;
        imgviewProfile.setImage(profileIconHovered);

        try {
            paneContent.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("/core/javafx/login/login.fxml"));
            paneContent.getChildren().add(newLoadedPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void setIcons() {
        profileIcon = new Image( "/utilities/images/menu/profile.png");
        auctionsIcon = new Image("/utilities/images/menu/auction.png");
        favoritesIcon = new Image("/utilities/images/menu/favorites.png");
        addAuctionIcon = new Image("/utilities/images/menu/addauction.png");

        profileIconHovered = new Image("/utilities/images/menu/profile_hovered.png");
        auctionsIconHovered = new Image("/utilities/images/menu/auction_hovered.png");
        favoritesIconHovered = new Image("/utilities/images/menu/favorites_hovered.png");
        addAuctionIconHovered = new Image("/utilities/images/menu/addauction_hovered.png");

        imgviewProfile.setImage(profileIcon);
        imgviewAuctions.setImage(auctionsIcon);
        imgviewFavorites.setImage(favoritesIcon);
        imgviewAddAuction.setImage(addAuctionIcon);
    }

    public void closeApplication(MouseEvent mouseEvent) {
        System.exit(0);
    }

    public void selectMenuItem(MouseEvent mouseEvent) throws IOException {
        ImageView source = (ImageView) mouseEvent.getSource();
        imgviewProfile.setImage(profileIcon);
        imgviewAuctions.setImage(auctionsIcon);
        imgviewFavorites.setImage(favoritesIcon);
        imgviewAddAuction.setImage(addAuctionIcon);
        highlightIconColor(mouseEvent);
        ImageView icon = source;
        selectedMenu = icon;

        paneContent.getChildren().clear();
        Pane newLoadedPane;

        if (mouseEvent.getSource() == imgviewProfile){
            System.out.println("Profile");
            newLoadedPane = FXMLLoader.load(getClass().getResource("/core/javafx/profile/profile.fxml"));
        }
        else if(source == imgviewAuctions){
            System.out.println("Auctions");
            newLoadedPane = FXMLLoader.load(getClass().getResource("/core/javafx/auctions/auctions.fxml"));
        }
        else if(source == imgviewAddAuction){
            System.out.println("AddAuction");
            newLoadedPane = FXMLLoader.load(getClass().getResource("/core/javafx/addAuction/addauction.fxml"));
        }
        else if(source == imgviewFavorites){
            System.out.println("Favorites");
            newLoadedPane = FXMLLoader.load(getClass().getResource("/core/javafx/favorites/favorites.fxml"));
        }
        else{
            newLoadedPane = new Pane();
        }
        paneContent.getChildren().add(newLoadedPane);
    }

    public void highlightIconColor(MouseEvent mouseEvent) {
        ImageView icon = (ImageView) mouseEvent.getSource();
        if (Objects.equals(selectedMenu.getId(), icon.getId())) return;
        switch(icon.getId()) {
            case "imgviewProfile":
                imgviewProfile.setImage(profileIconHovered);
                break;
            case "imgviewAuctions":
                imgviewAuctions.setImage(auctionsIconHovered);
                break;
            case "imgviewFavorites":
                imgviewFavorites.setImage(favoritesIconHovered);
                break;
            case "imgviewAddAuction":
                imgviewAddAuction.setImage(addAuctionIconHovered);
                break;
        }
    }

    public void revertIconColor(MouseEvent mouseEvent) {
        ImageView icon = (ImageView) mouseEvent.getSource();
        if (Objects.equals(selectedMenu.getId(), icon.getId())) return;
        switch(icon.getId()) {
            case "imgviewProfile":
                imgviewProfile.setImage(profileIcon);
                break;
            case "imgviewAuctions":
                imgviewAuctions.setImage(auctionsIcon);
                break;
            case "imgviewFavorites":
                imgviewFavorites.setImage(favoritesIcon);
                break;
            case "imgviewAddAuction":
                imgviewAddAuction.setImage(addAuctionIcon);
                break;
        }
    }


}

