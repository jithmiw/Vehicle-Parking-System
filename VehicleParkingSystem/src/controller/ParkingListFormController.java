package controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tm.VehicleTM;

import java.io.IOException;

import static controller.FirstInterfaceFormController.parkedTable;

public class ParkingListFormController{
    public AnchorPane context;
    public JFXComboBox<String> cmb;
    public TableColumn colVehicleNo;
    public TableColumn colVehicleType;
    public TableColumn colParkingSlot;
    public TableColumn colParkedTime;
    public TableView<VehicleTM> parkingListTable;

    public void initialize(){
        ObservableList<String> obList = FXCollections.observableArrayList();
        obList.add("In Parking");
        obList.add("On Delivery");
        cmb.setItems(obList);

        colVehicleNo.setCellValueFactory(new PropertyValueFactory("vehicleNumber"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory("vehicleType"));
        colParkingSlot.setCellValueFactory(new PropertyValueFactory("parkingSlot"));
        colParkedTime.setCellValueFactory(new PropertyValueFactory("time"));

        ObservableList<VehicleTM> vehicleList = FXCollections.observableArrayList();

        vehicleList.addAll(parkedTable);
        parkingListTable.setItems(vehicleList);
    }

    public void btnAddVehicleOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AddVehicleForm", "Add Vehicle");
    }

    public void btnAddDriverOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AddDriverForm","Add Driver");
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setTitle("Parking System");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/FirstInterfaceForm.fxml"))));
        stage.centerOnScreen();
    }

    public void cmbOnAction(ActionEvent actionEvent) throws IOException {
        if(cmb.getValue().equals("On Delivery")){
            load("DeliveryListForm");
        }
    }

    public void setUi(String location,String title) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.setTitle(title);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }

    public void load(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setTitle("Parking System");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }
}
