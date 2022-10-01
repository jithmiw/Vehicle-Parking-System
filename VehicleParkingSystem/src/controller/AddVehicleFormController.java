package controller;

import com.jfoenix.controls.JFXComboBox;
import database.VehicleDatabase;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import tm.Vehicle;

import java.util.Optional;

public class AddVehicleFormController {
    public TextField txtVehicleNo;
    public TextField txtMaxWeight;
    public TextField txtNoOfPassengers;
    public JFXComboBox<String> cmbVehicleType;
    public AnchorPane context;
    public Text typeValidity;
    public Text numberValidity;
    public Text maxWeightValidity;
    public Text passengersValidity;

    public void initialize(){
        ObservableList<String> vehicleTypeList = FXCollections.observableArrayList();
        for (Vehicle v: VehicleDatabase.vehicleTable) {
            if (!vehicleTypeList.contains(v.getVehicleType())){
                vehicleTypeList.add(v.getVehicleType());
            }
            cmbVehicleType.setValue(v.getVehicleType());
        }
        cmbVehicleType.setItems(vehicleTypeList);

        cmbVehicleType.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String s1, String s2) {
                if ((cmbVehicleType.getValue()).matches("[A-Za-z\\s]{2,}")) {
                    typeValidity.setText("Valid");
                    typeValidity.setFill(Color.GREEN);
                } else {
                    typeValidity.setText("Invalid");
                    typeValidity.setFill(Color.RED);
                }
            }
        });
        txtVehicleNo.textProperty().addListener((observable, oldValue, newValue) -> {
            if ((txtVehicleNo.getText()).matches("^([a-zA-Z]{1,3}|((?!0*-)[0-9]{1,3}))-[0-9]{4}(?<!0{4})")) {
                numberValidity.setText("Valid");
                numberValidity.setFill(Color.GREEN);
            } else {
                numberValidity.setText("Invalid");
                numberValidity.setFill(Color.RED);
            }
        });
        txtMaxWeight.textProperty().addListener((observable, oldValue, newValue) -> {
            if ((txtMaxWeight.getText()).matches("[0-9]{3,4}")) {
                maxWeightValidity.setText("Valid");
                maxWeightValidity.setFill(Color.GREEN);
            } else {
                maxWeightValidity.setText("Invalid");
                maxWeightValidity.setFill(Color.RED);
            }
        });
        txtNoOfPassengers.textProperty().addListener((observable, oldValue, newValue) -> {
            if ((txtNoOfPassengers.getText()).matches("[0-9]{1,2}")) {
                passengersValidity.setText("Valid");
                passengersValidity.setFill(Color.GREEN);
            } else {
                passengersValidity.setText("Invalid");
                passengersValidity.setFill(Color.RED);
            }
        });
    }
    public void btnAddVehicle(ActionEvent actionEvent) {
        Vehicle vehicle = new Vehicle(txtVehicleNo.getText(),cmbVehicleType.getValue(),Integer.parseInt(txtMaxWeight.getText()),Integer.parseInt(txtNoOfPassengers.getText()));
        VehicleDatabase.vehicleTable.add(vehicle);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Vehicle Added.", ButtonType.OK);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if(buttonType.get().equals(ButtonType.OK)){
            context.getScene().getWindow().hide();
        }

    }
}
