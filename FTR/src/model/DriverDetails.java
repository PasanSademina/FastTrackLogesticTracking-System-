/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author cnn
 */
public class DriverDetails {

    /**
     * @return the driver_id
     */
    public int getDriver_id() {
        return driver_id;
    }

    /**
     * @param driver_id the driver_id to set
     */
    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    /**
     * @return the driverName
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * @param driverName the driverName to set
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    /**
     * @return the driverContact
     */
    public String getDriverContact() {
        return driverContact;
    }

    /**
     * @param driverContact the driverContact to set
     */
    public void setDriverContact(String driverContact) {
        this.driverContact = driverContact;
    }
    private int driver_id;
    private String  driverName;
    private String  driverContact;
     
}
