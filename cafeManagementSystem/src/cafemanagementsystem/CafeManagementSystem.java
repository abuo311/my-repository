/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafemanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author ABUO BERNARD
 */
public class CafeManagementSystem extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Image applicationIcon = new Image(getClass().getResource("Bernito logo.png").toString());
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);
 
        stage.setTitle("Cafe Shop Management System");      

        stage.setScene(scene);
        stage.show();
        stage.getIcons().add(applicationIcon);
        stage.getIcons().add(new Image(CafeManagementSystem.class.getResourceAsStream("Bernito logo.png")));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
