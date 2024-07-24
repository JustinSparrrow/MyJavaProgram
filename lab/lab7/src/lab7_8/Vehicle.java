package lab7_8;

import javax.swing.*;

public class Vehicle {

    private int yearOfManufacture;
    private String producer;
    private String vehicleType;
    private String derivative;

    public Vehicle(int yearOfManufacture, String producer, String vehicleType, String derivative) {
        this.yearOfManufacture = yearOfManufacture;
        this.producer = producer;
        this.vehicleType = vehicleType;
        this.derivative = derivative;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getDerivative() {
        return derivative;
    }

    public void setDerivative(String derivative) {
        this.derivative = derivative;
    }
}
