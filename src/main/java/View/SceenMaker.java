package View;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SceenMaker {
    private String base;
    private String power;
    private String modulo;
    private Text informationText = new Text();
    private Stage primaryStage = new Stage();
    private TextField baseTextField = new TextField();
    private TextField powerTextField = new TextField();
    private TextField moduloTextField = new TextField();
    private Button getButton = new Button("Get");
    private Button randomButon = new Button("Random");
    private boolean empty =true;

    public SceenMaker() {
        primaryStage.setTitle("Modulo Power Calculator");
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        Label base = new Label("Base");
        gridPane.add(base, 0, 1);
        gridPane.add(baseTextField, 1, 1);
        Label power = new Label("Power");
        gridPane.add(power, 0, 2);
        gridPane.add(powerTextField, 1, 2);
        Label modulo = new Label("Modulo");
        gridPane.add(modulo, 0, 3);
        gridPane.add(moduloTextField, 1, 3);
        Scene scene = new Scene(gridPane, 600, 300);
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.getChildren().add(getButton);
        gridPane.add(hBox, 1, 4);
        gridPane.add(informationText,1,5);
        HBox hBox1 = new HBox(10);
        hBox1.setAlignment(Pos.CENTER_LEFT);
        hBox1.getChildren().add(randomButon);
        gridPane.add(hBox1,2,4);


        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public String getBase() {
        return base;
    }

    public String getPower() {
        return power;
    }

    public Button getGetButton() {
        return getButton;
    }

    public Button getRandomButon()
    {
        return randomButon;
    }

    public String getModulo() {
        return modulo;
    }

    public boolean getEmpty() {
        return empty;
    }

    public void setBaseTextField(String text) {
        this.baseTextField.setText(text);
    }

    public void setPowerTextField(String text) {
        this.powerTextField.setText(text);
    }

    public void setModuloTextField(String text) {
        this.moduloTextField.setText(text);
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public Text getInformationText() {
        return informationText;
    }

    public void createError()
    {
        informationText.setFill(Color.FIREBRICK);
        informationText.setFont(Font.font("Arial", FontWeight.BOLD,15));
        informationText.setText("There are empty fields !");
    }
    public void deleteInformationText()
    {
        informationText.setText("");
    }

    public void createResultText(String result)
    {
        informationText.setFill(Color.BLUEVIOLET);
        informationText.setFont(Font.font("Arial", FontWeight.BOLD,15));
        informationText.setText(result);
    }

    public void SetValues() {
        base = baseTextField.getText();
        power = powerTextField.getText();
        modulo = moduloTextField.getText();
        }


}

    //    primaryStage.setTitle("Modulo Power Calculator");
//    GridPane gridPane = new GridPane();
//        gridPane.setAlignment(Pos.CENTER);
//        gridPane.setHgap(10);
//        gridPane.setVgap(10);
//        gridPane.setPadding(new Insets(25,25,25,25));
//
//    Label base = new Label("Base");
//        gridPane.add(base,0,1);
//    TextField baseTextField = new TextField();
//        gridPane.add(baseTextField,1,1);
//    Label power = new Label("Power");
//        gridPane.add(power,0,2);
//    TextField powerTextField = new TextField();
//        gridPane.add(powerTextField,1,2);
//    Label modulo = new Label("Modulo");
//        gridPane.add(modulo,0,3);
//    TextField moduloTextField = new TextField();
//        gridPane.add(moduloTextField,1,3);
//
//    Button getButton = new Button("Get");
//        getButton.addEventHandler(MouseEvent.MOUSE_CLICKED,SuperControl);
//    HBox hBox = new HBox(10);
//        hBox.setAlignment(Pos.BOTTOM_CENTER);
//        hBox.getChildren().add(getButton);
//        gridPane.add(hBox,1,4);
//
//        gridPane.add(errortext,1,5);
//
//    Scene scene = new Scene(gridPane,600,300);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//}
//
//    public void SetValues(TextField baseTextField, TextField powerTextField, TextField moduloTextField)
//    {
//        if(!baseTextField.getText().isEmpty() && !powerTextField.getText().isEmpty() && !moduloTextField.getText().isEmpty() )
//        {
//            base = baseTextField.getText();
//            power = powerTextField.getText();
//            modulo = moduloTextField.getText();
//            log.info("The text value was set to " + base);
//        }
//        else
//        {
//            log.info("One ore more of the requerd values are empty!");
//            errortext.setFill(Color.FIREBRICK);
//            errortext.setFont(Font.font("Arial", FontWeight.BOLD,15));
//            errortext.setText("There are empty fields !");
//
//
//        }
//    }
//
//    public String getBase() {
//        return base;
//    }
//
//    public String getPower() {
//        return power;
//    }
//
//    public String getModulo() {
//        return modulo;
//    }

