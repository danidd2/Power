package Control;

import Model.Archive.Archive;
import Model.Archive.Results;
import Model.Calculator.BigNumber;
import Model.Calculator.Element;
import Model.Calculator.Result;
import View.SceenMaker;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class RandomCalculate
{
    EventHandler eventHandler;

    public RandomCalculate(SceenMaker sceenMaker)
    {
        log.info("was here");
        EventHandler<MouseEvent> randomHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                BigNumber bigNumber = new BigNumber();
                Element base = new Element(String.valueOf(bigNumber.getDecimalForm()));
                bigNumber = new BigNumber();
                Element power = new Element(String.valueOf(bigNumber.getDecimalForm()));
                bigNumber = new BigNumber();
                Element modulo = new Element(String.valueOf(bigNumber.getDecimalForm()));
                log.info("The result was made");


                Archive archive = new Archive();
                List temp  = archive.isPresent(base,power,modulo);
                if (temp.isEmpty())
                {
                    log.info("The result is not part of the database, we have to calculate it now");
                    Result result = new Result(base, power,modulo);
                    sceenMaker.createResultText(String.valueOf(result.getDecimalForm()));
                    log.info("For future use we add the result to the database");
                    archive.createRow(result);
                    sceenMaker.createResultText(String.valueOf(result.getDecimalForm()));
                    sceenMaker.setBaseTextField(String.valueOf(base.getDecimalForm()));
                    sceenMaker.setModuloTextField(String.valueOf(modulo.getDecimalForm()));
                    sceenMaker.setPowerTextField(String.valueOf(power.getDecimalForm()));
                }else
                {
                    log.info("The result is part of the database, we can acquire it from there");
                    Results result = (Results) temp.get(0);
                    sceenMaker.createResultText(result.getResult());
                    sceenMaker.createResultText(result.getResult());
                    sceenMaker.setBaseTextField(String.valueOf(base.getDecimalForm()));
                    sceenMaker.setModuloTextField(String.valueOf(modulo.getDecimalForm()));
                    sceenMaker.setPowerTextField(String.valueOf(power.getDecimalForm()));
                }
                archive.Close();
            }
        };
        eventHandler = randomHandler;
    }

    public EventHandler getEventHandler() {
        return eventHandler;
    }
}
