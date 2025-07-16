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
public class inventoryData {
    private Integer inventory_id;
    private String medication_id;
    private String medication_name;
    private Integer quantity;
    private Integer reorder;
    private Date updates;
    private String lot_num;
    
    public inventoryData(Integer inventory_id, String medication_id, String medication_name, Integer quantity,
            Integer reorder, Date updates, String lot_num){
        this.inventory_id = inventory_id;
        this.medication_id = medication_id;
        this.medication_name = medication_name;
        this.quantity = quantity;
        this.reorder = reorder;
        this.updates = updates;
        this.lot_num = lot_num;
    }

    public String getMedication_name() {
        return medication_name;
    }

    public Integer getInventory_id() {
        return inventory_id;
    }

    public String getMedication_id() {
        return medication_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getReorder() {
        return reorder;
    }

    public Date getUpdates() {
        return updates;
    }

    public String getLot_num() {
        return lot_num;
    }
}
