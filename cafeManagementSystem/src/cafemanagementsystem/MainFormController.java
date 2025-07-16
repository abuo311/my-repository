 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafemanagementsystem;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author ABUO BERNARD
 */
public class MainFormController implements Initializable {

    @FXML
    private Button customer_btn;

    @FXML
    private Button dashboard_btn;

    @FXML
    private Button inventory_ImportBtn;

    @FXML
    private Button inventory_addBtn;

    @FXML
    private Button inventory_btn;

    @FXML
    private Button inventory_clearBtn;

    @FXML
    private TableColumn<productData, String> inventory_col_date;

    @FXML
    private TableColumn<productData, String> inventory_col_price;

    @FXML
    private TableColumn<productData, String> inventory_col_productID;

    @FXML
    private TableColumn<productData, String> inventory_col_productName;

    @FXML
    private TableColumn<productData, String> inventory_col_status;

    @FXML
    private TableColumn<productData, String> inventory_col_stock;

    @FXML
    private TableColumn<productData, String> inventory_col_type;

    @FXML
    private Button inventory_deleteBtn;

    @FXML
    private AnchorPane inventory_form;

    @FXML
    private ImageView inventory_imageView;

    @FXML
    private TextField inventory_productID;

    @FXML
    private TextField inventory_productName;

    @FXML
    private TextField inventory_productPrice;

    @FXML
    private ComboBox<?> inventory_productStatus;

    @FXML
    private TextField inventory_productStock;

    @FXML
    private ComboBox<?> inventory_productType;

    @FXML
    private TableView<productData> inventory_tableView;

    @FXML
    private Button inventory_updateBtn;

    @FXML
    private Button logout_btn;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button menu_btn;

    @FXML
    private AnchorPane dashboard_form;
    @FXML
    private Label dashboard_NC;

    @FXML
    private Label dashboard_NSP;

    @FXML
    private Label dashboard_TDI;

    @FXML
    private Label dashboard_TI;

    @FXML
    private BarChart<?, ?> dashboard_customerChart;
    @FXML
    private AreaChart<?, ?> dashboard_incomeChart;

    @FXML
    private Label username;

    @FXML
    private Button menu_PayBtn;

    @FXML
    private Button menu_ReceiptBtn;

    @FXML
    private Button menu_RemoveBtn;

    @FXML
    private AnchorPane menu_form;

    @FXML
    private TextField menu_amount;

    @FXML
    private Label menu_change;

    @FXML
    private TableColumn<productData, String> menu_col_productName;

    @FXML
    private TableColumn<productData, String> menu_col_productPrice;

    @FXML
    private TableColumn<productData, String> menu_col_productQuantity;

    @FXML
    private GridPane menu_gridPane;

    @FXML
    private ScrollPane menu_scrolPane;

    @FXML
    private TableView<productData> menu_tableView;

    @FXML
    private Label menu_total;

    @FXML
    private AnchorPane customer_form;

    @FXML
    private TableColumn<customersData, String> customer_cashier;

    @FXML
    private TableColumn<customersData, String> customer_customerID;

    @FXML
    private TableColumn<customersData, String> customer_prodName;

    @FXML
    private TableView<customersData> customer_tableView;

    @FXML
    private TableColumn<customersData, String> customer_total;

    @FXML
    private TableColumn<customersData, String> customer_date;

    private Alert alert;
    //DATABASE TOOLS
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Statement st;
    private Image image;

    public void dashboardDisplayIncomeChart() {
        dashboard_incomeChart.getData().clear();
        String sql = "SELECT date, SUM(total) FROM receipt GROUP BY date ORDER BY TIMESTAMP(date)";
        con = Database.getConnect();

        try {
            XYChart.Series chart = new XYChart.Series<>();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                chart.getData().add(new XYChart.Data<>(rs.getString(1), rs.getDouble(2)));
            }
            dashboard_incomeChart.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dashboardDisplayCustomerChart() {
        dashboard_customerChart.getData().clear();
        String sql = "SELECT date, COUNT(id) FROM receipt GROUP BY date ORDER BY TIMESTAMP(date)";
        con = Database.getConnect();

        try {
            XYChart.Series chart = new XYChart.Series<>();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                chart.getData().add(new XYChart.Data<>(rs.getString(1), rs.getDouble(2)));
            }
            dashboard_customerChart.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dashboardDisplayNC() {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        String sql = "SELECT COUNT(id) FROM receipt WHERE date = '"
                + sqlDate + "'";
        con = Database.getConnect();
        try {
            int nc = 0;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                nc = rs.getInt("COUNT(id)");
            }
            dashboard_NC.setText(String.valueOf(nc));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dashboardDisplayTDI() {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        String sql = "SELECT SUM(total) FROM receipt WHERE date = '"
                + sqlDate + "'";

        con = Database.getConnect();
        try {
            double tdi = 0;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                tdi = rs.getDouble("SUM(total)");
            }
            dashboard_TDI.setText("$" + tdi);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dashboardDisplayTI() {
        double ti = 0;
        String sql = "SELECT SUM(total) FROM receipt";

        con = Database.getConnect();

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                ti = rs.getDouble("SUM(total)");
            }
            dashboard_TI.setText("$" + ti);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dashboardDisplayNSP() {
        int nsp = 0;
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        String sql = "SELECT COUNT(quantity) FROM customer WHERE date = '"
                + sqlDate + "'";
        con = Database.getConnect();

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                nsp = rs.getInt("COUNT(quantity)");
            }
            dashboard_NSP.setText(String.valueOf(nsp));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ObservableList<productData> cardListData = FXCollections.observableArrayList();

    public void inventoryAddBtn() {
        if (inventory_productID.getText().isEmpty()
                || inventory_productName.getText().isEmpty()
                || inventory_productType.getSelectionModel().getSelectedItem() == null
                || inventory_productStock.getText().isEmpty()
                || inventory_productPrice.getText().isEmpty()
                || inventory_productStatus.getSelectionModel().getSelectedItem() == null
                || data.path == null) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            String checkProd = "SELECT prod_id FROM Product WHERE prod_id = '" + inventory_productID.getText() + "'";
            con = Database.getConnect();

            try {
                st = con.createStatement();
                rs = st.executeQuery(checkProd);

                if (rs.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText(inventory_productID.getText() + " already taken");
                    alert.showAndWait();
                } else {
                    String inserData = "INSERT INTO Product "
                            + "(prod_id,prodName,type,stock,price,status,image,date) "
                            + "VALUES(?,?,?,?,?,?,?,?)";

                    ps = con.prepareStatement(inserData);
                    ps.setString(1, inventory_productID.getText());
                    ps.setString(2, inventory_productName.getText());
                    ps.setString(3, (String) inventory_productType.getSelectionModel().getSelectedItem());
                    ps.setString(4, inventory_productStock.getText());
                    ps.setString(5, inventory_productPrice.getText());
                    ps.setString(6, (String) inventory_productStatus.getSelectionModel().getSelectedItem());

                    String path = data.path;
                    path = path.replace("\\", "\\\\");

                    ps.setString(7, path);

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                    ps.setString(8, String.valueOf(sqlDate));
                    ps.executeUpdate();

                    inventoryShowListData();

                    inventoryClearBtn();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully added");
                    alert.showAndWait();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void inventoryUpdate() {
        if (inventory_productID.getText().isEmpty()
                || inventory_productName.getText().isEmpty()
                || inventory_productType.getSelectionModel().getSelectedItem() == null
                || inventory_productStock.getText().isEmpty()
                || inventory_productPrice.getText().isEmpty()
                || inventory_productStatus.getSelectionModel().getSelectedItem() == null
                || data.path == null || data.id == 0) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            String path = data.path;
            path = path.replace("\\", "\\\\");

            String updateData = "UPDATE product SET "
                    + "prod_id = '" + inventory_productID.getText() + "', prodName = "
                    + "'" + inventory_productName.getText() + "', type = "
                    + "'" + inventory_productType.getSelectionModel().getSelectedItem() + "', stock = "
                    + "'" + inventory_productStock.getText() + "', price = "
                    + "'" + inventory_productPrice.getText() + "', status = "
                    + "'" + inventory_productStatus.getSelectionModel().getSelectedItem() + "', image = "
                    + "'" + path + "', date = "
                    + "'" + data.date + "' WHERE id = " + data.id;

            con = Database.getConnect();

            try {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Product ID " + inventory_productID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    ps = con.prepareStatement(updateData);
                    ps.executeUpdate();
                    //TO UPDATE TABLE VIEW
                    inventoryShowListData();
                    //TO CLEAR ALL THE FILLS
                    inventoryClearBtn();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled!");
                    alert.showAndWait();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void inventoryDeleteBtn() {
        if (data.id == 0) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to DELETE Product ID " + inventory_productID.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            String deleteData = "DELETE FROM product WHERE id = " + data.id;
            con = Database.getConnect();

            try {
                if (option.get().equals(ButtonType.OK)) {
                    ps = con.prepareStatement(deleteData);
                    ps.executeUpdate();
                    //TO UPDATE TABLE VIEW
                    inventoryShowListData();
                    //TO CLEAR ALL THE FILLS
                    inventoryClearBtn();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled!");
                    alert.showAndWait();
                }
            } catch (Exception e) {
            }
        }
    }

    public void inventoryClearBtn() {
        inventory_productID.setText("");
        inventory_productName.setText("");
        inventory_productPrice.setText("");
        inventory_productStock.setText("");
        inventory_productStatus.getSelectionModel().clearSelection();
        inventory_productType.getSelectionModel().clearSelection();
        data.path = "";
        data.id = 0;
        inventory_imageView.setImage(null);
    }

    public void inventoryImportBtn() {
        FileChooser openFile = new FileChooser();
        openFile.getExtensionFilters().add(new FileChooser.ExtensionFilter("Open Image File", "*png", "*jpg"));
        File file = openFile.showOpenDialog(main_form.getScene().getWindow());

        if (file != null) {
            data.path = file.getAbsolutePath();
            image = new Image(file.toURI().toString(), 165, 185, false, true);

            inventory_imageView.setImage(image);
        }
    }

    public ObservableList<productData> inventoryDataList() {
        //TO MERGE DATA
        ObservableList<productData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM Product";

        con = Database.getConnect();

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            productData prodData;

            while (rs.next()) {
                prodData = new productData(rs.getInt("id"),
                        rs.getString("prod_id"),
                        rs.getString("prodName"),
                        rs.getString("type"),
                        rs.getInt("stock"),
                        rs.getDouble("price"),
                        rs.getString("status"),
                        rs.getString("image"),
                        rs.getDate("date"));
                listData.add(prodData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listData;
    }

    private ObservableList<productData> inventoryListData;

    //TO SHOW THE DATABASE TABLE
    public void inventoryShowListData() {

        inventoryListData = inventoryDataList();

        inventory_col_productID.setCellValueFactory(new PropertyValueFactory<>("productId"));
        inventory_col_productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        inventory_col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        inventory_col_stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        inventory_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        inventory_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
        inventory_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        inventory_tableView.setItems(inventoryListData);
    }

    public void inventorySelectData() {
        productData prodData = inventory_tableView.getSelectionModel().getSelectedItem();
        int num = inventory_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < - 1) {
            return;
        }
        inventory_productID.setText(prodData.getProductId());
        inventory_productName.setText(prodData.getProductName());
        inventory_productStock.setText(String.valueOf(prodData.getStock()));
        inventory_productPrice.setText(String.valueOf(prodData.getPrice()));

        data.path = prodData.getImage();

        String path = "File:" + prodData.getImage();
        data.date = String.valueOf(prodData.getDate());
        data.id = prodData.getId();

        image = new Image(path, 165, 185, false, true);
        inventory_imageView.setImage(image);

    }

    private String[] typeList = {"Meals", "Drinks"};

    public void inventoryTypeList() {
        List<String> typeL = new ArrayList<>();
        for (String data : typeList) {
            typeL.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(typeL);

        inventory_productType.setItems(listData);
    }

    private String[] statusList = {"Available", "Unavailable"};

    public void inventoryStatusList() {
        List<String> listS = new ArrayList<>();

        for (String data : statusList) {
            listS.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(listS);
        inventory_productStatus.setItems(listData);
    }

    public ObservableList<productData> menuGetData() {
        String sql = "SELECT * FROM product";

        ObservableList listData = FXCollections.observableArrayList();

        con = Database.getConnect();

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            productData prod;

            while (rs.next()) {
                prod = new productData(rs.getInt("id"),
                        rs.getString("prod_id"),
                        rs.getString("prodName"),
                        rs.getString("type"),
                        rs.getInt("stock"),
                        rs.getDouble("price"),
                        rs.getString("image"),
                        rs.getDate("date"));

                listData.add(prod);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listData;
    }

    public void menuDisplayCard() {
        cardListData.clear();
        cardListData.addAll(menuGetData());

        int row = 0;
        int column = 0;

        menu_gridPane.getChildren().clear();
        menu_gridPane.getRowConstraints().clear();
        menu_gridPane.getColumnConstraints().clear();

        for (int q = 0; q < cardListData.size(); q++) {
            try {
                FXMLLoader load = new FXMLLoader();
                load.setLocation(getClass().getResource("cardProduct.fxml"));
                AnchorPane pane = load.load();
                cardProductController cardC = load.getController();
                cardC.setData(cardListData.get(q));

                if (column == 3) {
                    column = 0;
                    row += 1;
                }

                menu_gridPane.add(pane, column++, row);
                GridPane.setMargin(pane, new Insets(10));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ObservableList<productData> menuGetOrder() {
        customerID();
        ObservableList<productData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM customer WHERE customer_id = " + cID;
        con = Database.getConnect();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            productData prod;
            while (rs.next()) {
                prod = new productData(rs.getInt("id"),
                        rs.getString("prod_id"),
                        rs.getString("prodName"),
                        rs.getString("type"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"),
                        rs.getString("image"),
                        rs.getDate("date"));
                listData.add(prod);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
    private ObservableList<productData> menuOrderListData;

    public void menuShowOrderData() {
        menuOrderListData = menuGetOrder();
        menu_col_productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        menu_col_productQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        menu_col_productPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        menu_tableView.setItems(menuOrderListData);
    }
    private int getid;

    public void menuSelectOrder() {
        productData prod = menu_tableView.getSelectionModel().getSelectedItem();
        int num = menu_tableView.getSelectionModel().getFocusedIndex();

        if ((num - 1) < -1) {
            return;
        }
        getid = prod.getId();
    }
    private double totalP;

    public void menuGetTotal() {
        customerID();
        String total = "SELECT SUM(price) FROM customer WHERE customer_id = " + cID;
        con = Database.getConnect();

        try {
            ps = con.prepareStatement(total);
            rs = ps.executeQuery();

            while (rs.next()) {
                totalP = rs.getDouble("SUM(price)");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void menuDisplayTotal() {
        menuGetTotal();
        menu_total.setText("$" + totalP);

    }
    private double amount;
    private double change;

    public void menuAmount() {
        menuGetTotal();
        if (menu_amount.getText().isEmpty() || totalP == 0) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message!");
            alert.setHeaderText(null);
            alert.setContentText("Invalid :3");
            alert.showAndWait();
        } else {
            amount = Double.parseDouble(menu_amount.getText());

            if (amount < totalP) {
                menu_amount.setText("");
            } else {
                change = (amount - totalP);
            }
            menu_change.setText("$" + change);
        }
    }

    public void menuPayBtn() {
        if (totalP == 0) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message!");
            alert.setHeaderText(null);
            alert.setContentText("Invalid :3");
            alert.showAndWait();
        } else {
            menuGetTotal();
            String insertPay = "INSERT INTO receipt(customer_id,total,date,em_username)"
                    + "VALUES(?,?,?,?)";
            con = Database.getConnect();
            try {
                if (amount == 0) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message!");
                    alert.setHeaderText(null);
                    alert.setContentText("Please choose your order first!");
                    alert.showAndWait();
                } else {
                    alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Message!");
                    alert.setHeaderText(null);
                    alert.setContentText("Are you sure?");
                    Optional<ButtonType> option = alert.showAndWait();

                    if (option.get().equals(ButtonType.OK)) {
                        customerID();
                        menuGetTotal();
                        ps = con.prepareStatement(insertPay);
                        ps.setString(1, String.valueOf(cID));
                        ps.setString(2, String.valueOf(totalP));
                        Date date = new Date();
                        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                        ps.setString(3, String.valueOf(sqlDate));
                        ps.setString(4, data.username);
                        ps.executeUpdate();

                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Message!");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully");
                        alert.showAndWait();

                        menuShowOrderData();
                        
                       
                        

                    } else {
                        alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Information Message!");
                        alert.setHeaderText(null);
                        alert.setContentText("Cancelled");
                        alert.showAndWait();
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void menuRemoveBtn() {
        if (getid == 0) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select the order you want to remove.");
            alert.showAndWait();
        } else {
            String deleteData = "DELETE FROM customer WHERE id = " + getid;
            con = Database.getConnect();

            try {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message!");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to remove this order?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    ps = con.prepareStatement(deleteData);
                    ps.executeUpdate();
                }

                menuShowOrderData();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void menuReceipt() {
        if (totalP == 0 || menu_amount.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message!");
            alert.setHeaderText(null);
            alert.setContentText("Please order first!");
            alert.showAndWait();
        } else {
            HashMap map = new HashMap();
            map.put("getReceipt", (cID - 1));
            try {
                JasperDesign jDasign = JRXmlLoader.load("C:\\Users\\ABUO BERNARD\\Desktop\\Programming Projects\\Java Projects\\cafeManagementSystem\\CafeReport.jrxml");
                JasperReport jReport = JasperCompileManager.compileReport(jDasign);
                JasperPrint jPrint = JasperFillManager.fillReport(jReport, map, con);
                JasperViewer.viewReport(jPrint, false);

                menuRestart();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void menuRestart() {
        change = 0;
        amount = 0;
        totalP = 0;
        menu_change.setText("$0.0");
        menu_amount.setText("");
        menu_total.setText("$0.0");

    }
    private ObservableList<productData> menuListData;

    private int cID;

    public void customerID() {
        String sql = "SELECT MAX(customer_id) FROM customer";
        con = Database.getConnect();

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                cID = rs.getInt("MAX(customer_id)");
            }

            String checkCID = "SELECT MAX(customer_id) FROM receipt";
            ps = con.prepareStatement(checkCID);
            rs = ps.executeQuery();
            int checkID = 0;
            if (rs.next()) {
                checkID = rs.getInt("MAX(customer_id)");
            }
            if (cID == 0) {
                cID += 1;
            } else if (cID == checkID) {
                cID += 1;
            }

            data.cID = cID;

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ObservableList<customersData> customersDtaList() {
        ObservableList<customersData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM receipt";

        con = Database.getConnect();

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            customersData cData;

            while (rs.next()) {
                cData = new customersData(rs.getInt("id"),
                        rs.getInt("customer_id"),
                        rs.getDouble("total"),
                        rs.getDate("date"),
                        rs.getString("em_username"));

                listData.add(cData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listData;
    }

    private ObservableList<customersData> customerListData;

    public void customersShowData() {
        customerListData = customersDtaList();

        customer_customerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        customer_total.setCellValueFactory(new PropertyValueFactory<>("total"));
        customer_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        customer_cashier.setCellValueFactory(new PropertyValueFactory<>("em_username"));

        customer_tableView.setItems(customerListData);
    }

    public void switchForm(ActionEvent event) {

        if (event.getSource() == dashboard_btn) {
            dashboard_form.setVisible(true);
            inventory_form.setVisible(false);
            menu_form.setVisible(false);
            customer_form.setVisible(false);

            dashboardDisplayIncomeChart();
            dashboardDisplayCustomerChart();
            dashboardDisplayNC();
            dashboardDisplayTI();
            dashboardDisplayTDI();
            dashboardDisplayNSP();
        } else if (event.getSource() == inventory_btn) {
            dashboard_form.setVisible(false);
            inventory_form.setVisible(true);
            menu_form.setVisible(false);
            customer_form.setVisible(false);

            inventoryTypeList();
            inventoryStatusList();
            inventoryShowListData();

        } else if (event.getSource() == menu_btn) {
            dashboard_form.setVisible(false);
            inventory_form.setVisible(false);
            menu_form.setVisible(true);
            customer_form.setVisible(false);

            menuDisplayCard();
            menuDisplayTotal();
            menuShowOrderData();
        } else if (event.getSource() == customer_btn) {
            dashboard_form.setVisible(false);
            inventory_form.setVisible(false);
            menu_form.setVisible(false);
            customer_form.setVisible(true);

            customersShowData();
        }

    }

    public void logout() {
        try {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message!");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                //To hide the main form
                logout_btn.getScene().getWindow().hide();
                //To link the login form and show it as well
                Image applicationIcon = new Image(getClass().getResource("Bernito logo.png").toString());
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

                Stage stage = new Stage();
                Scene scene = new Scene(root);

                stage.setTitle("Cafe Shop Management System");
                stage.setScene(scene);
                stage.show();
                stage.getIcons().add(applicationIcon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayUsername() {
        String user = data.username;
        user = user.substring(0, 1).toUpperCase() + user.substring(1);
        username.setText(user);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        displayUsername();

        dashboardDisplayIncomeChart();
        dashboardDisplayCustomerChart();
        dashboardDisplayNC();
        dashboardDisplayTI();
        dashboardDisplayTDI();
        dashboardDisplayNSP();

        inventoryTypeList();
        inventoryStatusList();
        inventoryShowListData();

        menuDisplayCard();
        menuGetOrder();
        menuDisplayTotal();
        menuShowOrderData();

        customersShowData();
    }

}
