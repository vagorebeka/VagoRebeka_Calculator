package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.util.Optional;

public class CalculatorController {
    public TextField szam1Field;
    public TextField szam2Field;
    public Label eredmenyLabel;
    double szam1;
    double szam2;
    Double eredmeny;
    DecimalFormat df = new DecimalFormat("#.##");

    @FXML

    public boolean kitoltottEllenoriz(){
        boolean kitoltve = false;
        if (szam1Field.getText().trim() == "" || szam2Field.getText().trim() == ""){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Nem lett szám megadva!", ButtonType.OK);
            alert.showAndWait();
        }else{
            try {
                szam1 = Double.parseDouble(szam1Field.getText());
                szam2 = Double.parseDouble(szam2Field.getText());
                kitoltve = true;
            }catch(Exception e){
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Csak számot adjon meg!", ButtonType.OK);
                alert.showAndWait();
            }
        }
        return kitoltve;
    }

    public void pluszButtonClick(ActionEvent actionEvent) {
        if (kitoltottEllenoriz()){
            szam1 = Double.parseDouble(szam1Field.getText());
            szam2 = Double.parseDouble(szam2Field.getText());
            eredmeny = szam1 + szam2;
            eredmenyLabel.setText(String.valueOf(eredmeny));
        }
    }

    public void minuszButtonClick(ActionEvent actionEvent) {
        if (kitoltottEllenoriz()){
        szam1 = Double.parseDouble(szam1Field.getText());
        szam2 = Double.parseDouble(szam2Field.getText());
        eredmeny = szam1 - szam2;
        eredmenyLabel.setText(String.valueOf(eredmeny));
        }
    }

    public void szorzasButtonClick(ActionEvent actionEvent) {
        if (kitoltottEllenoriz()){
        szam1 = Double.parseDouble(szam1Field.getText());
        szam2 = Double.parseDouble(szam2Field.getText());
        eredmeny = szam1 * szam2;
        eredmenyLabel.setText(String.valueOf(eredmeny));
        }
    }

    public void osztasButtonClick(ActionEvent actionEvent) {
        if (kitoltottEllenoriz()){
        szam1 = Double.parseDouble(szam1Field.getText());
        szam2 = Double.parseDouble(szam2Field.getText());
        eredmeny = szam1 / szam2;
        eredmenyLabel.setText(String.valueOf(df.format(eredmeny)));
        }
    }

    public void szazalekButtonClick(ActionEvent actionEvent) {
        if (kitoltottEllenoriz()){
        szam1 = Double.parseDouble(szam1Field.getText());
        szam2 = Double.parseDouble(szam2Field.getText());
        eredmeny = szam1 / szam2 * 100;
        eredmenyLabel.setText(df.format(eredmeny) + "%");
        }
    }
}