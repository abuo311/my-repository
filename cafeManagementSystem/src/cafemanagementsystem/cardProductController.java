/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafemanagementsystem;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ABUO BERNARD
 */
public class cardProductController implements Initializable {

    @FXML
    private AnchorPane card_form;

    @FXML
    private Button prod_addBtn;

    @FXML
    private ImageView prod_imageView;

    @FXML
    private Label prod_name;

    @FXML
    private Label prod_price;

    @FXML
    private Spinner<Integer> prod_spinner;

    private productData prodData;

    private SpinnerValueFactory<Integer> spin;

    private Image image;

    private String prodID;
    private String type;
    private String prod_date;
    private String prod_image;

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Statement st;

    private Alert alert;

    public void setData(productData prodData) {
        this.prodData = prodData;
        prod_image = prodData.getImage();
        prod_date = String.valueOf(prodData.getDate());
        type = prodData.getType();
        prodID = prodData.getProductId();
        prod_name.setText(prodData.getProductName());
        prod_price.setText("$" + String.valueOf(prodData.getPrice()));
        String path = "File:" + prodData.getImage();
        image = new Image(path, 200, 103, false, true);
        prod_imageView.setImage(image);
        pr = prodData.getPrice();
    }
    private int qty;

    public void setQuantity() {
        spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        prod_spinner.setValueFactory(spin);
    }
    private double pr;
    private double totalP;

    public void addBtn() {

        MainFormController mForm = new MainFormController();
        mForm.customerID();
        qty = prod_spinner.getValue();
        String check = "";
        String checkAvailable = "SELECT status FROM product WHERE prod_id = '" + prodID + "'";

        con = Database.getConnect();

        try {
            int checkStck = 0;
            String checkStock = "SELECT stock FROM product WHERE prod_id = '"
                    + prodID + "'";
            ps = con.prepareStatement(checkStock);
            rs = ps.executeQuery();

            if (rs.next()) {
                checkStck = rs.getInt("stock"); 
            }
            
            if (checkStck == 0) {

                String updateStock = "UPDATE product SET prodName = '"
                        + prod_name.getText() + "', type = '"
                        + type + "', stock = 0, price = '"
                        + pr + "', status = 'Unavailable', image = '"
                        + prod_image + "', date = '"
                        + prod_date + "' WHERE prod_id = '"
                        + prodID + "'";
                
                ps = con.prepareStatement(updateStock);
                ps.executeUpdate();

            }

            ps = con.prepareStatement(checkAvailable);
            rs = ps.executeQuery();

            if (rs.next()) {
                check = rs.getString("status");
            }

            if (!check.equals("Available") || qty == 0) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message!");
                alert.setHeaderText(null);
                alert.setContentText("Something Wrong :3");
                alert.showAndWait();
            } else {

                if (checkStck < qty) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message!");
                    alert.setHeaderText(null);
                    alert.setContentText("Invalid. This Product is out of stock");
                    alert.showAndWait();
                } else {
                    prod_image = prod_image.replace("\\", "\\\\");
                    String insertData = "INSERT INTO customer(customer_id,prod_id,prodName,type,quantity,price,date,image,em_username)"
                            + "VALUES(?,?,?,?,?,?,?,?,?)";

                    ps = con.prepareStatement(insertData);
                    ps.setString(1, String.valueOf(data.cID));
                    ps.setString(2, prodID);
                    ps.setString(3, prod_name.getText());
                    ps.setString(4, type);
                    ps.setString(5, String.valueOf(qty));

                    totalP = (qty * pr);
                    ps.setString(6, String.valueOf(totalP));

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                    ps.setString(7, String.valueOf(sqlDate));
                    
                    ps.setString(8, prod_image);
                    ps.setString(9, data.username);
                    ps.executeUpdate();
                    int upStock = checkStck - qty;
                    

                    String updateStock = "UPDATE product SET prodName = '"
                            + prod_name.getText() + "', type = '"
                            + type + "', stock = "
                            + upStock + ", price = '"
                            + pr + "', status = '"
                            + check + "', image = '"
                            + prod_image + "', date = '"
                            + prod_date + "' WHERE prod_id = '"
                            + prodID + "'";

                    ps = con.prepareStatement(updateStock);
                    ps.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message!");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();
                    mForm.menuGetTotal();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setQuantity();
    }

}
