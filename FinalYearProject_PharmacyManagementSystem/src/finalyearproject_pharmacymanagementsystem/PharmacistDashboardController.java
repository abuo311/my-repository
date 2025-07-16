/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalyearproject_pharmacymanagementsystem;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 *
 * @author ABUO BERNARD
 */
public class PharmacistDashboardController implements Initializable {

    @FXML
    private AnchorPane main_form;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private AnchorPane inventory_form;

    @FXML
    private JFXTextField stock;

    @FXML
    private JFXTextField restock;

    @FXML
    private JFXComboBox<?> med_id;

    @FXML
    private JFXTextField reorder_level;

    @FXML
    private JFXDatePicker date_for_updates;

    @FXML
    private JFXTextField lot_number;

    @FXML
    private JFXButton invent_save_btn;

    @FXML
    private JFXButton invent_edit_btn;

    @FXML
    private JFXButton invent_reset_btn;

    @FXML
    private JFXButton invent_delete_btn;

    @FXML
    private JFXComboBox<?> med_name;

    @FXML
    private TableView<inventoryData> inventory_tableView;

    @FXML
    private TableColumn<inventoryData, String> invent_col_id;

    @FXML
    private TableColumn<inventoryData, String> invent_col_med_id;

    @FXML
    private TableColumn<inventoryData, String> invent_col_med_name;

    @FXML
    private TableColumn<inventoryData, String> invent_col_stock;

    @FXML
    private TableColumn<inventoryData, String> invent_col_reoreder_level;

    @FXML
    private TableColumn<inventoryData, String> invent_col_date_for_update;

    @FXML
    private TableColumn<inventoryData, String> invent_col_lot_number;

    @FXML
    private AnchorPane patient_form;

    @FXML
    private JFXTextField pat_id;

    @FXML
    private JFXTextField pat_first_name;

    @FXML
    private JFXTextField pat_last_name;

    @FXML
    private JFXDatePicker pat_date_of_birth;

    @FXML
    private JFXComboBox<?> pat_gender;

    @FXML
    private JFXTextField pat_phone_number;

    @FXML
    private JFXTextField pat_insurance_provider;

    @FXML
    private JFXTextField pat_insurance_policy_number;

    @FXML
    private JFXTextField pat_address;

    @FXML
    private JFXTextArea pat_allergy;

    @FXML
    private JFXTextArea pat_medical_history;

    @FXML
    private JFXTextField pat_emergency_contact_name;

    @FXML
    private JFXTextField pat_emergency_contact_number;

    @FXML
    private JFXButton pat_save_btn;

    @FXML
    private JFXButton pat_edit_btn;

    @FXML
    private JFXButton pat_delete_btn;

    @FXML
    private JFXButton pat_reset_btn;

    @FXML
    private TableView<patientData> patient_tableView;

    @FXML
    private TableColumn<patientData, String> pat_col_id;

    @FXML
    private TableColumn<patientData, String> pat_col_first_name;

    @FXML
    private TableColumn<patientData, String> pat_col_last_name;

    @FXML
    private TableColumn<patientData, String> pat_col_date_of_birth;

    @FXML
    private TableColumn<patientData, String> pat_col_gender;

    @FXML
    private TableColumn<patientData, String> pat_col_address;

    @FXML
    private TableColumn<patientData, String> pat_col_phone_number;

    @FXML
    private TableColumn<patientData, String> pat_col_insurance_provider;

    @FXML
    private TableColumn<patientData, String> pat_col_insurance_policy_number;

    @FXML
    private TableColumn<patientData, String> pat_col_allergy;

    @FXML
    private TableColumn<patientData, String> pat_col_medical_history;

    @FXML
    private TableColumn<patientData, String> pat_col_emergency_contact_name;

    @FXML
    private TableColumn<patientData, String> pat_col_emergency_contact_number;

    @FXML
    private AnchorPane doctor_form;

    @FXML
    private JFXTextField doc_first_name;

    @FXML
    private JFXTextField doc_surname;

    @FXML
    private JFXTextField doc_phone_number;

    @FXML
    private JFXTextField doc_license_number;

    @FXML
    private JFXTextField doc_specialisation;

    @FXML
    private JFXTextArea doc_clinic_address;

    @FXML
    private JFXButton doc_save_btn;

    @FXML
    private JFXButton doc_edit_btn;

    @FXML
    private JFXButton doc_delete_btn;

    @FXML
    private JFXButton doc_reset_btn;

    @FXML
    private JFXTextField doc_id;

    @FXML
    private TableView<doctorData> doctor_tableView;

    @FXML
    private TableColumn<doctorData, String> doc_col_id;

    @FXML
    private TableColumn<doctorData, String> doc_col_first_name;

    @FXML
    private TableColumn<doctorData, String> doc_col_surname;

    @FXML
    private TableColumn<doctorData, String> doc_col_specialisation;

    @FXML
    private TableColumn<doctorData, String> doc_col_phone_number;

    @FXML
    private TableColumn<doctorData, String> doc_col_license_number;

    @FXML
    private TableColumn<doctorData, String> doc_col_clinic_address;

    @FXML
    private AnchorPane prescription_form;

    @FXML
    private JFXTextField pres_qty;

    @FXML
    private JFXComboBox<?> pres_pat_id;

    @FXML
    private JFXComboBox<?> pres_med_id;

    @FXML
    private JFXComboBox<?> pres_doc_id;

    @FXML
    private JFXDatePicker pres_date;

    @FXML
    private JFXTextArea pres_instructions;

    @FXML
    private JFXTextArea pres_pharmacist;

    @FXML
    private JFXTextField pres_diagnosis;

    @FXML
    private JFXTextField pres_id;

    @FXML
    private TableView<prescriptionData> prescription_tableView;

    @FXML
    private TableColumn<prescriptionData, String> pres_col_pres_id;

    @FXML
    private TableColumn<prescriptionData, String> pres_col_pat_id;

    @FXML
    private TableColumn<prescriptionData, String> pres_col_med_id;

    @FXML
    private TableColumn<prescriptionData, String> pres_col_doc_id;

    @FXML
    private TableColumn<prescriptionData, String> pres_col_pres_date;

    @FXML
    private TableColumn<prescriptionData, String> pres_col_qty;

    @FXML
    private TableColumn<prescriptionData, String> pres_col_instructions;

    @FXML
    private TableColumn<prescriptionData, String> pres_col_diagnosis;

    @FXML
    private TableColumn<prescriptionData, String> pres_col_pharmacist_note;

    @FXML
    private TextField pres_search;

    @FXML
    private AnchorPane sale_form;

    @FXML
    private TableView<?> sale_tableView;

    @FXML
    private TableColumn<?, ?> sale_pat_col_id;

    @FXML
    private TableColumn<?, ?> sale_presc_col_id;

    @FXML
    private TableColumn<?, ?> sale_phar_col_id;

    @FXML
    private TableColumn<?, ?> sale_col_payment_method;

    @FXML
    private TableColumn<?, ?> sale_col_total_amount;

    @FXML
    private TableColumn<?, ?> sale_col_qty;

    @FXML
    private JFXComboBox<?> sale_pat_id;

    @FXML
    private JFXComboBox<?> sale_presc_id;

    @FXML
    private JFXComboBox<?> sale_phar_id;

    @FXML
    private JFXComboBox<?> sale_payment_method;

    @FXML
    private Label total_amount;

    @FXML
    private TextField amount;

    @FXML
    private Label balance;

    @FXML
    private AnchorPane changePassword_form;

    @FXML
    private JFXButton dashboard_btn;

    @FXML
    private JFXButton patient_btn;

    @FXML
    private JFXButton doctor_btn;

    @FXML
    private JFXButton inventory_btn;

    @FXML
    private JFXButton prescription_btn;

    @FXML
    private JFXButton sale_btn;

    @FXML
    private JFXButton pharmacy_logout;

    @FXML
    private Label useremail;

    @FXML
    private Label clockLabel;

    @FXML
    private JFXButton changePassword_btn;

    @FXML
    private JFXButton backup_btn;

    AlertMessage alert = new AlertMessage();

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Statement st;

    private double x = 0;
    private double y = 0;

    public void close() {
        System.exit(0);
    }

    public void minimize() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }

    public void displayUserEmail() {
        useremail.setText(data.useremail);
    }

    public void inventoryMedicationId() {
        inventoryMedicationName();
        int stock_no = 0;
        String sql = "SELECT med_id FROM medication";

        con = Database.getConnection();

        try {
            ObservableList listData = FXCollections.observableArrayList();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                listData.add(rs.getString("med_id"));
            }
            med_id.setItems(listData);

            String query = "SELECT stock_qty FROM medication WHERE med_id = '"
                    + med_id.getSelectionModel().getSelectedItem() + "'";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                stock_no = rs.getInt("stock_qty");
            }
            stock.setText(String.valueOf(stock_no));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inventoryMedicationName() {
        String sql = "SELECT med_name FROM medication";

        con = Database.getConnection();

        try {
            ObservableList listData = FXCollections.observableArrayList();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                listData.add(rs.getString("med_name"));
            }

            med_name.setItems(listData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void prescriptionMedicationId() {
        String sql = "SELECT med_id FROM medication";

        con = Database.getConnection();

        try {
            ObservableList listData = FXCollections.observableArrayList();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                listData.add(rs.getString("med_id"));
            }

            pres_med_id.setItems(listData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void prescriptionDoctorId() {
        String sql = "SELECT doc_id FROM doctor";

        con = Database.getConnection();

        try {
            ObservableList listData = FXCollections.observableArrayList();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                listData.add(rs.getString("doc_id"));
            }

            pres_doc_id.setItems(listData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void prescriptionPatientId() {
        String sql = "SELECT pat_id FROM patient";

        con = Database.getConnection();

        try {
            ObservableList listData = FXCollections.observableArrayList();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                listData.add(rs.getString("pat_id"));
            }

            pres_pat_id.setItems(listData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createBackup() {
        DatabaseBackup.backupDatabase("finalyearprojectdb", "root", "abuo", "C:\\Users\\ABUO BERNARD\\Desktop\\MySQL Backup\\backup.sql");
    }

    public void inventorySave() {
        if (med_id.getSelectionModel().getSelectedItem() == null
                || med_name.getSelectionModel().getSelectedItem() == null
                || reorder_level.getText().isEmpty()
                || stock.getText().isEmpty()
                || date_for_updates.getValue() == null) {
            alert.errorMessage("Please fill all the blank fields");
        } else {
            String sql = "SELECT med_id FROM inventory WHERE med_id = '"
                    + med_id.getSelectionModel().getSelectedItem() + "'";

            con = Database.getConnection();

            try {
                st = con.createStatement();
                rs = st.executeQuery(sql);
                if (rs.next()) {
                    alert.errorMessage(med_id.getSelectionModel().getSelectedItem() + " already exist!");
                } else {
                    String insertQuery = "INSERT INTO inventory(med_id,med_name,qty_in_stock,reorder_level,last_updated,lot_num)"
                            + "VALUES(?,?,?,?,?,?)";

                    int totalStock = 0;
                    if (restock.getText().equals("")) {
                        totalStock = Integer.parseInt(stock.getText());
                    }

                    ps = con.prepareStatement(insertQuery);
                    ps.setString(1, (String) med_id.getSelectionModel().getSelectedItem());
                    ps.setString(2, (String) med_name.getSelectionModel().getSelectedItem());
                    ps.setInt(3, totalStock);
                    ps.setInt(4, Integer.parseInt(reorder_level.getText()));
                    ps.setDate(5, Date.valueOf(LocalDate.now()));
                    ps.setString(6, lot_number.getText());
                    ps.executeUpdate();

                    alert.successMessage("Inventory is Successfully Added!");
                    inventoryListShowData();
                    med_id.getSelectionModel().clearSelection();
                    med_name.getSelectionModel().clearSelection();
                    stock.clear();
                    reorder_level.clear();
                    date_for_updates.setValue(null);
                    lot_number.clear();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void inventoryRestock() {
        if (med_id.getSelectionModel().getSelectedItem() == null
                || med_name.getSelectionModel().getSelectedItem() == null
                || reorder_level.getText().isEmpty()
                || stock.getText().isEmpty()
                || restock.getText().isEmpty()
                || date_for_updates.getValue() == null) {
            alert.errorMessage("Please fill all the blank fields");
        } else {
            int totalStock = 0;
            if (restock.getText().equals("")) {
                totalStock = Integer.parseInt(stock.getText());
            } else {
                totalStock = (Integer.parseInt(stock.getText()) + Integer.parseInt(restock.getText()));
            }
            String sql = "UPDATE inventory SET qty_in_stock = " + totalStock + ","
                    + "reorder_level = " + Integer.parseInt(reorder_level.getText()) + ","
                    + "last_updated = '" + Date.valueOf(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE)) + "',"
                    + "lot_num = '" + lot_number.getText() + "' WHERE med_id = '" + med_id.getSelectionModel().getSelectedItem() + "'";
            String medUpdate = "UPDATE medication SET stock_qty = " + totalStock + " WHERE med_id = '" + med_id.getSelectionModel().getSelectedItem() + "'";

            con = Database.getConnection();
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmation Message");
                alert.setContentText("Are you sure you want UPADTE Inventory with Medicine ID " + med_id.getSelectionModel().getSelectedItem() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {
                    st = con.createStatement();
                    st.executeUpdate(sql);
                    st.executeUpdate(medUpdate);

                    this.alert.successMessage("Inventory is Updated Successfully");
                    inventoryListShowData();

                    med_id.getSelectionModel().clearSelection();
                    med_name.getSelectionModel().clearSelection();
                    stock.clear();
                    restock.clear();
                    reorder_level.clear();
                    date_for_updates.setValue(null);
                    lot_number.clear();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void inventoryDelete() {
        if (med_id.getSelectionModel().getSelectedItem() == null
                || med_name.getSelectionModel().getSelectedItem() == null
                || reorder_level.getText().isEmpty()
                || stock.getText().isEmpty()
                || date_for_updates.getValue() == null) {
            alert.errorMessage("Please fill all the blank fields");
        } else {
            String sql = "DELETE FROM inventory WHERE med_id = '" + med_id.getSelectionModel().getSelectedItem() + "'";
            con = Database.getConnection();

            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmation Message");
                alert.setContentText("Are you sure you want DELETE Inventory with Medicine ID " + med_id.getSelectionModel().getSelectedItem() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {
                    st = con.createStatement();
                    st.executeUpdate(sql);

                    this.alert.successMessage("Inventory is Updated Successfully");
                    inventoryListShowData();

                    med_id.getSelectionModel().clearSelection();
                    med_name.getSelectionModel().clearSelection();
                    stock.clear();
                    restock.clear();
                    reorder_level.clear();
                    date_for_updates.setValue(null);
                    lot_number.clear();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void inventoryReset() {
        int choice = JOptionPane.showConfirmDialog(null, "Your are about to reset all the fields"
                + "\nDo you want to reset?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null);
        if (choice == JOptionPane.YES_NO_OPTION) {

            med_id.getSelectionModel().clearSelection();
            med_name.getSelectionModel().clearSelection();
            stock.clear();
            restock.clear();
            reorder_level.clear();
            date_for_updates.setValue(null);
            lot_number.clear();
        }
    }

    public void selectInventory() {
        inventoryData inData = inventory_tableView.getSelectionModel().getSelectedItem();
        int num = inventory_tableView.getSelectionModel().getSelectedIndex();
        if ((num - 1) < - 1) {
            return;
        }
        stock.setText(String.valueOf(inData.getQuantity()));
        reorder_level.setText(String.valueOf(inData.getReorder()));
        date_for_updates.setValue(inData.getUpdates().toLocalDate());
        lot_number.setText(inData.getLot_num());
    }

    public void updateStock(String medicine_id, int quantity) {
        medicine_id = (String) med_id.getSelectionModel().getSelectedItem();

        String sql = "UPDATE inventory SET qty_in_stock = qty_in_stock - ?,last_updated = ? WHERE med_id = ?";
        con = Database.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, quantity);
            ps.setDate(2, Date.valueOf(LocalDate.now()));
            ps.setString(3, medicine_id);
            ps.executeUpdate();
            checkReorderLevel();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void checkReorderLevel() {
        String sql = "SELECT qty_in_stock, reorder_level FROM inventory WHERE med_id = '"
                + med_id.getSelectionModel().getSelectedItem() + "'";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, (String) med_id.getSelectionModel().getSelectedItem());
            rs = ps.executeQuery();
            if (rs.next()) {
                int stock_no = rs.getInt("qty_in_stock");
                int reorderLevel = rs.getInt("reorder_level");
                stock.setText(String.valueOf(stock_no));
                reorder_level.setText(String.valueOf(reorderLevel));
                if (stock_no <= reorderLevel) {
                    alert.errorMessage("Reorder Alert: Medicine ID " + (String) med_id.getSelectionModel().getSelectedItem()
                            + " quantity is low (" + stock_no + "). Reorder level is " + reorderLevel);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void selectPatient() {
        patientData pData = patient_tableView.getSelectionModel().getSelectedItem();
        int num = patient_tableView.getSelectionModel().getSelectedIndex();
        if ((num - 1) < - 1) {
            return;
        }
        pat_id.setText(pData.getPatient_id());
        pat_first_name.setText(pData.getFirst_name());
        pat_last_name.setText(pData.getLast_name());
        pat_date_of_birth.setValue(pData.getDate_of_birth().toLocalDate());
        pat_address.setText(pData.getAddress());
        pat_phone_number.setText(pData.getPhone_number());
        pat_insurance_provider.setText(pData.getInsurance_provider());
        pat_insurance_policy_number.setText(pData.getInsurance_policy_number());
        pat_allergy.setText(pData.getAllergy());
        pat_medical_history.setText(pData.getMedical_history());
        pat_emergency_contact_name.setText(pData.getEmergency_contact_name());
        pat_emergency_contact_number.setText(pData.getEmergency_contact_number());
    }

    public void patientSave() {
        if (pat_first_name.getText().isEmpty()
                || pat_id.getText().isEmpty()
                || pat_last_name.getText().isEmpty()
                || pat_gender.getSelectionModel().isEmpty()
                || pat_date_of_birth.getValue() == null
                || pat_address.getText().isEmpty()
                || pat_phone_number.getText().isEmpty()
                || pat_insurance_provider.getText().isEmpty()
                || pat_insurance_policy_number.getText().isEmpty()
                || pat_allergy.getText().isEmpty()
                || pat_medical_history.getText().isEmpty()
                || pat_emergency_contact_name.getText().isEmpty()
                || pat_emergency_contact_number.getText().isEmpty()) {
            alert.errorMessage("Please fill in all the blank fields");
        } else {
            String sql = "SELECT pat_id,f_name,l_name FROM patient WHERE pat_id = '"
                    + pat_id.getText() + "' ";
            con = Database.getConnection();
            try {
                st = con.createStatement();
                rs = st.executeQuery(sql);

                if (rs.next()) {
                    alert.errorMessage("Patient name " + pat_first_name.getText().toUpperCase() + " "
                            + pat_last_name.getText().toUpperCase() + " with Patient ID " + pat_id.getText() + " is already exist!");
                } else {
                    String insertQuery = "INSERT INTO `patient` (`pat_id`, `f_name`, `l_name`, `dob`, `gender`,"
                            + " `address`, `ph_number`, `insurance_provider`, `insur_policy_num`, `alergy`,"
                            + " `medical_history`, `emerg_contact_name`, `emerg_contact_num`)"
                            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
                    ps = con.prepareStatement(insertQuery);
                    ps.setString(1, pat_id.getText());
                    ps.setString(2, pat_first_name.getText());
                    ps.setString(3, pat_last_name.getText());
                    ps.setDate(4, Date.valueOf(pat_date_of_birth.getValue()));
                    ps.setString(5, (String) pat_gender.getSelectionModel().getSelectedItem());
                    ps.setString(6, pat_address.getText());
                    ps.setString(7, pat_phone_number.getText());
                    ps.setString(8, pat_insurance_provider.getText());
                    ps.setString(9, pat_insurance_policy_number.getText());
                    ps.setString(10, pat_allergy.getText());
                    ps.setString(11, pat_medical_history.getText());
                    ps.setString(12, pat_emergency_contact_name.getText());
                    ps.setString(13, pat_emergency_contact_number.getText());
                    ps.executeUpdate();
                    alert.successMessage("Patient with Name " + pat_first_name.getText().toUpperCase() + " "
                            + pat_last_name.getText().toUpperCase() + " is Successfully Saved!");
                    patientShowListData();

                    pat_id.clear();
                    pat_first_name.clear();
                    pat_last_name.clear();
                    pat_gender.getSelectionModel().clearSelection();
                    pat_date_of_birth.setValue(null);
                    pat_address.clear();
                    pat_phone_number.clear();
                    pat_insurance_provider.clear();
                    pat_insurance_policy_number.clear();
                    pat_allergy.clear();
                    pat_medical_history.clear();
                    pat_emergency_contact_name.clear();
                    pat_emergency_contact_number.clear();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void patientUpdate() {
        if (pat_first_name.getText().isEmpty()
                || pat_id.getText().isEmpty()
                || pat_last_name.getText().isEmpty()
                || pat_gender.getSelectionModel().isEmpty()
                || pat_date_of_birth.getValue() == null
                || pat_address.getText().isEmpty()
                || pat_phone_number.getText().isEmpty()
                || pat_insurance_provider.getText().isEmpty()
                || pat_insurance_policy_number.getText().isEmpty()
                || pat_allergy.getText().isEmpty()
                || pat_medical_history.getText().isEmpty()
                || pat_emergency_contact_name.getText().isEmpty()
                || pat_emergency_contact_number.getText().isEmpty()) {
            alert.errorMessage("Please fill in all the blank fields");
        } else {
            String sql = "UPDATE patient SET f_name = '" + pat_first_name.getText() + "',"
                    + "l_name = '" + pat_last_name.getText() + "',"
                    + "dob = '" + pat_date_of_birth.getValue() + "',"
                    + "gender = '" + pat_gender.getSelectionModel().getSelectedItem() + "',"
                    + "address = '" + pat_address.getText() + "',"
                    + "ph_number = '" + pat_phone_number.getText() + "',"
                    + "insurance_provider = '" + pat_insurance_provider.getText() + "',"
                    + "insur_policy_num = '" + pat_insurance_policy_number.getText() + "',"
                    + "alergy = '" + pat_allergy.getText() + "',"
                    + "emerg_contact_name = '" + pat_emergency_contact_name.getText() + "',"
                    + "emerg_contact_num = '" + pat_emergency_contact_number.getText() + "' "
                    + "WHERE pat_id = '" + pat_id.getText() + "'";

            con = Database.getConnection();
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmation Message");
                alert.setContentText("Are you sure you want UPADTE " + pat_first_name.getText() + " " + pat_last_name.getText() + " with Patient ID " + pat_id.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {
                    st = con.createStatement();
                    st.executeUpdate(sql);
                    this.alert.successMessage("Patient " + pat_first_name.getText() + " " + pat_last_name.getText() + " is UPDATED Successfully!");
                    patientShowListData();

                    pat_id.clear();
                    pat_first_name.clear();
                    pat_last_name.clear();
                    pat_gender.getSelectionModel().clearSelection();
                    pat_date_of_birth.setValue(null);
                    pat_address.clear();
                    pat_phone_number.clear();
                    pat_insurance_provider.clear();
                    pat_insurance_policy_number.clear();
                    pat_allergy.clear();
                    pat_medical_history.clear();
                    pat_emergency_contact_name.clear();
                    pat_emergency_contact_number.clear();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void patientDelete() {
        if (pat_first_name.getText().isEmpty()
                || pat_id.getText().isEmpty()
                || pat_last_name.getText().isEmpty()
                || pat_gender.getSelectionModel().isEmpty()
                || pat_date_of_birth.getValue() == null
                || pat_address.getText().isEmpty()
                || pat_phone_number.getText().isEmpty()
                || pat_insurance_provider.getText().isEmpty()
                || pat_insurance_policy_number.getText().isEmpty()
                || pat_allergy.getText().isEmpty()
                || pat_medical_history.getText().isEmpty()
                || pat_emergency_contact_name.getText().isEmpty()
                || pat_emergency_contact_number.getText().isEmpty()) {
            alert.errorMessage("Please fill in all the blank fields");
        } else {
            String sql = "DELETE FROM patient WHERE pat_id = '" + pat_id.getText() + "'";
            con = Database.getConnection();
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmation Message");
                alert.setContentText("Are you sure you want DELETE " + pat_first_name.getText() + " " + pat_last_name.getText() + " with Patient ID " + pat_id.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {
                    st = con.createStatement();
                    st.executeUpdate(sql);
                    this.alert.successMessage("Patient " + pat_first_name.getText() + " " + pat_last_name.getText() + " is DELETED Successfully!");
                    patientShowListData();

                    pat_id.clear();
                    pat_first_name.clear();
                    pat_last_name.clear();
                    pat_gender.getSelectionModel().clearSelection();
                    pat_date_of_birth.setValue(null);
                    pat_address.clear();
                    pat_phone_number.clear();
                    pat_insurance_provider.clear();
                    pat_insurance_policy_number.clear();
                    pat_allergy.clear();
                    pat_medical_history.clear();
                    pat_emergency_contact_name.clear();
                    pat_emergency_contact_number.clear();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void patientReset() {
        int choice = JOptionPane.showConfirmDialog(null, "Your are about to reset all the fields"
                + "\nDo you want to reset?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null);
        if (choice == JOptionPane.YES_NO_OPTION) {

            pat_id.clear();
            pat_first_name.clear();
            pat_last_name.clear();
            pat_gender.getSelectionModel().clearSelection();
            pat_date_of_birth.setValue(null);
            pat_address.clear();
            pat_phone_number.clear();
            pat_insurance_provider.clear();
            pat_insurance_policy_number.clear();
            pat_allergy.clear();
            pat_medical_history.clear();
            pat_emergency_contact_name.clear();
            pat_emergency_contact_number.clear();
        }
    }
    private String[] gender = {"Male", "Female"};

    public void selectGender() {
        List<String> listR = new ArrayList();
        for (String data : gender) {
            listR.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(listR);
        pat_gender.setItems(listData);

    }

    public void doctorSave() {
        if (doc_id.getText().isEmpty()
                || doc_first_name.getText().isEmpty()
                || doc_surname.getText().isEmpty()
                || doc_specialisation.getText().isEmpty()
                || doc_clinic_address.getText().isEmpty()
                || doc_license_number.getText().isEmpty()
                || doc_phone_number.getText().isEmpty()) {
            alert.errorMessage("Please fill all the blank fields.");
        } else {
            String sql = "SELECT doc_id, license_num FROM doctor WHERE license_num = '"
                    + doc_license_number.getText() + "' OR doc_id = '" + doc_id.getText() + "'";
            con = Database.getConnection();
            try {
                st = con.createStatement();
                rs = st.executeQuery(sql);

                if (rs.next()) {
                    alert.errorMessage("Doctor " + doc_first_name.getText().toUpperCase() + " "
                            + doc_surname.getText().toUpperCase() + " with LICENSE NUMBER " + doc_license_number.getText() + " OR " + " Doctor ID " + doc_id.getText()
                            + " is already exist!");
                } else {
                    String insertQuery = "INSERT INTO `doctor`(`doc_id`, `f_name`, `l_name`, `specialisation`, `clinic_address`, `ph_num`, `license_num`)"
                            + " VALUES (?,?,?,?,?,?,?)";
                    ps = con.prepareStatement(insertQuery);
                    ps.setString(1, doc_id.getText());
                    ps.setString(2, doc_first_name.getText());
                    ps.setString(3, doc_surname.getText());
                    ps.setString(4, doc_specialisation.getText());
                    ps.setString(5, doc_clinic_address.getText());
                    ps.setString(6, doc_phone_number.getText());
                    ps.setString(7, doc_license_number.getText());
                    ps.executeUpdate();
                    alert.successMessage("Doctor " + doc_first_name.getText().toUpperCase() + " "
                            + doc_surname.getText().toUpperCase() + " is Saved successfully!");
                    doctorShowListData();
                    doc_id.clear();
                    doc_first_name.clear();
                    doc_surname.clear();
                    doc_specialisation.clear();
                    doc_clinic_address.clear();
                    doc_phone_number.clear();
                    doc_license_number.clear();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void doctorUpdate() {
        if (doc_id.getText().isEmpty()
                || doc_first_name.getText().isEmpty()
                || doc_surname.getText().isEmpty()
                || doc_specialisation.getText().isEmpty()
                || doc_clinic_address.getText().isEmpty()
                || doc_license_number.getText().isEmpty()
                || doc_phone_number.getText().isEmpty()) {
            alert.errorMessage("Please fill all the blank fields.");
        } else {
            String updateQuery = "UPDATE doctor SET f_name = '" + doc_first_name.getText() + "',"
                    + "l_name = '" + doc_surname.getText() + "',"
                    + "specialisation = '" + doc_specialisation.getText() + "',"
                    + "license_num = '" + doc_license_number.getText() + "',"
                    + "ph_num = '" + doc_phone_number.getText() + "'"
                    + " WHERE doc_id = '" + doc_id.getText() + "'";

            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmation Message");
                alert.setContentText("Are you sure you want UPADTE Doctor with Doctor ID " + doc_id.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {
                    st = con.createStatement();
                    st.executeUpdate(updateQuery);

                    this.alert.successMessage("Doctor " + doc_first_name.getText().toUpperCase() + " "
                            + doc_surname.getText().toUpperCase() + " is successfully Updated!");
                    doctorShowListData();
                    doc_id.clear();
                    doc_first_name.clear();
                    doc_surname.clear();
                    doc_specialisation.clear();
                    doc_clinic_address.clear();
                    doc_phone_number.clear();
                    doc_license_number.clear();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void doctorDelete() {
        if (doc_id.getText().isEmpty()
                || doc_first_name.getText().isEmpty()
                || doc_surname.getText().isEmpty()
                || doc_specialisation.getText().isEmpty()
                || doc_clinic_address.getText().isEmpty()
                || doc_license_number.getText().isEmpty()
                || doc_phone_number.getText().isEmpty()) {
            alert.errorMessage("Please fill all the blank fields.");
        } else {
            String deleteQuery = "DELETE FROM doctor WHERE doc_id = '" + doc_id.getText() + "'";

            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmation Message");
                alert.setContentText("Are you sure you want Delete Doctor with Doctor ID " + doc_id.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {
                    st = con.createStatement();
                    st.executeUpdate(deleteQuery);

                    this.alert.successMessage("Doctor " + doc_first_name.getText().toUpperCase() + " "
                            + doc_surname.getText().toUpperCase() + " is successfully Deleted!");
                    doctorShowListData();
                    doc_id.clear();
                    doc_first_name.clear();
                    doc_surname.clear();
                    doc_specialisation.clear();
                    doc_clinic_address.clear();
                    doc_phone_number.clear();
                    doc_license_number.clear();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void resetDoctor() {
        int choice = JOptionPane.showConfirmDialog(null, "Your are about to reset all the fields"
                + "\nDo you want to reset?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null);
        if (choice == JOptionPane.YES_NO_OPTION) {

            doc_id.clear();
            doc_first_name.clear();
            doc_surname.clear();
            doc_specialisation.clear();
            doc_clinic_address.clear();
            doc_phone_number.clear();
            doc_license_number.clear();
        }
    }

    public void selectDoctor() {
        doctorData docData = doctor_tableView.getSelectionModel().getSelectedItem();
        int num = doctor_tableView.getSelectionModel().getSelectedIndex();
        if ((num - 1) < - 1) {
            return;
        }
        doc_id.setText(docData.getDoctor_id());
        doc_first_name.setText(docData.getFirst_name());
        doc_surname.setText(docData.getSurname());
        doc_specialisation.setText(docData.getSpecialisation());
        doc_clinic_address.setText(docData.getClinic_address());
        doc_phone_number.setText(docData.getPhone_number());
        doc_license_number.setText(docData.getLicense_number());
    }

    public void savePrescription() {
        if (pres_id.getText().isEmpty()
                || pres_pat_id.getSelectionModel().isEmpty()
                || pres_med_id.getSelectionModel().isEmpty()
                || pres_doc_id.getSelectionModel().isEmpty()
                || pres_date.getValue() == null
                || pres_qty.getText().isEmpty()
                || pres_instructions.getText().isEmpty()
                || pres_diagnosis.getText().isEmpty()
                || pres_pharmacist.getText().isEmpty()) {
            alert.errorMessage("Please fill all the blank");
        } else {
            String sql = "SELECT presc_id FROM prescription WHERE presc_id = '"
                    + pres_id.getText() + "'";
            con = Database.getConnection();

            try {
                st = con.createStatement();
                rs = st.executeQuery(sql);
                if (rs.next()) {
                    alert.errorMessage("Prescription ID " + pres_id.getText() + " is already exist!");
                } else {
                    String insertQuery = "INSERT INTO `prescription`(`presc_id`, `pat_id`, `med_id`, `doc_id`,"
                            + " `presc_date`, `qty_prescribed`, `instruction`, `diagnosis`, `phar_note`)"
                            + " VALUES (?,?,?,?,?,?,?,?,?)";
                    ps = con.prepareStatement(insertQuery);
                    ps.setString(1, pres_id.getText());
                    ps.setString(2, (String) pres_pat_id.getSelectionModel().getSelectedItem());
                    ps.setString(3, (String) pres_med_id.getSelectionModel().getSelectedItem());
                    ps.setString(4, (String) pres_doc_id.getSelectionModel().getSelectedItem());
                    ps.setDate(5, Date.valueOf(pres_date.getValue()));
                    String updateQuery = "UPDATE inventory SET qty_in_stock = qty_in_stock - "
                            + Integer.parseInt(pres_qty.getText()) + " WHERE med_id = '"
                            + pres_med_id.getSelectionModel().getSelectedItem() + "'";
                    String updateQuery1 = "UPDATE medication SET stock_qty = stock_qty - "
                            + Integer.parseInt(pres_qty.getText()) + " WHERE med_id = '"
                            + pres_med_id.getSelectionModel().getSelectedItem() + "'";
                    st = con.createStatement();
                    st.executeUpdate(updateQuery);
                    st.executeUpdate(updateQuery1);
                    ps.setInt(6, Integer.parseInt(pres_qty.getText()));
                    ps.setString(7, pres_instructions.getText());
                    ps.setString(8, pres_diagnosis.getText());
                    ps.setString(9, pres_pharmacist.getText());
                    ps.executeUpdate();
                    alert.successMessage("Prescription Successfully Added!");
                    prescriptionShowListData();
                    pres_id.clear();
                    pres_pat_id.getSelectionModel().clearSelection();
                    pres_med_id.getSelectionModel().clearSelection();
                    pres_doc_id.getSelectionModel().clearSelection();
                    pres_date.setValue(null);
                    pres_qty.clear();
                    pres_instructions.clear();
                    pres_diagnosis.clear();
                    pres_pharmacist.clear();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void updatePrescription() {
        if (pres_id.getText().isEmpty()
                || pres_pat_id.getSelectionModel().isEmpty()
                || pres_med_id.getSelectionModel().isEmpty()
                || pres_doc_id.getSelectionModel().isEmpty()
                || pres_date.getValue() == null
                || pres_qty.getText().isEmpty()
                || pres_instructions.getText().isEmpty()
                || pres_diagnosis.getText().isEmpty()
                || pres_pharmacist.getText().isEmpty()) {
            alert.errorMessage("Please fill all the blank");
        } else {
            String updateQuery = "UPDATE prescription SET pat_id = '"
                    + pres_pat_id.getSelectionModel().getSelectedItem() + "', med_id = '"
                    + pres_med_id.getSelectionModel().getSelectedItem() + "',doc_id = '"
                    + pres_doc_id.getSelectionModel().getSelectedItem() + "',presc_date = '"
                    + pres_date.getValue() + "', qty_prescribed = "
                    + pres_qty.getText() + ", instruction = '"
                    + pres_instructions.getText() + "', diagnosis = '"
                    + pres_diagnosis.getText() + "', phar_note = '"
                    + pres_pharmacist.getText() + "' WHERE presc_id = '"
                    + pres_id.getText() + "'";
            con = Database.getConnection();
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmation Message");
                alert.setContentText("Are you sure you want UPADTE Prescription with Prescription ID " + pres_id.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {
                    st = con.createStatement();
                    st.executeUpdate(updateQuery);

                    this.alert.successMessage("Prescription is successfully Updated!");
                    prescriptionShowListData();
                    pres_id.clear();
                    pres_pat_id.getSelectionModel().clearSelection();
                    pres_med_id.getSelectionModel().clearSelection();
                    pres_doc_id.getSelectionModel().clearSelection();
                    pres_date.setValue(null);
                    pres_qty.clear();
                    pres_instructions.clear();
                    pres_diagnosis.clear();
                    pres_pharmacist.clear();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void salePrescriptionID() {

        String sql = "SELECT * FROM prescription";

        con = Database.getConnection();

        try {
            ObservableList listData = FXCollections.observableArrayList();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                listData.add(rs.getString("presc_id"));
            }
            sale_presc_id.setItems(listData);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void salePatientID() {

        String sql = "SELECT * FROM patient";

        con = Database.getConnection();

        try {
            ObservableList listData = FXCollections.observableArrayList();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                listData.add(rs.getString("pat_id"));
            }
            sale_pat_id.setItems(listData);
            salePrescriptionID();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void salePharmacistID() {

        String sql = "SELECT * FROM pharmacist";

        con = Database.getConnection();

        try {
            ObservableList listData = FXCollections.observableArrayList();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                listData.add(rs.getString("phar_id"));
            }
            sale_phar_id.setItems(listData);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
    private int cID;

    public void customerID() {
        String sql = "SELECT MAX(id) FROM prescription";
        con = Database.getConnection();

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                cID = rs.getInt("MAX(id)");
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

    public void deletePrescription() {
        if (pres_id.getText().isEmpty()
                || pres_pat_id.getSelectionModel().isEmpty()
                || pres_med_id.getSelectionModel().isEmpty()
                || pres_doc_id.getSelectionModel().isEmpty()
                || pres_date.getValue() == null
                || pres_qty.getText().isEmpty()
                || pres_instructions.getText().isEmpty()
                || pres_diagnosis.getText().isEmpty()
                || pres_pharmacist.getText().isEmpty()) {
            alert.errorMessage("Please fill all the blank");
        } else {
            String deleteQuery = "DELETE FROM prescription WHERE presc_id = '"
                    + pres_id.getText() + "'";
            con = Database.getConnection();
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmation Message");
                alert.setContentText("Are you sure you want DELETE Prescription with Prescription ID " + pres_id.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {
                    st = con.createStatement();
                    st.executeUpdate(deleteQuery);

                    this.alert.successMessage("Prescription is successfully Updated!");
                    prescriptionShowListData();
                    pres_id.clear();
                    pres_pat_id.getSelectionModel().clearSelection();
                    pres_med_id.getSelectionModel().clearSelection();
                    pres_doc_id.getSelectionModel().clearSelection();
                    pres_date.setValue(null);
                    pres_qty.clear();
                    pres_instructions.clear();
                    pres_diagnosis.clear();
                    pres_pharmacist.clear();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void clearPrescriptionFields() {
        pres_id.clear();
        pres_pat_id.getSelectionModel().clearSelection();
        pres_med_id.getSelectionModel().clearSelection();
        pres_doc_id.getSelectionModel().clearSelection();
        pres_date.setValue(null);
        pres_qty.clear();
        pres_instructions.clear();
        pres_diagnosis.clear();
        pres_pharmacist.clear();
    }

    public void selectPrescription() {
        prescriptionData presData = prescription_tableView.getSelectionModel().getSelectedItem();
        int num = prescription_tableView.getSelectionModel().getSelectedIndex();
        if ((num - 1) < - 1) {
            return;
        }
        pres_id.setText(presData.getPrescription_id());
        pres_date.setValue(Date.valueOf(presData.getPrescription_date().toLocalDate()).toLocalDate());
        pres_qty.setText(presData.getQty_prescribed().toString());
        pres_instructions.setText(presData.getInstructions());
        pres_diagnosis.setText(presData.getDiagnosis());
        pres_pharmacist.setText(presData.getPharmacist_note());
    }

    public ObservableList<prescriptionData> prescriptionListData() {
        String sql = "SELECT * FROM prescription";
        ObservableList<prescriptionData> listData = FXCollections.observableArrayList();
        prescriptionData pData;
        con = Database.getConnection();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                pData = new prescriptionData(rs.getInt("customer_id"),
                        rs.getString("presc_id"),
                        rs.getString("pat_id"),
                        rs.getString("med_id"),
                        rs.getString("doc_id"),
                        rs.getDate("presc_date"),
                        rs.getInt("qty_prescribed"),
                        rs.getString("instruction"),
                        rs.getString("diagnosis"),
                        rs.getString("phar_note"));
                listData.add(pData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<prescriptionData> prescriptionListD;

    public void prescriptionShowListData() {
        prescriptionListD = prescriptionListData();
        pres_col_pres_id.setCellValueFactory(new PropertyValueFactory<>("prescription_id"));
        pres_col_pat_id.setCellValueFactory(new PropertyValueFactory<>("patient_id"));
        pres_col_med_id.setCellValueFactory(new PropertyValueFactory<>("medicine_id"));
        pres_col_doc_id.setCellValueFactory(new PropertyValueFactory<>("doctor_id"));
        pres_col_pres_date.setCellValueFactory(new PropertyValueFactory<>("prescription_date"));
        pres_col_qty.setCellValueFactory(new PropertyValueFactory<>("qty_prescribed"));
        pres_col_instructions.setCellValueFactory(new PropertyValueFactory<>("instructions"));
        pres_col_diagnosis.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        pres_col_pharmacist_note.setCellValueFactory(new PropertyValueFactory<>("pharmacist_note"));
        prescription_tableView.setItems(prescriptionListD);
    }

    public ObservableList<doctorData> doctorListData() {
        String sql = "SELECT * FROM doctor";
        ObservableList<doctorData> listData = FXCollections.observableArrayList();
        doctorData docData;
        con = Database.getConnection();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                docData = new doctorData(rs.getString("doc_id"),
                        rs.getString("f_name"),
                        rs.getString("l_name"),
                        rs.getString("specialisation"),
                        rs.getString("clinic_address"),
                        rs.getString("ph_num"),
                        rs.getString("license_num"));
                listData.add(docData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
    private ObservableList<doctorData> doctorListD;

    public void doctorShowListData() {
        doctorListD = doctorListData();
        doc_col_id.setCellValueFactory(new PropertyValueFactory<>("doctor_id"));
        doc_col_first_name.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        doc_col_surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        doc_col_specialisation.setCellValueFactory(new PropertyValueFactory<>("specialisation"));
        doc_col_clinic_address.setCellValueFactory(new PropertyValueFactory<>("clinic_address"));
        doc_col_phone_number.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        doc_col_license_number.setCellValueFactory(new PropertyValueFactory<>("license_number"));
        doctor_tableView.setItems(doctorListD);
    }

    public ObservableList<patientData> patientListData() {
        String sql = "SELECT * FROM patient";
        ObservableList<patientData> listData = FXCollections.observableArrayList();
        patientData patData;

        con = Database.getConnection();

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                patData = new patientData(rs.getString("pat_id"),
                        rs.getString("f_name"),
                        rs.getString("l_name"),
                        rs.getDate("dob"),
                        rs.getString("gender"),
                        rs.getString("address"),
                        rs.getString("ph_number"),
                        rs.getString("insurance_provider"),
                        rs.getString("insur_policy_num"),
                        rs.getString("alergy"),
                        rs.getString("medical_history"),
                        rs.getString("emerg_contact_name"),
                        rs.getString("emerg_contact_num"));
                listData.add(patData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<patientData> patientListD;

    public void patientShowListData() {
        patientListD = patientListData();
        pat_col_id.setCellValueFactory(new PropertyValueFactory<>("patient_id"));
        pat_col_first_name.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        pat_col_last_name.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        pat_col_date_of_birth.setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));
        pat_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        pat_col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        pat_col_phone_number.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        pat_col_insurance_provider.setCellValueFactory(new PropertyValueFactory<>("insurance_provider"));
        pat_col_insurance_policy_number.setCellValueFactory(new PropertyValueFactory<>("insurance_policy_number"));
        pat_col_allergy.setCellValueFactory(new PropertyValueFactory<>("allergy"));
        pat_col_medical_history.setCellValueFactory(new PropertyValueFactory<>("medical_history"));
        pat_col_emergency_contact_name.setCellValueFactory(new PropertyValueFactory<>("emergency_contact_name"));
        pat_col_emergency_contact_number.setCellValueFactory(new PropertyValueFactory<>("emergency_contact_number"));
        patient_tableView.setItems(patientListD);

    }

    public ObservableList<inventoryData> inventoryListData() {
        String sql = "SELECT * FROM inventory";
        ObservableList<inventoryData> listData = FXCollections.observableArrayList();
        inventoryData inventData;

        con = Database.getConnection();

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                inventData = new inventoryData(rs.getInt("invent_id"),
                        rs.getString("med_id"),
                        rs.getString("med_name"),
                        rs.getInt("qty_in_stock"),
                        rs.getInt("reorder_level"),
                        rs.getDate("last_updated"),
                        rs.getString("lot_num"));
                listData.add(inventData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<inventoryData> inventoryList;

    public void inventoryListShowData() {
        inventoryList = inventoryListData();
        invent_col_id.setCellValueFactory(new PropertyValueFactory<>("inventory_id"));
        invent_col_med_id.setCellValueFactory(new PropertyValueFactory<>("medication_id"));
        invent_col_med_name.setCellValueFactory(new PropertyValueFactory<>("medication_name"));
        invent_col_stock.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        invent_col_reoreder_level.setCellValueFactory(new PropertyValueFactory<>("reorder"));
        invent_col_date_for_update.setCellValueFactory(new PropertyValueFactory<>("updates"));
        invent_col_lot_number.setCellValueFactory(new PropertyValueFactory<>("lot_num"));
        inventory_tableView.setItems(inventoryList);
    }

    public void switchForm(ActionEvent event) {
        if (event.getSource() == dashboard_btn) {
            dashboard_form.setVisible(true);
            doctor_form.setVisible(false);
            patient_form.setVisible(false);
            inventory_form.setVisible(false);
            prescription_form.setVisible(false);
            sale_form.setVisible(false);
            changePassword_form.setVisible(false);

        } else if (event.getSource() == inventory_btn) {
            dashboard_form.setVisible(false);
            doctor_form.setVisible(false);
            patient_form.setVisible(false);
            inventory_form.setVisible(true);
            prescription_form.setVisible(false);
            sale_form.setVisible(false);
            changePassword_form.setVisible(false);

            inventoryMedicationId();
            inventoryMedicationName();
            inventoryListShowData();

        } else if (event.getSource() == doctor_btn) {
            dashboard_form.setVisible(false);
            doctor_form.setVisible(true);
            patient_form.setVisible(false);
            inventory_form.setVisible(false);
            prescription_form.setVisible(false);
            sale_form.setVisible(false);
            changePassword_form.setVisible(false);

            doctorShowListData();

        } else if (event.getSource() == patient_btn) {
            dashboard_form.setVisible(false);
            doctor_form.setVisible(false);
            patient_form.setVisible(true);
            inventory_form.setVisible(false);
            prescription_form.setVisible(false);
            sale_form.setVisible(false);
            changePassword_form.setVisible(false);

            patientShowListData();

        } else if (event.getSource() == prescription_btn) {
            dashboard_form.setVisible(false);
            doctor_form.setVisible(false);
            patient_form.setVisible(false);
            inventory_form.setVisible(false);
            prescription_form.setVisible(true);
            sale_form.setVisible(false);
            changePassword_form.setVisible(false);
            prescriptionShowListData();
            prescriptionMedicationId();
            prescriptionPatientId();
            prescriptionDoctorId();

        } else if (event.getSource() == sale_btn) {
            dashboard_form.setVisible(false);
            doctor_form.setVisible(false);
            patient_form.setVisible(false);
            inventory_form.setVisible(false);
            prescription_form.setVisible(false);
            sale_form.setVisible(true);
            changePassword_form.setVisible(false);

            salePrescriptionID();
            salePatientID();
            salePharmacistID();

        } else if (event.getSource() == changePassword_btn) {
            dashboard_form.setVisible(false);
            doctor_form.setVisible(false);
            patient_form.setVisible(false);
            inventory_form.setVisible(false);
            prescription_form.setVisible(false);
            sale_form.setVisible(false);
            changePassword_form.setVisible(true);

        }
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
                pharmacy_logout.getScene().getWindow().hide();
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayUserEmail();
        inventoryMedicationId();
        inventoryMedicationName();
        inventoryListShowData();
        displayCurrentTime(clockLabel);

        patientShowListData();
        selectGender();

        doctorShowListData();

        prescriptionMedicationId();
        prescriptionPatientId();
        prescriptionDoctorId();
        prescriptionShowListData();

        salePrescriptionID();
        salePatientID();
        salePharmacistID();
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
