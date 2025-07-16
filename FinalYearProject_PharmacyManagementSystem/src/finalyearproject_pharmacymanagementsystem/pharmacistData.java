/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalyearproject_pharmacymanagementsystem;

/**
 *
 * @author ABUO BERNARD
 */
public class pharmacistData {
    private String pharmacist_id;
    private String firstName;
    private String surname;
    private String licenseNumber;
    private String phoneNumber;
    
    public pharmacistData(String pharmacist_id, String firstName,
            String surname, String licenseNumber, String phoneNumber){
        this.pharmacist_id = pharmacist_id;
        this.firstName = firstName;
        this.surname = surname;
        this.licenseNumber = licenseNumber;
        this.phoneNumber = phoneNumber;
    }

    public String getPharmacist_id() {
        return pharmacist_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
}
