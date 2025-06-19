/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class CustomerDetails {

    
    public int getCustomer_id() {
        return customer_id;
    }

    /**
     * @param customer_id the customer_id to set
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the customerContact
     */
    public String getCustomerContact() {
        return customerContact;
    }

    /**
     * @param customerContact the customerContact to set
     */
    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    private int customer_id;
    private String customerName;
    private String customerContact;

}
