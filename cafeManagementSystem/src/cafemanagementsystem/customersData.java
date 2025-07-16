/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafemanagementsystem;

import java.sql.Date;

/**
 *
 * @author ABUO BERNARD
 */
public class customersData {
    private Integer id;
    private Integer customerID;
    private Double total;
    private Date date;
    private String em_username;
    
    public customersData(Integer id, Integer customerID, Double total, Date date,String em_username){
        this.id = id;
        this.customerID = customerID;
        this.total = total;
        this.date = date;
        this.em_username = em_username;
    }
    public Integer getId(){
        return id;
    }
    public Integer getCustomerID(){
        return customerID;
    }
    public Double getTotal(){
        return total;
    }
    public Date getDate(){
        return date;
    }
    public String getEm_username(){
        return em_username;
    }
}
