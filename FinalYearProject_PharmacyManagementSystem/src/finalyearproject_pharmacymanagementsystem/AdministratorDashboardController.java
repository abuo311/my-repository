/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalyearproject_pharmacymanagementsystem;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author ABUO BERNARD
 */
public class AdministratorDashboardController implements Initializable {

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button close;

    @FXML
    private Button minimize;

    @FXML
    private JFXButton admin_dashboard;

    @FXML
    private MenuButton admin_manageUsers;

    @FXML
    private MenuItem admin_addUser;

    @FXML
    private MenuItem admin_editUser;

    @FXML
    private MenuItem admin_deleteUser;

    @FXML
    private MenuButton admin_managerProdMed;

    @FXML
    private MenuItem admin_addProdMed;

    @FXML
    private MenuItem admin_editProdMed;

    @FXML
    private MenuItem admin_deleteProdMed;

    @FXML
    private MenuItem admin_viewMed;

    @FXML
    private JFXButton admin_changePassword;

    @FXML
    private JFXButton admin_logout;

    @FXML
    private Label admin_email;

    @FXML
    private AnchorPane admin_dashboard_form;

    @FXML
    private Label dash_totalNumerOfUsers;

    @FXML
    private Label dash_totalNumerOfProduct;

    @FXML
    private Label dash_todayIncome;

    @FXML
    private Label dash_expiringDate;
    @FXML
    private Label clockLabel;

    @FXML
    private AreaChart<?, ?> dash_tareaChart;

    @FXML
    private BarChart<?, ?> dash_barChart;

    @FXML
    private AnchorPane admin_addUser_form;

    @FXML
    private JFXTextField add_email;

    @FXML
    private JFXTextField add_name;

    @FXML
    private JFXTextField add_password;

    @FXML
    private JFXComboBox<?> add_role;

    @FXML
    private JFXButton add_registerBtn;

    @FXML
    private TableView<userData> add_tableView;

    @FXML
    private TableColumn<userData, String> add_col_id;

    @FXML
    private TableColumn<userData, String> add_col_name;

    @FXML
    private TableColumn<userData, String> add_col_email;

    @FXML
    private TableColumn<userData, String> add_col_role;

    @FXML
    private TableColumn<userData, String> add_col_password;

    @FXML
    private TableColumn<userData, String> add_col_date;

    @FXML
    private AnchorPane admin_editUser_form;

    @FXML
    private JFXTextField edit_email;

    @FXML
    private JFXTextField edit_name;

    @FXML
    private JFXTextField edit_password;

    @FXML
    private JFXComboBox<?> edit_role;

    @FXML
    private JFXButton edit_updateBtn;

    @FXML
    private TableView<userData> edit_tableView;

    @FXML
    private TableColumn<userData, String> edit_col_id;

    @FXML
    private TableColumn<userData, String> edit_col_name;

    @FXML
    private TableColumn<userData, String> edit_col_email;

    @FXML
    private TableColumn<userData, String> edit_col_password;

    @FXML
    private TableColumn<userData, String> edit_col_role;

    @FXML
    private TableColumn<userData, String> edit_col_date;

    @FXML
    private AnchorPane admin_deleteUser_form;

    @FXML
    private JFXTextField delete_email;

    @FXML
    private JFXTextField delete_name;

    @FXML
    private JFXTextField delete_password;

    @FXML
    private JFXComboBox<?> delete_role;

    @FXML
    private JFXButton delete_deleteBtn;

    @FXML
    private TableView<userData> delete_tableView;

    @FXML
    private TableColumn<userData, String> delete_col_id;

    @FXML
    private TableColumn<userData, String> delete_col_name;

    @FXML
    private TableColumn<userData, String> delete_col_email;

    @FXML
    private TableColumn<userData, String> delete_col_password;

    @FXML
    private TableColumn<userData, String> delete_col_role;

    @FXML
    private TableColumn<userData, String> delete_col_date;

    @FXML
    private AnchorPane admin_changePassword_form;

    @FXML
    private AnchorPane proceedPass_form;

    @FXML
    private JFXTextField admin_changePass_email;

    @FXML
    private JFXTextField admin_changePass_name;

    @FXML
    private JFXComboBox<?> admin_changePass_role;

    @FXML
    private JFXButton admin_proceedBtn;

    @FXML
    private AnchorPane changePass_form;

    @FXML
    private JFXButton admin_changedBtn;

    @FXML
    private JFXPasswordField admin_newPass;

    @FXML
    private JFXPasswordField admin_confirmPass;

    @FXML
    private JFXButton backBtn;

    @FXML
    private AnchorPane update_medicine_form;
    @FXML
    private JFXTextField med_Id1;

    @FXML
    private JFXTextField med_name1;

    @FXML
    private JFXTextField invoice_no1;

    @FXML
    private JFXTextField generic_name1;

    @FXML
    private JFXTextField manufacturer1;

    @FXML
    private JFXTextArea dosage1;

    @FXML
    private JFXTextField form1;

    @FXML
    private JFXTextField unit1;

    @FXML
    private JFXTextField NDC1;

    @FXML
    private JFXDatePicker expiring_date1;

    @FXML
    private JFXTextArea storage_instruction1;

    @FXML
    private JFXTextField price1;

    @FXML
    private ImageView medicine_imageView1;

    @FXML
    private JFXButton updateMedBtn;

    @FXML
    private TextField searchMedicine;

    @FXML
    private Button searchBtn;

    @FXML
    private JFXTextField price12;

    @FXML
    private JFXButton importBtn1;

    @FXML
    private JFXTextField price121;
    @FXML
    private JFXTextField available_qty;

    @FXML
    private JFXTextField add_qty;

    @FXML
    private AnchorPane delete_medicine_form;
    @FXML
    private JFXTextField med_Id11;

    @FXML
    private JFXTextField med_name11;

    @FXML
    private JFXTextField invoice_no11;

    @FXML
    private JFXTextField generic_name11;

    @FXML
    private JFXTextField manufacturer11;

    @FXML
    private JFXTextArea dosage11;

    @FXML
    private JFXTextField form11;

    @FXML
    private JFXTextField unit11;

    @FXML
    private JFXTextField NDC11;

    @FXML
    private JFXDatePicker expiring_date11;

    @FXML
    private JFXTextArea storage_instruction11;

    @FXML
    private JFXTextField price11;

    @FXML
    private ImageView medicine_imageView11;

    @FXML
    private JFXButton importBtn11;

    @FXML
    private JFXButton deleteMedBtn;

    @FXML
    private TextField searchMedicine1;

    @FXML
    private Button searchBtn1;

    @FXML
    private JFXTextField stock_qty;

    @FXML
    private AnchorPane view_medicine_form;

    @FXML
    private TableView<medicineData> medicine_tableView;

    @FXML
    private TableColumn<medicineData, String> med_col_id;

    @FXML
    private TableColumn<medicineData, String> med_col_name;

    @FXML
    private TableColumn<medicineData, String> med_col_invoice;

    @FXML
    private TableColumn<medicineData, String> med_col_generic;

    @FXML
    private TableColumn<medicineData, String> med_col_manufacturer;

    @FXML
    private TableColumn<medicineData, String> med_col_dosage;

    @FXML
    private TableColumn<medicineData, String> med_col_form;

    @FXML
    private TableColumn<medicineData, String> med_col_unit;

    @FXML
    private TableColumn<medicineData, String> med_col_NDC;

    @FXML
    private TableColumn<medicineData, String> med_col_expiring_date;

    @FXML
    private TableColumn<medicineData, String> med_col_store_instruction;

    @FXML
    private TableColumn<medicineData, String> med_col_price;

    @FXML
    private TableColumn<medicineData, String> med_col_stock_qty;

    @FXML
    private TextField search_medicine;

    @FXML
    private AnchorPane add_medicine_form;
    @FXML
    private JFXTextField med_Id;

    @FXML
    private JFXTextField med_name;

    @FXML
    private JFXTextField invoice_no;

    @FXML
    private JFXTextField generic_name;

    @FXML
    private JFXTextField manufacturer;

    @FXML
    private JFXTextArea dosage;

    @FXML
    private JFXTextField form;

    @FXML
    private JFXTextField unit;

    @FXML
    private JFXTextField NDC;

    @FXML
    private JFXDatePicker expiring_date;

    @FXML
    private JFXTextArea storage_instruction;

    @FXML
    private JFXTextField price;
    @FXML
    private JFXTextField qty;
    @FXML
    private AnchorPane pharmacist_form;

    @FXML
    private JFXTextField phar_id;

    @FXML
    private JFXTextField phar_firstName;

    @FXML
    private JFXTextField phar_surname;

    @FXML
    private JFXTextField phar_licenseNumber;

    @FXML
    private JFXTextField phar_phoneNumber;

    @FXML
    private TableView<pharmacistData> pharmacist_tableView;

    @FXML
    private TableColumn<pharmacistData, String> phar_col_id;

    @FXML
    private TableColumn<pharmacistData, String> phar_col_firstName;

    @FXML
    private TableColumn<pharmacistData, String> phar_col_surname;

    @FXML
    private TableColumn<pharmacistData, String> phar_col_licenseNumber;

    @FXML
    private TableColumn<pharmacistData, String> phar_col_phoneNumber;

    @FXML
    private JFXButton admin_managePharmacist;

    @FXML
    private ImageView medicine_imageView;

    @FXML
    private JFXButton importBtn;

    @FXML
    private JFXButton addMedBtn;

    AlertMessage alert = new AlertMessage();
    private Image image;
    private Alert alert1;
    private double x = 0;
    private double y = 0;
    private Connection con;
    private ResultSet rs;
    private Statement st;
    private PreparedStatement ps;
    public String EmailPattern = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";

    public void addUsers() {
        if (add_name.getText().isEmpty()) {
            alert.errorMessage("Please name field is required");
        } else if (add_email.getText().isEmpty()) {
            alert.errorMessage("Please email field is required");
        } else if (!add_email.getText().matches(EmailPattern)) {
            alert.errorMessage("Invalid email account");
        } else if (add_role.getSelectionModel().isEmpty()) {
            alert.errorMessage("Please role field is required");
        } else if (add_password.getText().isEmpty()) {
            alert.errorMessage("Please password field is required");
        } else {
            String chechEamil = "SELECT email FROM user WHERE email = '" + add_email.getText() + "'";
            String insertUser = "INSERT INTO user(name,email,role,password,date) VALUES(?,?,?,?,?)";
            String inputPassword = add_password.getText();
            String hashedPassword = BCrypt.hashpw(inputPassword, BCrypt.gensalt());
            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            con = Database.getConnection();

            try {
                st = con.createStatement();
                rs = st.executeQuery(chechEamil);
                if (rs.next()) {
                    alert.errorMessage("This email account " + add_email.getText() + " is already exist!");
                } else {
                    ps = con.prepareStatement(insertUser);
                    ps.setString(1, add_name.getText());
                    ps.setString(2, add_email.getText());
                    ps.setString(3, (String) add_role.getSelectionModel().getSelectedItem());
                    ps.setString(4, hashedPassword);
                    ps.setDate(5, sqlDate);
                    ps.executeUpdate();

                    alert.successMessage("User Successfully Added");
                    addUserListShow();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void editUser() {
        if (edit_name.getText().isEmpty()) {
            alert.errorMessage("Please name field is required");
        } else if (edit_email.getText().isEmpty()) {
            alert.errorMessage("Please email field is required");
        } else if (!edit_email.getText().matches(EmailPattern)) {
            alert.errorMessage("Invalid email account");
        } else if (edit_role.getSelectionModel().isEmpty()) {
            alert.errorMessage("Please role field is required");
        } else if (edit_password.getText().isEmpty()) {
            alert.errorMessage("Please password field is required");
        } else {
            String inputPassword = edit_password.getText();
            String hashedPassword = BCrypt.hashpw(inputPassword, BCrypt.gensalt());
            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            String editUser = "UPDATE user SET email = '"
                    + edit_email.getText() + "', role = '"
                    + edit_role.getSelectionModel().getSelectedItem() + "', password = '"
                    + hashedPassword + "', date = '"
                    + sqlDate + "' WHERE name = '" + edit_name.getText() + "'";
            con = Database.getConnection();
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmation Message");
                alert.setContentText("Are you sure you want UPADTE user with email " + edit_email.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {
                    st = con.createStatement();
                    st.executeUpdate(editUser);

                    this.alert.successMessage("User Updated Successfully");
                    editUserListShow();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteUser() {
        if (delete_name.getText().isEmpty()) {
            alert.errorMessage("Please name field is required");
        } else if (delete_email.getText().isEmpty()) {
            alert.errorMessage("Please email field is required");
        } else if (!delete_email.getText().matches(EmailPattern)) {
            alert.errorMessage("Invalid email account");
        } else if (delete_role.getSelectionModel().isEmpty()) {
            alert.errorMessage("Please role field is required");
        } else if (delete_password.getText().isEmpty()) {
            alert.errorMessage("Please password field is required");
        } else {
            String deleteUser = "DELETE FROM user WHERE email = '" + delete_email.getText() + "'";
            con = Database.getConnection();
            try {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmation Message");
                alert.setContentText("Are you sure you want DELETE user with email " + delete_email.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {
                    st = con.createStatement();
                    st.executeUpdate(deleteUser);

                    this.alert.successMessage("User Deleted Successfully");
                    deleteUserListShow();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void proceedBtn() {
        if (admin_changePass_name.getText().isEmpty()) {
            alert.errorMessage("Please name field is required");
        } else if (admin_changePass_email.getText().isEmpty()) {
            alert.errorMessage("Please email field is required");
        } else if (!admin_changePass_email.getText().matches(EmailPattern)) {
            alert.errorMessage("Invalid email account");
        } else if (admin_changePass_role.getSelectionModel().isEmpty()) {
            alert.errorMessage("Please role field is required");
        } else {
            String selectUser = "SELECT name,email,role FROM user WHERE name = ? AND email = ? AND role = ?";
            con = Database.getConnection();
            try {
                ps = con.prepareStatement(selectUser);
                ps.setString(1, admin_changePass_name.getText());
                ps.setString(2, admin_changePass_email.getText());
                ps.setString(3, (String) admin_changePass_role.getSelectionModel().getSelectedItem());

                rs = ps.executeQuery();

                if (rs.next()) {
                    proceedPass_form.setVisible(false);
                    changePass_form.setVisible(true);
                } else {
                    alert.errorMessage("Incorrect Information!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void changePassword() {
        String inputPassword = admin_newPass.getText();
        String hashedPassword = BCrypt.hashpw(inputPassword, BCrypt.gensalt());
        if (admin_newPass.getText().isEmpty() || admin_confirmPass.getText().isEmpty()) {
            alert.errorMessage("Please fill in all the blank fields");
        } else {
            String getDate = "SELECT date FROM user WHERE name = '"
                    + admin_changePass_name.getText() + "'";
            con = Database.getConnection();
            if (admin_newPass.getText().equals(admin_confirmPass.getText())) {
                try {
                    ps = con.prepareStatement(getDate);
                    rs = ps.executeQuery();

                    String date = "";
                    if (rs.next()) {
                        date = rs.getString("date");
                    }

                    String updatePass = "UPDATE user SET password = '"
                            + hashedPassword + "', date = '"
                            + date + "' WHERE name = '" + admin_changePass_name.getText() + "'";

                    ps = con.prepareStatement(updatePass);
                    ps.executeUpdate();

                    alert.successMessage("Password Successfully Changed!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                alert.errorMessage("Missmach :3!");
            }
        }
    }

    public void medicineImportImageBtn() {
        FileChooser openFile = new FileChooser();
        openFile.getExtensionFilters().add(new FileChooser.ExtensionFilter("Open Image File", "*png", "*jpg"));
        File file = openFile.showOpenDialog(main_form.getScene().getWindow());

        if (file != null) {
            data.path = file.getAbsolutePath();
            image = new Image(file.toURI().toString(), 188, 221, false, true);

            medicine_imageView.setImage(image);
            medicine_imageView1.setImage(image);

        }
    }

    /* private int qty;

    public void setQuantity() {
        spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000, 0);
        med_spinner.setValueFactory(spin);
    }*/
    // ONLY NUMBER ALLOWED
    public void numberOnly(KeyEvent event) {
        if (event.getCharacter().matches("[^\\e\t\r\\d+$]")) {
            event.consume();

            qty.setStyle("-fx-border-color:#e04040");
        } else {
            qty.setStyle("-fx-border-color:#fff");
        }
    }

    public void addMedication() {
        if (med_Id.getText().isEmpty()
                || med_name.getText().isEmpty()
                || invoice_no.getText().isEmpty()
                || generic_name.getText().isEmpty()
                || manufacturer.getText().isEmpty()
                || dosage.getText().isEmpty()
                || form.getText().isEmpty()
                || unit.getText().isEmpty()
                || NDC.getText().isEmpty()
                || price.getText().isEmpty()
                || qty.getText().isEmpty()
                || storage_instruction.getText().isEmpty()
                || data.path == null
                || expiring_date.getValue() == null) {
            alert.errorMessage("Please fill all blank fields!");
        } else {
            String checkMed = "SELECT med_name FROM medication WHERE med_name = '"
                    + med_name.getText() + "'";
            con = Database.getConnection();

            try {
                st = con.createStatement();
                rs = st.executeQuery(checkMed);

                if (rs.next()) {
                    alert.errorMessage(med_name.getText() + " already exist!");
                } else {
                    String insertMed = "INSERT INTO medication(med_id,med_name,invoice,generic_name,manufacturer,dosage,"
                            + "form,unit,NDC,exp_date,stg_instruction,price,stock_qty,image) "
                            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                    ps = con.prepareStatement(insertMed);
                    ps.setString(1, med_Id.getText());
                    ps.setString(2, med_name.getText());
                    ps.setString(3, invoice_no.getText());
                    ps.setString(4, generic_name.getText());
                    ps.setString(5, manufacturer.getText());
                    ps.setString(6, dosage.getText());
                    ps.setString(7, form.getText());
                    ps.setString(8, unit.getText());
                    ps.setString(9, NDC.getText());
                    ps.setString(10, expiring_date.getValue().toString());
                    ps.setString(11, storage_instruction.getText());
                    ps.setString(12, price.getText());
                    ps.setString(13, qty.getText());
                    String path = data.path;
                    path = path.replace("\\", "\\\\");

                    ps.setString(14, path);
                    ps.executeUpdate();
                    alert.successMessage("Successfully added!");
                    add_medicine_form.setVisible(false);
                    view_medicine_form.setVisible(true);
                    medicineListShowData();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void selectMedication() {
        medicineData mData = medicine_tableView.getSelectionModel().getSelectedItem();
        int num = medicine_tableView.getSelectionModel().getSelectedIndex();
        if ((num - 1) < -1) {
            return;
        }
        view_medicine_form.setVisible(false);
        add_medicine_form.setVisible(true);
        med_Id.setText(mData.getId());
        med_name.setText(mData.getName());
        invoice_no.setText(mData.getInvoice());
        generic_name.setText(mData.getGeneric());
        manufacturer.setText(mData.getManufacturer());
        dosage.setText(mData.getDosage());
        form.setText(mData.getForm());
        unit.setText(mData.getUnit());
        NDC.setText(mData.getNdc());
        expiring_date.setValue(mData.getDate().toLocalDate());
        storage_instruction.setText(mData.getInstructions());
        price.setText(String.valueOf(mData.getPrice()));
        qty.setText(String.valueOf(mData.getQty()));
        String path = "File:" + mData.getImage();
        image = new Image(path, 188, 221, false, true);
        medicine_imageView.setImage(image);

    }

    public void search() {
        int medicineExist = 0;
        if (searchMedicine.getText().isEmpty()) {
            alert.errorMessage("Search field is required!");

        } else {
            String sql = "SELECT * FROM medication WHERE med_id = '" + searchMedicine.getText() + "'";
            con = Database.getConnection();

            try {
                st = con.createStatement();
                rs = st.executeQuery(sql);

                while (rs.next()) {
                    medicineExist = 1;
                    searchMedicine.setEditable(false);
                    med_Id1.setText(rs.getString("med_id"));
                    med_name1.setText(rs.getString("med_name"));
                    invoice_no1.setText(rs.getString("invoice"));
                    generic_name1.setText(rs.getString("generic_name"));
                    manufacturer1.setText(rs.getString("manufacturer"));
                    dosage1.setText(rs.getString("dosage"));
                    form1.setText(rs.getString("form"));
                    unit1.setText(rs.getString("unit"));
                    NDC1.setText(rs.getString("NDC"));
                    expiring_date1.setValue(rs.getDate("exp_date").toLocalDate());
                    storage_instruction1.setText(rs.getString("stg_instruction"));
                    price1.setText(String.valueOf(rs.getFloat("price")));
                    available_qty.setText(String.valueOf(rs.getInt("stock_qty")));

                    data.path = rs.getString("image");

                    String path = "File:" + rs.getString("image");
                    image = new Image(path, 188, 221, false, true);
                    medicine_imageView1.setImage(image);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (medicineExist == 0) {
            alert.errorMessage("Medicine ID does not exist!");
        }
    }

    public void searchToDelete() {
        int medicineExist = 0;
        if (searchMedicine1.getText().isEmpty()) {
            alert.errorMessage("Search field is required!");

        } else {
            String sql = "SELECT * FROM medication WHERE med_id = '" + searchMedicine1.getText() + "'";
            con = Database.getConnection();

            try {
                st = con.createStatement();
                rs = st.executeQuery(sql);

                while (rs.next()) {
                    medicineExist = 1;
                    searchMedicine1.setEditable(false);
                    med_Id11.setText(rs.getString("med_id"));
                    med_Id11.setEditable(false);
                    med_name11.setText(rs.getString("med_name"));
                    invoice_no11.setText(rs.getString("invoice"));
                    generic_name11.setText(rs.getString("generic_name"));
                    manufacturer11.setText(rs.getString("manufacturer"));
                    dosage11.setText(rs.getString("dosage"));
                    form11.setText(rs.getString("form"));
                    unit11.setText(rs.getString("unit"));
                    NDC11.setText(rs.getString("NDC"));
                    expiring_date11.setValue(rs.getDate("exp_date").toLocalDate());
                    storage_instruction11.setText(rs.getString("stg_instruction"));
                    price11.setText(String.valueOf(rs.getFloat("price")));
                    stock_qty.setText(String.valueOf(rs.getInt("stock_qty")));

                    data.path = rs.getString("image");

                    String path = "File:" + rs.getString("image");
                    image = new Image(path, 188, 221, false, true);
                    medicine_imageView11.setImage(image);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (medicineExist == 0) {
            alert.errorMessage("Medicine ID does not exist!");
        }
    }

    public void updateMedication() {
        if (searchMedicine.getText().isEmpty()) {
            alert.errorMessage("Search Medicine ID is required");
        } else if (med_Id1.getText().isEmpty()
                || med_name1.getText().isEmpty()
                || invoice_no1.getText().isEmpty()
                || generic_name1.getText().isEmpty()
                || manufacturer1.getText().isEmpty()
                || dosage1.getText().isEmpty()
                || form1.getText().isEmpty()
                || unit1.getText().isEmpty()
                || NDC1.getText().isEmpty()
                || price1.getText().isEmpty()
                || available_qty.getText().isEmpty()
                || storage_instruction1.getText().isEmpty()
                || data.path == null
                || expiring_date1.getValue() == null) {
            alert.errorMessage("Please fill all blank fields!");
        } else {

            int totalQuantity = 0;
            if (add_qty.getText().equals("")) {
                totalQuantity = Integer.parseInt(available_qty.getText());
            } else {
                totalQuantity = Integer.parseInt(available_qty.getText()) + Integer.parseInt(add_qty.getText());
            }

            String path = data.path;
            path = path.replace("\\", "\\\\");

            String updateMed = "UPDATE medication SET med_name = '"
                    + med_name1.getText() + "',invoice = '"
                    + invoice_no1.getText() + "',generic_name = '"
                    + generic_name1.getText() + "',manufacturer = '"
                    + manufacturer1.getText() + "',dosage = '"
                    + dosage1.getText() + "',form = '"
                    + form1.getText() + "',unit = '"
                    + unit1.getText() + "',NDC = '"
                    + NDC1.getText() + "',exp_date = '"
                    + expiring_date1.getValue() + "',stg_instruction = '"
                    + storage_instruction1.getText() + "',price= '"
                    + price1.getText() + "',stock_qty = '"
                    + totalQuantity + "',image = '"
                    + path + "' WHERE med_id = '" + searchMedicine.getText() + "'";
            String updateInvent = "UPDATE inventory SET qty_in_stock = " + totalQuantity + " WHERE med_id ='"
                    + searchMedicine.getText() + "'";
            con = Database.getConnection();
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmation Message");
                alert.setContentText("Are you sure you want UPDATE medicine with ID " + searchMedicine.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {
                    st = con.createStatement();
                    st.executeUpdate(updateMed);
                    st.executeUpdate(updateInvent);
                    med_Id1.clear();
                    med_name1.clear();
                    invoice_no1.clear();
                    manufacturer1.clear();
                    generic_name1.clear();
                    dosage1.clear();
                    form1.clear();
                    unit1.clear();
                    NDC1.clear();
                    expiring_date1.setValue(null);
                    price1.clear();
                    data.path = "";
                    medicine_imageView1.setImage(null);
                    available_qty.clear();
                    add_qty.clear();
                    searchMedicine.clear();
                    searchMedicine.setEditable(true);
                    storage_instruction1.clear();
                    searchMedicine.getText();

                    this.alert.successMessage("Medication Updated Successfully");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteMedication() {
        if (searchMedicine1.getText().isEmpty()) {
            alert.errorMessage("Search Medicine ID is required");
        } else if (med_Id11.getText().isEmpty()
                || med_name11.getText().isEmpty()
                || invoice_no11.getText().isEmpty()
                || generic_name11.getText().isEmpty()
                || manufacturer11.getText().isEmpty()
                || dosage11.getText().isEmpty()
                || form11.getText().isEmpty()
                || unit11.getText().isEmpty()
                || NDC11.getText().isEmpty()
                || price11.getText().isEmpty()
                || stock_qty.getText().isEmpty()
                || storage_instruction11.getText().isEmpty()
                || data.path == null
                || expiring_date11.getValue() == null) {
            alert.errorMessage("Please fill all blank fields!");
        } else {
            String deleteMed = "DELETE FROM medication WHERE med_id = '" + searchMedicine1.getText() + "'";
            con = Database.getConnection();
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmation Message");
                alert.setContentText("Are you sure you want DELETE medicine with ID " + searchMedicine1.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    st = con.createStatement();
                    st.executeUpdate(deleteMed);

                    med_Id11.clear();
                    med_name11.clear();
                    invoice_no11.clear();
                    manufacturer11.clear();
                    generic_name11.clear();
                    dosage11.clear();
                    form11.clear();
                    unit11.clear();
                    NDC11.clear();
                    expiring_date11.setValue(null);
                    price11.clear();
                    data.path = "";
                    medicine_imageView11.setImage(null);
                    stock_qty.clear();
                    searchMedicine1.clear();
                    searchMedicine1.setEditable(true);
                    storage_instruction11.clear();
                    searchMedicine1.getText();

                    this.alert.successMessage("Medication Deleted Successfully");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void resetFields() {
        int choice = JOptionPane.showConfirmDialog(null, "Your are about to reset all the fields"
                + "\nDo you want to reset?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null);
        if (choice == JOptionPane.YES_NO_OPTION) {

            med_name1.clear();
            invoice_no1.clear();
            manufacturer1.clear();
            generic_name1.clear();
            dosage1.clear();
            form1.clear();
            unit1.clear();
            NDC1.clear();
            expiring_date1.setValue(null);
            price1.clear();
            data.path = "";
            medicine_imageView1.setImage(null);
            available_qty.clear();
            add_qty.clear();
            searchMedicine.clear();
            searchMedicine.setEditable(true);
            storage_instruction1.clear();
            searchMedicine.getText();

            med_name11.clear();
            invoice_no11.clear();
            manufacturer11.clear();
            generic_name11.clear();
            dosage11.clear();
            form11.clear();
            unit11.clear();
            NDC11.clear();
            expiring_date11.setValue(null);
            price11.clear();
            data.path = "";
            medicine_imageView11.setImage(null);
            stock_qty.clear();
            add_qty.clear();
            searchMedicine1.clear();
            searchMedicine1.setEditable(true);
            storage_instruction11.clear();
            searchMedicine1.getText();
        }

    }

    public void registerPharmacist() {
        if (phar_id.getText().isEmpty()
                || phar_firstName.getText().isEmpty()
                || phar_surname.getText().isEmpty()
                || phar_licenseNumber.getText().isEmpty()
                || phar_phoneNumber.getText().isEmpty()) {
            alert.errorMessage("Please fill all the blank fields");
        } else {
            String checkPhar = "SELECT phar_id FROM pharmacist WHERE phar_id = '"
                    + phar_id.getText() + "'";
            con = Database.getConnection();
            try {
                st = con.createStatement();
                rs = st.executeQuery(checkPhar);
                if (rs.next()) {
                    alert.errorMessage("Pharmacist ID " + phar_id.getText() + " is already exist!");
                } else {
                    String insertQuery = "INSERT INTO `pharmacist`(`phar_id`, `f_name`, `l_name`, `license_num`, `ph_num`)"
                            + " VALUES (?,?,?,?,?)";
                    ps = con.prepareStatement(insertQuery);
                    ps.setString(1, phar_id.getText());
                    ps.setString(2, phar_firstName.getText());
                    ps.setString(3, phar_surname.getText());
                    ps.setString(4, phar_licenseNumber.getText());
                    ps.setString(5, phar_phoneNumber.getText());
                    ps.executeUpdate();
                    pharmacistShowListData();
                    alert.successMessage("Pharmacist Registered!");

                    phar_id.clear();
                    phar_firstName.clear();
                    phar_surname.clear();
                    phar_licenseNumber.clear();
                    phar_phoneNumber.clear();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void editPharmacist() {
        if (phar_id.getText().isEmpty()
                || phar_firstName.getText().isEmpty()
                || phar_surname.getText().isEmpty()
                || phar_licenseNumber.getText().isEmpty()
                || phar_phoneNumber.getText().isEmpty()) {
            alert.errorMessage("Please fill all the blank fields");
        } else {
            String updateQuery = "UPDATE pharmacist SET f_name = '"
                    + phar_firstName.getText() + "', l_name = '"
                    + phar_surname.getText() + "', license_num = '"
                    + phar_licenseNumber.getText() + "', ph_num = '"
                    + phar_phoneNumber.getText() + "' WHERE phar_id = '"
                    + phar_id.getText() + "'";
            con = Database.getConnection();

            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmation Message");
                alert.setContentText("Are you sure you want UPADTE Pharmacist with ID " + phar_id.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {
                    st = con.createStatement();
                    st.executeUpdate(updateQuery);
                    this.alert.successMessage("Pharmacist " + phar_firstName.getText() + " " + phar_surname.getText() + " is UPDATED Successfully!");
                    pharmacistShowListData();

                    phar_id.clear();
                    phar_firstName.clear();
                    phar_surname.clear();
                    phar_licenseNumber.clear();
                    phar_phoneNumber.clear();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deletePharmacist() {
        if (phar_id.getText().isEmpty()
                || phar_firstName.getText().isEmpty()
                || phar_surname.getText().isEmpty()
                || phar_licenseNumber.getText().isEmpty()
                || phar_phoneNumber.getText().isEmpty()) {
            alert.errorMessage("Please fill all the blank fields");
        } else {
            String deleteQuery = "DELETE FROM pharmacist WHERE phar_id = '"
                    + phar_id.getText() + "'";
            con = Database.getConnection();

            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmation Message");
                alert.setContentText("Are you sure you want DELETE Pharmacist with ID " + phar_id.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {
                    st = con.createStatement();
                    st.executeUpdate(deleteQuery);
                    this.alert.successMessage("Pharmacist " + phar_firstName.getText() + " " + phar_surname.getText() + " is DELETED Successfully!");
                    pharmacistShowListData();

                    phar_id.clear();
                    phar_firstName.clear();
                    phar_surname.clear();
                    phar_licenseNumber.clear();
                    phar_phoneNumber.clear();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void resetPharmacist() {
        phar_id.clear();
        phar_firstName.clear();
        phar_surname.clear();
        phar_licenseNumber.clear();
        phar_phoneNumber.clear();
    }
    
    public void selectPharmacist(){
        pharmacistData phData = pharmacist_tableView.getSelectionModel().getSelectedItem();
        int num = pharmacist_tableView.getSelectionModel().getSelectedIndex();
        if((num - 1) < -1){
            return;
        }
        phar_id.setText(phData.getPharmacist_id());
        phar_firstName.setText(phData.getFirstName());
        phar_surname.setText(phData.getSurname());
        phar_licenseNumber.setText(phData.getLicenseNumber());
        phar_phoneNumber.setText(phData.getPhoneNumber());
    }

    public void selectUser() {
        userData uData = edit_tableView.getSelectionModel().getSelectedItem();
        int num = edit_tableView.getSelectionModel().getSelectedIndex();
        if ((num - 1) < -1) {
            return;
        }
        edit_name.setText(uData.getName());
        edit_email.setText(uData.getEmail());
        edit_password.setText("Please enter your password here...");
    }

    public void SelectUser() {
        userData uData = delete_tableView.getSelectionModel().getSelectedItem();
        int num = delete_tableView.getSelectionModel().getSelectedIndex();
        if ((num - 1) < -1) {
            return;
        }
        delete_name.setText(uData.getName());
        delete_email.setText(uData.getEmail());
        delete_password.setText(uData.getPassword());
    }

    private String[] userRole = {"Admin", "Pharmacist"};

    public void selectRole() {
        List<String> listR = new ArrayList();
        for (String data : userRole) {
            listR.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(listR);
        add_role.setItems(listData);
        edit_role.setItems(listData);
        delete_role.setItems(listData);
        admin_changePass_role.setItems(listData);

    }

    public ObservableList<pharmacistData> pharmacistListData() {
        String sql = "SELECT * FROM pharmacist";
        ObservableList<pharmacistData> listData = FXCollections.observableArrayList();
        pharmacistData phData;

        con = Database.getConnection();

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                phData = new pharmacistData(rs.getString("phar_id"),
                        rs.getString("f_name"),
                        rs.getString("l_name"),
                        rs.getString("license_num"),
                        rs.getString("ph_num"));
                listData.add(phData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
    private ObservableList<pharmacistData> pharmacistL;

    public void pharmacistShowListData() {
        pharmacistL = pharmacistListData();
        phar_col_id.setCellValueFactory(new PropertyValueFactory<>("pharmacist_id"));
        phar_col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        phar_col_surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        phar_col_licenseNumber.setCellValueFactory(new PropertyValueFactory<>("licenseNumber"));
        phar_col_phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        pharmacist_tableView.setItems(pharmacistL);
    }

    public ObservableList<medicineData> medicicationListData() {
        String sql = "SELECT * FROM medication";
        ObservableList<medicineData> listData = FXCollections.observableArrayList();
        medicineData mData;

        con = Database.getConnection();

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                mData = new medicineData(rs.getString("med_id"),
                        rs.getString("med_name"),
                        rs.getString("invoice"),
                        rs.getString("generic_name"),
                        rs.getString("manufacturer"),
                        rs.getString("dosage"),
                        rs.getString("form"),
                        rs.getString("unit"),
                        rs.getString("NDC"),
                        rs.getDate("exp_date"),
                        rs.getString("stg_instruction"),
                        rs.getFloat("price"),
                        rs.getInt("stock_qty"),
                        rs.getString("image"));
                listData.add(mData);
            }
        } catch (Exception e) {
        }
        return listData;
    }

    private ObservableList<medicineData> medicineList;

    public void medicineListShowData() {
        medicineList = medicicationListData();
        med_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        med_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        med_col_invoice.setCellValueFactory(new PropertyValueFactory<>("invoice"));
        med_col_generic.setCellValueFactory(new PropertyValueFactory<>("generic"));
        med_col_manufacturer.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
        med_col_dosage.setCellValueFactory(new PropertyValueFactory<>("dosage"));
        med_col_form.setCellValueFactory(new PropertyValueFactory<>("form"));
        med_col_unit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        med_col_NDC.setCellValueFactory(new PropertyValueFactory<>("ndc"));
        med_col_expiring_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        med_col_store_instruction.setCellValueFactory(new PropertyValueFactory<>("instructions"));
        med_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        med_col_stock_qty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        medicine_tableView.setItems(medicineList);
    }

    public ObservableList<userData> addUserListData() {
        String sql = "SELECT * FROM user";
        ObservableList<userData> listData = FXCollections.observableArrayList();
        userData uData;
        con = Database.getConnection();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                uData = new userData(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("role"),
                        rs.getString("password"),
                        rs.getDate("date"));
                listData.add(uData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<userData> userRoleList;

    public void addUserListShow() {
        userRoleList = addUserListData();
        add_col_id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        add_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        add_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        add_col_role.setCellValueFactory(new PropertyValueFactory<>("role"));
        add_col_password.setCellValueFactory(new PropertyValueFactory<>("password"));
        add_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        add_tableView.setItems(userRoleList);
    }

    public void editUserListShow() {
        userRoleList = addUserListData();
        edit_col_id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        edit_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        edit_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        edit_col_role.setCellValueFactory(new PropertyValueFactory<>("role"));
        edit_col_password.setCellValueFactory(new PropertyValueFactory<>("password"));
        edit_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        edit_tableView.setItems(userRoleList);
    }

    public void deleteUserListShow() {
        userRoleList = addUserListData();
        delete_col_id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        delete_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        delete_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        delete_col_role.setCellValueFactory(new PropertyValueFactory<>("role"));
        delete_col_password.setCellValueFactory(new PropertyValueFactory<>("password"));
        delete_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        delete_tableView.setItems(userRoleList);
    }

    public void close() {
        System.exit(0);
    }

    public void minimize() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }

    public void logout() {

        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");

            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {
                //To hide the dashboard form
                admin_logout.getScene().getWindow().hide();
                //To link login form
                Parent root = FXMLLoader.load(getClass().getResource("LoginForm.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void displayUserEmail() {
        admin_email.setText(data.useremail);
    }

    public void clearUserFields() {
        add_name.setText("");
        add_email.setText("");
        add_password.setText("");
        add_role.getSelectionModel().clearSelection();

        edit_name.setText("");
        edit_email.setText("");
        edit_password.setText("");
        edit_role.getSelectionModel().clearSelection();

        delete_name.setText("");
        delete_email.setText("");
        delete_password.setText("");
        delete_role.getSelectionModel().clearSelection();
    }

    public void switchForms(ActionEvent event) {
        if (event.getSource() == admin_dashboard) {
            admin_dashboard_form.setVisible(true);
            admin_addUser_form.setVisible(false);
            admin_editUser_form.setVisible(false);
            admin_deleteUser_form.setVisible(false);
            admin_changePassword_form.setVisible(false);
            add_medicine_form.setVisible(false);
            update_medicine_form.setVisible(false);
            delete_medicine_form.setVisible(false);
            view_medicine_form.setVisible(false);
            pharmacist_form.setVisible(false);
        } else if (event.getSource() == admin_addUser) {
            admin_dashboard_form.setVisible(false);
            admin_addUser_form.setVisible(true);
            admin_editUser_form.setVisible(false);
            admin_deleteUser_form.setVisible(false);
            admin_changePassword_form.setVisible(false);
            add_medicine_form.setVisible(false);
            update_medicine_form.setVisible(false);
            delete_medicine_form.setVisible(false);
            view_medicine_form.setVisible(false);
            pharmacist_form.setVisible(false);

            addUserListShow();
        } else if (event.getSource() == admin_editUser) {
            admin_dashboard_form.setVisible(false);
            admin_addUser_form.setVisible(false);
            admin_editUser_form.setVisible(true);
            admin_deleteUser_form.setVisible(false);
            admin_changePassword_form.setVisible(false);
            add_medicine_form.setVisible(false);
            update_medicine_form.setVisible(false);
            delete_medicine_form.setVisible(false);
            view_medicine_form.setVisible(false);
            pharmacist_form.setVisible(false);

            editUserListShow();

        } else if (event.getSource() == admin_deleteUser) {
            admin_dashboard_form.setVisible(false);
            admin_addUser_form.setVisible(false);
            admin_editUser_form.setVisible(false);
            admin_deleteUser_form.setVisible(true);
            admin_changePassword_form.setVisible(false);
            add_medicine_form.setVisible(false);
            update_medicine_form.setVisible(false);
            delete_medicine_form.setVisible(false);
            view_medicine_form.setVisible(false);
            pharmacist_form.setVisible(false);

            deleteUserListShow();
        } else if (event.getSource() == admin_changePassword) {
            admin_dashboard_form.setVisible(false);
            admin_addUser_form.setVisible(false);
            admin_editUser_form.setVisible(false);
            admin_deleteUser_form.setVisible(false);
            admin_changePassword_form.setVisible(true);
            add_medicine_form.setVisible(false);
            update_medicine_form.setVisible(false);
            delete_medicine_form.setVisible(false);
            view_medicine_form.setVisible(false);
            pharmacist_form.setVisible(false);
        } else if (event.getSource() == admin_addProdMed) {
            admin_dashboard_form.setVisible(false);
            admin_addUser_form.setVisible(false);
            admin_editUser_form.setVisible(false);
            admin_deleteUser_form.setVisible(false);
            admin_changePassword_form.setVisible(false);
            add_medicine_form.setVisible(true);
            update_medicine_form.setVisible(false);
            delete_medicine_form.setVisible(false);
            view_medicine_form.setVisible(false);
            pharmacist_form.setVisible(false);
        } else if (event.getSource() == admin_editProdMed) {
            admin_dashboard_form.setVisible(false);
            admin_addUser_form.setVisible(false);
            admin_editUser_form.setVisible(false);
            admin_deleteUser_form.setVisible(false);
            admin_changePassword_form.setVisible(false);
            add_medicine_form.setVisible(false);
            update_medicine_form.setVisible(true);
            delete_medicine_form.setVisible(false);
            view_medicine_form.setVisible(false);
            pharmacist_form.setVisible(false);
        } else if (event.getSource() == admin_deleteProdMed) {
            admin_dashboard_form.setVisible(false);
            admin_addUser_form.setVisible(false);
            admin_editUser_form.setVisible(false);
            admin_deleteUser_form.setVisible(false);
            admin_changePassword_form.setVisible(false);
            add_medicine_form.setVisible(false);
            update_medicine_form.setVisible(false);
            delete_medicine_form.setVisible(true);
            view_medicine_form.setVisible(false);
            pharmacist_form.setVisible(false);
        } else if (event.getSource() == admin_viewMed) {
            admin_dashboard_form.setVisible(false);
            admin_addUser_form.setVisible(false);
            admin_editUser_form.setVisible(false);
            admin_deleteUser_form.setVisible(false);
            admin_changePassword_form.setVisible(false);
            add_medicine_form.setVisible(false);
            update_medicine_form.setVisible(false);
            delete_medicine_form.setVisible(false);
            view_medicine_form.setVisible(true);
            pharmacist_form.setVisible(false);
            medicineListShowData();
        } else if (event.getSource() == admin_managePharmacist) {
            admin_dashboard_form.setVisible(false);
            admin_addUser_form.setVisible(false);
            admin_editUser_form.setVisible(false);
            admin_deleteUser_form.setVisible(false);
            admin_changePassword_form.setVisible(false);
            add_medicine_form.setVisible(false);
            update_medicine_form.setVisible(false);
            delete_medicine_form.setVisible(false);
            view_medicine_form.setVisible(false);
            pharmacist_form.setVisible(true);

            pharmacistShowListData();

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayUserEmail();
        selectRole();

        addUserListShow();
        editUserListShow();
        deleteUserListShow();

        medicineListShowData();
        pharmacistShowListData();
        displayCurrentTime(clockLabel);
    }

    private void displayCurrentTime(Label label) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String currentTime = LocalDateTime.now().format(formatter);
            label.setText(currentTime);
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

}
