/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalyearproject_pharmacymanagementsystem;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author ABUO BERNARD
 */
public class LoginFormController implements Initializable {

    @FXML
    private AnchorPane main_form;

    @FXML
    private JFXTextField user_email;

    @FXML
    private JFXPasswordField user_password;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private JFXComboBox<?> user_role;

    @FXML
    private Button use;

    @FXML
    private Button pass;

    private double x = 0;
    private double y = 0;

    public String EmailPattern = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    AlertMessage alert = new AlertMessage();

    public void login() throws IOException {
        if (user_email.getText().isEmpty()) {
            alert.errorMessage("Please email field is reqiured");
        } else if (!user_email.getText().matches(EmailPattern)) {
            alert.errorMessage("Invalid Email Account");
        } else if (user_role.getSelectionModel().isEmpty()) {
            alert.errorMessage("Please User Role field is required");
        } else if (user_password.getText().isEmpty()) {
            alert.errorMessage("Please Password field is required");
        } else {
            String query = "SELECT * FROM user WHERE email = ? AND role = ?";
            try (Connection con = Database.getConnection();
                    PreparedStatement ps = con.prepareStatement(query)) {

                String inputPassword = user_password.getText();

                ps.setString(1, user_email.getText());
                ps.setString(2, (String) user_role.getSelectionModel().getSelectedItem());

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        data.useremail = user_email.getText();
                        String storedHashedPassword = rs.getString("password");
                        //String email = rs.getString("email"); // Retrieve email

                        if (BCrypt.checkpw(inputPassword, storedHashedPassword)) {
                            // Login successful
                           
                            if (user_role.getSelectionModel().getSelectedItem().equals("Admin")) {
                                alert.successMessage("Login Successfully!");
                                loginBtn.getScene().getWindow().hide();
                                Parent root = FXMLLoader.load(getClass().getResource("AdministratorDashboard.fxml"));

                                Stage stage = new Stage();
                                Scene scene = new Scene(root);

                                root.setOnMousePressed((MouseEvent event) -> {
                                    x = event.getSceneX();
                                    y = event.getSceneY();
                                });

                                root.setOnMouseDragged((MouseEvent event) -> {
                                    stage.setX(event.getScreenX() - x);
                                    stage.setY(event.getScreenY() - y);

                                });

                                stage.initStyle(StageStyle.TRANSPARENT);
                                stage.setScene(scene);
                                stage.show();
                            } else if (user_role.getSelectionModel().getSelectedItem().equals("Pharmacist")) {
                                alert.successMessage("Login Successfully!");
                                loginBtn.getScene().getWindow().hide();
                                Parent root = FXMLLoader.load(getClass().getResource("PharmacistDashboard.fxml"));

                                Stage stage = new Stage();
                                Scene scene = new Scene(root);

                                root.setOnMousePressed((MouseEvent event) -> {
                                    x = event.getSceneX();
                                    y = event.getSceneY();
                                });

                                root.setOnMouseDragged((MouseEvent event) -> {
                                    stage.setX(event.getScreenX() - x);
                                    stage.setY(event.getScreenY() - y);

                                });

                                stage.initStyle(StageStyle.TRANSPARENT);
                                stage.setScene(scene);
                                stage.show();
                            }

                        } else {
                            alert.errorMessage("Incorrect password.");
                        }
                    } else {
                        alert.errorMessage("User not found.");
                    }
                }
            } catch (SQLException e) {
                alert.errorMessage("Database error: " + e.getMessage());
                e.printStackTrace(); // Log the exception
            }
        }
    }

    public void close() {
        System.exit(0);
    }

    public void minimize() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }
    private String[] userRole = {"Admin", "Pharmacist"};

    public void selectRole() {
        List<String> listR = new ArrayList();
        for (String data : userRole) {
            listR.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(listR);
        user_role.setItems(listData);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        selectRole();
    }

}
