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
public class medicineData {
    private String id;
    private String name;
    private String invoice;
    private String generic;
    private String manufacturer;
    private String dosage;
    private String form;
    private String unit;
    private String ndc;
    private Date date;
    private String instructions;
    private Float price;
    private Integer qty;
    private String image;
    
    public medicineData(String id, String name, String invoice, String generic, String manufacturer,
            String dosage, String form, String unit, String ndc, Date date, String instructions, Float price,
            Integer qty, String image){
        this.id = id;
        this.name = name;
        this.invoice = invoice;
        this.generic = generic;
        this.manufacturer = manufacturer;
        this.dosage = dosage;
        this.form = form;
        this.unit = unit;
        this.ndc = ndc;
        this.date = date;
        this.instructions = instructions;
        this.price = price;
        this.qty = qty;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInvoice() {
        return invoice;
    }

    public String getGeneric() {
        return generic;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getDosage() {
        return dosage;
    }

    public String getForm() {
        return form;
    }

    public String getUnit() {
        return unit;
    }

    public String getNdc() {
        return ndc;
    }

    public Date getDate() {
        return date;
    }

    public String getInstructions() {
        return instructions;
    }

    public Float getPrice() {
        return price;
    }

    public Integer getQty() {
        return qty;
    }
    public String getImage() {
        return image;
    }
}
