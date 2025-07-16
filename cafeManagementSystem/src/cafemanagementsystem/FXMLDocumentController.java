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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author ABUO BERNARD
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button fp_backBtn;

    @FXML
    private Button fp_proceedBtn;

    @FXML
    private ComboBox<?> fp_question;

    @FXML
    private AnchorPane fp_questionForm;

    @FXML
    private TextField fp_question_answer;

    @FXML
    private TextField fp_question_username;

    @FXML
    private Button np_backBtn;

    @FXML
    private Button np_changePassBtn;

    @FXML
    private PasswordField np_confirmPass;

    @FXML
    private PasswordField np_newPassword;

    @FXML
    private AnchorPane np_newPasswordForm;

    @FXML
    private Hyperlink si_ForgotPass;

    @FXML
    private Button si_LoginBtn;

    @FXML
    private AnchorPane si_LoginForm;

    @FXML
    private PasswordField si_Password;

    @FXML
    private TextField si_Username;

    @FXML
    private Button sideCreateBtn;

    @FXML
    private AnchorPane sideForm;

    @FXML
    private Button side_AlreadyHave;

    @FXML
    private TextField su_answer;

    @FXML
    private PasswordField su_password;

    @FXML
    private ComboBox<?> su_question;

    @FXML
    private Button su_sigupBtn;

    @FXML
    private AnchorPane su_sigupform;

    @FXML
    private TextField su_username;

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Statement st;
    private Alert alert;

    public void loginBtn() {
        if (si_Username.getText().isEmpty() || si_Password.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            String selectData = "SELECT username, password FROM employee WHERE username = ? AND password = ?";
            con = Database.getConnect();
            try {
                ps = con.prepareStatement(selectData);
                ps.setString(1, si_Username.getText());
                ps.setString(2, si_Password.getText());

                rs = ps.executeQuery();

                //IF SUCCEED THEN PROCEED TO ANOTHER FORM WHICH THE MAIN FORM
                if (rs.next()) {
                    data.username = si_Username.getText();
                    
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Login!");
                    alert.showAndWait();
                    si_LoginBtn.getScene().getWindow().hide();
                    Image applicationIcon = new Image(getClass().getResource("Bernito logo.png").toString());
                    Parent root = FXMLLoader.load(getClass().getResource("mainForm.fxml"));
                    
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    
                    stage.setTitle("Cafe Shop Management System");
                    stage.show();
                    stage.getIcons().add(applicationIcon);
                    si_LoginBtn.getScene().getWindow().hide(); 
                    
                } else { //IF NOT, THEN ERROR MESSAGE WILL BE DISPLAY
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Incorrect username/password");
                    alert.showAndWait();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void regBtn() {

        if (su_username.getText().isEmpty()
                || su_password.getText().isEmpty()
                || su_question.getSelectionModel().getSelectedItem() == null
                || su_answer.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            String regData = "INSERT INTO employee(username,password,question,answer,date)"
                    + "VALUES(?,?,?,?,?)";
            con = Database.getConnect();
            try {

                String checkUsername = "SELECT username FROM employee WHERE username = '"
                        + su_username.getText() + "'";

                ps = con.prepareStatement(checkUsername);
                rs = ps.executeQuery();

                if (rs.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText(su_username.getText() + " is already taken");
                    alert.showAndWait();
                } else if (su_password.getText().length() < 8) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Invalid password at least 8 characters are needed");
                    alert.showAndWait();
                } else {
                    ps = con.prepareStatement(regData);
                    ps.setString(1, su_username.getText());
                    ps.setString(2, su_password.getText());
                    ps.setString(3, (String) su_question.getSelectionModel().getSelectedItem());
                    ps.setString(4, su_answer.getText());

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    ps.setString(5, String.valueOf(sqlDate));

                    ps.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully registered account?");
                    alert.showAndWait();

                    su_username.setText("");
                    su_password.setText("");
                    su_question.getSelectionModel().clearSelection();
                    su_answer.setText("");

                    TranslateTransition slider = new TranslateTransition();

                    slider.setNode(sideForm);
                    slider.setToX(0);
                    slider.setDuration(Duration.seconds(.5));

                    slider.setOnFinished((ActionEvent e) -> {
                        side_AlreadyHave.setVisible(false);
                        sideCreateBtn.setVisible(true);

                    });

                    slider.play();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String[] questionList = {"What is your favorite color?", "What is your favorite food?", 
        "What is your birth date?"};

    public void regLquestionList() {
        List<String> listQ = new ArrayList<>();

        for (String data : questionList) {
            listQ.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listQ);
        su_question.setItems(listData);
    }

    public void switchForgotPass() {
        fp_questionForm.setVisible(true);
        si_LoginForm.setVisible(false);
        forgotPassQuestionList();
    }

    public void forgotPassQuestionList() {
        List<String> listQ = new ArrayList<>();

        for (String data : questionList) {
            listQ.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listQ);
        fp_question.setItems(listData);
    }

    public void proceedBtn() {
        if (fp_question.getSelectionModel().getSelectedItem() == null
                || fp_question_answer.getText().isEmpty()
                || fp_question_username.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            String selectData = "SELECT username,question,answer FROM employee WHERE username = ? AND"
                    + " question = ? AND answer = ?";

            con = Database.getConnect();

            try {
                ps = con.prepareStatement(selectData);
                ps.setString(1, fp_question_username.getText());
                ps.setString(2, (String) fp_question.getSelectionModel().getSelectedItem());
                ps.setString(3, fp_question_answer.getText());

                rs = ps.executeQuery();

                if (rs.next()) {
                    np_newPasswordForm.setVisible(true);
                    fp_questionForm.setVisible(false);
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Incorrect information");
                    alert.showAndWait();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void changePassBtn() {
        if (np_newPassword.getText().isEmpty() || np_confirmPass.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            String getDate = "SELECT date FROM employee WHERE username = '" + fp_question_username.getText() + "'";

            con = Database.getConnect();

            if (np_newPassword.getText().equals(np_confirmPass.getText())) {
                try {
                    ps = con.prepareStatement(getDate);
                    rs = ps.executeQuery();

                    String date = "";
                    if (rs.next()) {
                        date = rs.getString("date");
                    }

                    String updatePass = "UPDATE employee SET password = '"
                            + np_newPassword.getText() + "', question = '"
                            + fp_question.getSelectionModel().getSelectedItem() + "', answer = '"
                            + fp_question_answer.getText() + "', date = '"
                            + date + "' WHERE username = '" + fp_question_username.getText() + "'";

                    ps = con.prepareStatement(updatePass);
                    ps.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfull Changed Password!");
                    alert.showAndWait();
                    
                    si_LoginForm.setVisible(true);
                    np_newPasswordForm.setVisible(false);
                    
                    np_confirmPass.setText("");
                    np_newPassword.setText("");
                    fp_question.getSelectionModel().clearSelection(); 
                    fp_question_answer.setText("");
                    fp_question_username.setText(""); 
                    
                    

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Mismatch :3");
                alert.showAndWait();

            }

        }
    }
    
    public void backToLoginForm(){
        si_LoginForm.setVisible(true);
        fp_questionForm.setVisible(false);
    }
    
    public void backToOuestionForm(){
        fp_questionForm.setVisible(true);
        np_newPasswordForm.setVisible(false);
    }

    public void switchForm(ActionEvent event) {

        TranslateTransition slider = new TranslateTransition();

        if (event.getSource() == sideCreateBtn) {
            slider.setNode(sideForm);
            slider.setToX(300);
            slider.setDuration(Duration.seconds(.5));

            slider.setOnFinished((ActionEvent e) -> {
                side_AlreadyHave.setVisible(true);
                sideCreateBtn.setVisible(false);

                fp_questionForm.setVisible(false);
                si_LoginForm.setVisible(true);
                np_newPasswordForm.setVisible(false);

                regLquestionList();
            });

            slider.play();

        } else if (event.getSource() == side_AlreadyHave) {
            slider.setNode(sideForm);
            slider.setToX(0);
            slider.setDuration(Duration.seconds(.5));

            slider.setOnFinished((ActionEvent e) -> {
                side_AlreadyHave.setVisible(false);
                sideCreateBtn.setVisible(true);

                fp_questionForm.setVisible(false);
                si_LoginForm.setVisible(true);
                np_newPasswordForm.setVisible(false);

            });

            slider.play();

        }

    }

    @Override
    public void initialize(URL url,  ResourceBundle resources) {
        // TODO
    }

}
