package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ManagementLoginFormController{

    public TextField txtUsername;
    public PasswordField pwdPassword;
    public AnchorPane loginContext;

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        if (txtUsername.getText().equals("admin") && pwdPassword.getText().equals("1234")){
            Stage stage = (Stage) loginContext.getScene().getWindow();
            stage.setTitle("Parking System");
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ParkingListForm.fxml"))));
            stage.centerOnScreen();

        }else{
            new Alert(Alert.AlertType.WARNING, "You have entered an invalid username or password. Please try again.").show();
        }
    }

    public void btnCancelOnAction(ActionEvent actionEvent) throws IOException {
        Parent window = FXMLLoader.load(getClass().getResource("../view/FirstInterfaceForm.fxml"));
        Scene newScene = new Scene(window);
        Stage mainWindow = (Stage)  ((Node)actionEvent.getSource()).getScene().getWindow();
        mainWindow.setTitle("Log In");
        mainWindow.setScene(newScene);
        mainWindow.centerOnScreen();
    }
}
