/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalyearproject_pharmacymanagementsystem;

import java.sql.Date;

/**
 *
 * @author ABUO BERNARD
 */
public class patientData {
    private String patient_id;
    private String first_name;
    private String last_name;
    private Date date_of_birth;
    private String gender;
    private String address;
    private String phone_number;
    private String insurance_provider;
    private String insurance_policy_number;
    private String allergy;
    private String medical_history;
    private String emergency_contact_name;
    private String emergency_contact_number;
    
    public patientData(String patient_id,String first_name,String last_name,Date date_of_birth,String gender,
            String address,String phone_number,String insurance_provider,String insurance_policy_number,
            String allergy, String medical_history, String emergency_contact_name, 
            String emergency_contact_number){
       
        this.patient_id = patient_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.address = address;
        this.phone_number = phone_number;
        this.insurance_provider = insurance_provider;
        this.insurance_policy_number = insurance_policy_number;
        this.allergy = allergy;
        this.medical_history = medical_history;
        this.emergency_contact_name = emergency_contact_name;
        this.emergency_contact_number = emergency_contact_number;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getInsurance_provider() {
        return insurance_provider;
    }

    public String getInsurance_policy_number() {
        return insurance_policy_number;
    }

    public String getAllergy() {
        return allergy;
    }

    public String getMedical_history() {
        return medical_history;
    }

    public String getEmergency_contact_name() {
        return emergency_contact_name;
    }

    public String getEmergency_contact_number() {
        return emergency_contact_number;
    }
}
