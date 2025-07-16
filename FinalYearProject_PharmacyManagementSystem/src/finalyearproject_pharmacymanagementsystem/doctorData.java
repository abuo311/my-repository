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
public class doctorData {

    private String doctor_id;
    private String first_name;
    private String surname;
    private String specialisation;
    private String clinic_address;
    private String phone_number;
    private String license_number;

    public doctorData(String doctor_id, String first_name, String surname, String specilisation,
            String clinic_address, String phone_number, String license_number) {
        this.doctor_id = doctor_id;
        this.first_name = first_name;
        this.surname = surname;
        this.specialisation = specilisation;
        this.clinic_address = clinic_address;
        this.phone_number = phone_number;
        this.license_number = license_number;

    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public String getClinic_address() {
        return clinic_address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getLicense_number() {
        return license_number;
    }

}
