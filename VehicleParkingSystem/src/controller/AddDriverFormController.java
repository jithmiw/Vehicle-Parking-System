package controller;

import database.DriverDatabase;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.Driver;

import java.util.Optional;

public class AddDriverFormController {
    public TextField txtNIC;
    public TextField txtLicenseNo;
    public TextField txtAddress;
    public TextField txtDriverName;
    public TextField txtContactNo;
    public AnchorPane context;
    public Text nameValidity;
    public Text nicValidity;
    public Text licenseNoValidity;
    public Text addressValidity;
    public Text contactNoValidity;

    public void initialize() {
        txtDriverName.textProperty().addListener((observable, oldValue, newValue) -> {
            if ((txtDriverName.getText()).matches("[A-Za-z\\s]{2,}")) {
                nameValidity.setText("Valid");
                nameValidity.setFill(Color.GREEN);
            } else {
                nameValidity.setText("Name must contain only letters");
                nameValidity.setFill(Color.RED);
            }
        });
        txtNIC.textProperty().addListener((observable, oldValue, newValue) -> {
            if ((txtNIC.getText()).matches("^([0-9]{9}[x|X|v|V]|[0-9]{12})$")) {
                nicValidity.setText("Valid");
                nicValidity.setFill(Color.GREEN);
            } else {
                nicValidity.setText("Invalid");
                nicValidity.setFill(Color.RED);
            }
        });
        txtLicenseNo.textProperty().addListener((observable, oldValue, newValue) -> {
            if ((txtLicenseNo.getText()).matches("^([x|X|B|B][0-9]{7})$")) {
                licenseNoValidity.setText("Valid");
                licenseNoValidity.setFill(Color.GREEN);
            } else {
                licenseNoValidity.setText("Invalid");
                licenseNoValidity.setFill(Color.RED);
            }
        });
        txtAddress.textProperty().addListener((observable, oldValue, newValue) -> {
            if ((txtAddress.getText()).matches("[A-Za-z,\\s\\d]{2,}")) {
                addressValidity.setText("Valid");
                addressValidity.setFill(Color.GREEN);
            } else {
                addressValidity.setText("Invalid");
                addressValidity.setFill(Color.RED);
            }
        });
        txtContactNo.textProperty().addListener((observable, oldValue, newValue) -> {
            if ((txtContactNo.getText()).matches("^(?:7|0)[0-9]{9,10}$")) {
                contactNoValidity.setText("Valid");
                contactNoValidity.setFill(Color.GREEN);
            } else {
                contactNoValidity.setText("Invalid");
                contactNoValidity.setFill(Color.RED);
            }
        });
    }
    public void btnAddDriverOnAction(ActionEvent actionEvent) {
        Driver driver = new Driver(txtDriverName.getText(),txtNIC.getText(),txtLicenseNo.getText(),txtAddress.getText(),Integer.parseInt(txtContactNo.getText()));
        DriverDatabase.driverTable.add(driver);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Driver Added.", ButtonType.OK);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if(buttonType.get().equals(ButtonType.OK)){
            context.getScene().getWindow().hide();
        }
    }
}
