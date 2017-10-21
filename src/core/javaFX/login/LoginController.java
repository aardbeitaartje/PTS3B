package core.javaFX.login;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import core.javaFX.menu.MenuController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController extends MenuController {

    @FXML private JFXTextField txtUsername;
    @FXML private JFXPasswordField txtPassword;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
    }

    public void login() throws IOException {
        if (txtUsername.getText().isEmpty() || txtPassword.getText().isEmpty()) {
            //TODO: Actual client side feedback
            System.out.println("Please fill in both a username and a password!");
            return;
        }

        try {
            applicationManager.login(txtUsername.getText(), txtPassword.getText());
        } catch (SQLException exception) {
            //TODO: Actual client side feedback
            System.out.println("Incorrect login credentials!");
            System.out.println("Error: " + exception.getMessage());
            return;
        }

        if (applicationManager.isLoggedIn()) {
            paneContent.getChildren().clear();
            final Pane newLoadedPane = FXMLLoader.load(getClass().getResource("/core/javafx/auctions/auctions.fxml"));
            paneContent.getChildren().add(newLoadedPane);
        } else {
            //TODO: Actual client side feedback
            System.out.println("Something went wrong, please try again.");
        }
    }

    public void register() throws IOException {
        paneContent.getChildren().clear();
        final Pane newLoadedPane = FXMLLoader.load(getClass().getResource("/core/javafx/register/register.fxml"));
        paneContent.getChildren().add(newLoadedPane);
    }
}
