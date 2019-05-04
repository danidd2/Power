package Control;

import Model.Archive.Results;
import Model.Calculator.Element;
import Model.Calculator.Result;
import Model.Archive.Archive;
import View.SceenMaker;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.util.List;

@Slf4j
public class Calculate
{
    private EventHandler eventHandler;

    public Calculate(SceenMaker sceenMaker)
    {
        EventHandler<MouseEvent> temeventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                sceenMaker.SetValues();
                log.info(sceenMaker.getBase() + " " + sceenMaker.getPower() + " " + sceenMaker.getModulo());
                if(sceenMaker.getBase().isEmpty() || sceenMaker.getModulo().isEmpty() || sceenMaker.getPower().isEmpty())
                {
                    log.info("One ore more components were empty");
                    sceenMaker.createError();
                }
                else
                {
                    if(!sceenMaker.getInformationText().getText().isEmpty())
                    {
                        sceenMaker.deleteInformationText();
                    }
                    Element base = new Element(sceenMaker.getBase());
                    Element power = new Element(sceenMaker.getPower());
                    Element modulo = new Element(sceenMaker.getModulo());
                    Archive archive = new Archive();
                    List temp  = archive.isPresent(base,power,modulo);
                    if (temp.isEmpty())
                    {
                        log.info("The result is not part of the database, we have to calculate it now");
                        Result result = new Result(base, power,modulo);
                        sceenMaker.createResultText(String.valueOf(result.getDecimalForm()));
                        log.info("For future use we add the result to the database");
                        archive.createRow(result);
                    }else
                    {
                        log.info("The result is part of the database, we can acquire it from there");
                        Results result = (Results) temp.get(0);
                        sceenMaker.createResultText(result.getResult());
                    }
                    archive.Close();
                }
            }
        };
        this.eventHandler = temeventHandler;
    }

    public EventHandler getEventHandler() {
        return eventHandler;
    }
}
