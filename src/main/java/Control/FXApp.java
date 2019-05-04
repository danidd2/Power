package Control;
import javafx.application.Application;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import View.SceenMaker;


@Slf4j

public class FXApp extends Application {

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        SceenMaker sceenMaker = new SceenMaker();
        Calculate calculate = new Calculate(sceenMaker);
        RandomCalculate randomCalculate = new RandomCalculate(sceenMaker);
        sceenMaker.getGetButton().addEventHandler(MouseEvent.MOUSE_CLICKED,calculate.getEventHandler());
        sceenMaker.getRandomButon().addEventHandler(MouseEvent.MOUSE_CLICKED,randomCalculate.getEventHandler());
    }
}
