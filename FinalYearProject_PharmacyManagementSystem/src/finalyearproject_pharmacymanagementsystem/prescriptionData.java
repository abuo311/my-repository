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
public class prescriptionData {

    private Integer customer_id;
    private String prescription_id;
    private String patient_id;
    private String medicine_id;
    private String doctor_id;
    private Date prescription_date;
    private Integer qty_prescribed;
    private String instructions;
    private String diagnosis;
    private String pharmacist_note;

    public prescriptionData(Integer customer_id,String prescription_id, String patient_id, String medicine_id,
            String doctor_id, Date prescription_date, Integer qty_prescribed, String instructions,
            String diagnosis, String pharmacist_note) {
        this.customer_id = customer_id;
        this.prescription_id = prescription_id;
        this.patient_id = patient_id;
        this.medicine_id = medicine_id;
        this.doctor_id = doctor_id;
        this.prescription_date = prescription_date;
        this.qty_prescribed = qty_prescribed;
        this.instructions = instructions;
        this.diagnosis = diagnosis;
        this.pharmacist_note = pharmacist_note;

    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public String getPrescription_id() {
        return prescription_id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public String getMedicine_id() {
        return medicine_id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public Date getPrescription_date() {
        return prescription_date;
    }

    public Integer getQty_prescribed() {
        return qty_prescribed;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getPharmacist_note() {
        return pharmacist_note;
    }
}
