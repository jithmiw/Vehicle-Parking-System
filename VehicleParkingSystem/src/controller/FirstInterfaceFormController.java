package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import database.DriverDatabase;
import database.VehicleDatabase;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Bus;
import model.CargoLorry;
import model.Driver;
import model.Van;
import tm.Vehicle;
import tm.VehicleTM;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import static model.Bus.slotNoBus;
import static model.CargoLorry.slotNoLorry;
import static model.Van.*;

public class FirstInterfaceFormController{
    public static ArrayList<VehicleTM> parkedTable = new ArrayList<>();
    public static ArrayList<VehicleTM> deliveryTable = new ArrayList<>();
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
    public static String[] parkingSlots = new String[14];
    public static int slotNo;
    public static String driverName;
    public String isPark;
    public JFXComboBox<String> cmbVehicleNo;
    public JFXComboBox<String> cmbDriver;
    public JFXTextField txtVehicleType;
    public AnchorPane context;
    public Text txtSlotNo;
    public Text txtDate;
    public Text txtTime;
    public JFXButton btnPark;
    public JFXButton btnOnDelivery;

    public void initialize(){
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm:ss a");
            txtDate.setText(LocalDateTime.now().format(dateFormat));
            txtTime.setText(LocalDateTime.now().format(timeFormat));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

        ObservableList<String> vehicleNoList = FXCollections.observableArrayList();
        for (Vehicle v : VehicleDatabase.vehicleTable) {
            vehicleNoList.add(v.getVehicleNumber());
            cmbVehicleNo.setValue(v.getVehicleNumber());
            txtVehicleType.setText(v.getVehicleType());
            if(v.getVehicleType().equals("Bus")) txtSlotNo.setText(String.valueOf(slotNoBus(cmbVehicleNo.getValue())));
            else if(v.getVehicleType().equals("Van")) txtSlotNo.setText(String.valueOf(slotNoVan(cmbVehicleNo.getValue())));
            else txtSlotNo.setText(String.valueOf(slotNoLorry(cmbVehicleNo.getValue())));
        }
        cmbVehicleNo.setItems(vehicleNoList);

        ObservableList<String> driverList = FXCollections.observableArrayList();
        for (Driver d : DriverDatabase.driverTable) {
            driverList.add(d.getDriverName());
            cmbDriver.setValue(d.getDriverName());
        }
        cmbDriver.setItems(driverList);

        cmbVehicleNo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{
            isPark="";
            for (VehicleTM v : parkedTable) {
                if(v.getVehicleNumber().equals(newValue)){
                    isPark ="true";
                    break;
                }
            }
            for (VehicleTM vehicle : deliveryTable) {
                if(vehicle.getVehicleNumber().equals(newValue)){
                    isPark ="false";
                    break;
                }
            }
            btnPark.setDisable(isPark.equals("true"));
            btnOnDelivery.setDisable(isPark.equals("false")||isPark.equals(""));

            for (Vehicle v : VehicleDatabase.vehicleTable) {
                if (newValue.equals(v.getVehicleNumber()) && v.getVehicleType().equals("Bus")) {
                    txtVehicleType.setText(v.getVehicleType());
                    txtSlotNo.setText(String.valueOf(slotNoBus(cmbVehicleNo.getValue())));
                    break;
                }else if (newValue.equals(v.getVehicleNumber()) && v.getVehicleType().equals("Van")){
                    txtVehicleType.setText(v.getVehicleType());
                    txtSlotNo.setText(String.valueOf(slotNoVan(cmbVehicleNo.getValue())));
                    break;
                }else if (newValue.equals(v.getVehicleNumber()) && v.getVehicleType().equals("Cargo Lorry")){
                    txtVehicleType.setText(v.getVehicleType());
                    txtSlotNo.setText(String.valueOf(slotNoLorry(cmbVehicleNo.getValue())));
                    break;
                }
            }
        });
    }

    public void btnParkOnAction(ActionEvent actionEvent) {
        if(txtVehicleType.getText().equals("Bus")){
            slotNo=Integer.parseInt(txtSlotNo.getText());
            model.Vehicle bus=new Bus();
            bus.park(cmbVehicleNo.getValue(),txtVehicleType.getText());
        }else if(txtVehicleType.getText().equals("Van")){
            slotNo=Integer.parseInt(txtSlotNo.getText());
            model.Vehicle van=new Van();
            van.park(cmbVehicleNo.getValue(),txtVehicleType.getText());
        }else{
            slotNo=Integer.parseInt(txtSlotNo.getText());
            model.Vehicle cargoLorry=new CargoLorry();
            cargoLorry.park(cmbVehicleNo.getValue(),txtVehicleType.getText());
        }
        new Alert(Alert.AlertType.CONFIRMATION,"Park Your Vehicle.", ButtonType.OK).show();
    }

    public void btnDeliveryOnAction(ActionEvent actionEvent) {
        if(txtVehicleType.getText().equals("Bus")){
            driverName=cmbDriver.getValue();
            model.Vehicle bus=new Bus();
            bus.leavePark(cmbVehicleNo.getValue(),txtVehicleType.getText());
        }else if(txtVehicleType.getText().equals("Van")){
            driverName=cmbDriver.getValue();
            model.Vehicle van=new Van();
            van.leavePark(cmbVehicleNo.getValue(),txtVehicleType.getText());
        }else{
            driverName=cmbDriver.getValue();
            model.Vehicle cargoLorry=new CargoLorry();
            cargoLorry.leavePark(cmbVehicleNo.getValue(),txtVehicleType.getText());
        }
        new Alert(Alert.AlertType.CONFIRMATION,"Leave With Your Vehicle.", ButtonType.OK).show();
    }

    public static void managePark(String vehicleNumber, String vehicleType){
        deliveryTable.removeIf(vehicle -> vehicleNumber.equals(vehicle.getVehicleNumber()));
        tm.VehicleTM v = new tm.VehicleTM(vehicleNumber, vehicleType, slotNo, dateFormat.format(new Date())+" - "+timeFormat.format(new Date()));
        parkedTable.add(v);
    }

    public static int manageLeavePark(String vehicleNumber, String vehicleType){
        int slotNo = 0;
        for (VehicleTM vehicle : parkedTable) {
            if(vehicleNumber.equals(vehicle.getVehicleNumber())){
                slotNo = vehicle.getParkingSlot();
                parkedTable.remove(vehicle);
                break;
            }
        }
        tm.VehicleTM v = new tm.VehicleTM(vehicleNumber, vehicleType, driverName, dateFormat.format(new Date())+" - "+timeFormat.format(new Date()));
        deliveryTable.add(v);
        return slotNo;
    }

    public void btnMngLogin(ActionEvent actionEvent) throws IOException {
        Parent window = FXMLLoader.load(getClass().getResource("../view/ManagementLoginForm.fxml"));
        Scene newScene = new Scene(window);
        Stage mainWindow = (Stage)  ((Node)actionEvent.getSource()).getScene().getWindow();
        mainWindow.setTitle("Log In");
        mainWindow.setScene(newScene);
        mainWindow.centerOnScreen();
    }
}
