package org.Player;

import java.io.IOException;

import org.controllers.FXMLDocumentController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;




public class AppTest extends Application {

	
	
    @Override
    public void start(Stage stage) throws IOException {



        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/org/template/fxDocument.fxml")   );
        
        
        
        FXMLDocumentController controller = new FXMLDocumentController();
        fxmlLoader.setController(controller);
        
        Parent root = fxmlLoader.load();
        
      
        
        Scene scene = new Scene(root);
        


        stage.setScene(scene);
        
		
        stage.show();
        

        
        
    }

    public static void main(String[] args) {
        launch();
    }

    
    


    
}