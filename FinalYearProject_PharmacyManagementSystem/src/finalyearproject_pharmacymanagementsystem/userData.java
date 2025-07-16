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
public class userData {
    private Integer Id;
    private String name;
    private String email;
    private String role;
    private String password;
    private Date date;
    
    public userData(Integer Id, String name, String email, String role, String password, Date date){
        this.Id = Id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.password = password;
        this.date = date;
    }

    public Integer getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public Date getDate() {
        return date;
    }
    
}
