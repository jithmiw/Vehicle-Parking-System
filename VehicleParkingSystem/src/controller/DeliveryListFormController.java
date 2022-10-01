package controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import tm.VehicleTM;

import java.io.IOException;

import static controller.FirstInterfaceFormController.deliveryTable;

public class DeliveryListFormController extends ParkingListFormController{
    public AnchorPane context;
    public JFXComboBox<String> cmb;
    public TableColumn colVehicleNo;
    public TableColumn colVehicleType;
    public TableColumn colName;
    public TableColumn colLeftTime;
    public TableView<VehicleTM> deliveryListTable;

    public void initialize(){
        ObservableList<String> obList = FXCollections.observableArrayList();
        obList.add("On Delivery");
        obList.add("In Parking");
        cmb.setItems(obList);

        colVehicleNo.setCellValueFactory(new PropertyValueFactory("vehicleNumber"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory("vehicleType"));
        colName.setCellValueFactory(new PropertyValueFactory("driverName"));
        colLeftTime.setCellValueFactory(new PropertyValueFactory("time"));

        ObservableList<VehicleTM> vehicleList = FXCollections.observableArrayList();

        vehicleList.addAll(deliveryTable);
        deliveryListTable.setItems(vehicleList);
    }

    public void cmbOnAction(ActionEvent actionEvent) throws IOException {
        if(cmb.getValue().equals("In Parking")){
           load("ParkingListForm");
        }
    }
    public void btnAddVehicleOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AddVehicleForm","Add Vehicle");
    }

    public void btnAddDriverOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AddDriverForm","Add Driver");
    }
}
