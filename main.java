package com.internshala.connect4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    public Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("myGame.fxml"));
        GridPane rootGridPane=loader.load();
        controller = loader.getController();
        controller.createPlayGround();
        MenuBar menuBar=createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);
        Scene scene = new Scene(rootGridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
   private MenuBar createMenu(){
        Menu filemenu = new Menu("File");
       MenuItem newMenu = new MenuItem("New Game");
       newMenu.setOnAction(event -> controller.resetGame());
       MenuItem resetMenu = new MenuItem("Reset Game");
       resetMenu.setOnAction(event -> controller.resetGame());
       SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
       MenuItem exitMenu = new MenuItem("Exit Game");
       exitMenu.setOnAction(event -> exitGame());
       filemenu.getItems().addAll(newMenu,resetMenu,separatorMenuItem,exitMenu);
       Menu helpMenu = new Menu("Help");
       MenuItem aboutme = new MenuItem("About Me");
       aboutme.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setHeaderText("Ashutosh Chandra");
               alert.setContentText("i am very scared of this type of coding");
               alert.show();
           }
       });
       SeparatorMenuItem separatorMenuItem1 = new SeparatorMenuItem();
       MenuItem aboutGame = new MenuItem("About Game");
       aboutGame.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               aboutGame();
           }
       });
       helpMenu.getItems().addAll(aboutme,separatorMenuItem1,aboutGame);
       MenuBar menuBar = new MenuBar();
       menuBar.getMenus().addAll(filemenu,helpMenu);
       return menuBar;

   }

    private void aboutGame() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect4");
        alert.setHeaderText("How To Play");
        alert.setContentText("I am just a beginner in coding Game but soon u will be Pro");
        alert.show();
    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    private void resetGame() {

    }

    public static void main(String[] args) {
        launch(args);
    }
}
