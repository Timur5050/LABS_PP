package logging;

import java.util.Objects;

public class ConsoleLogger extends BaseLogger {

    @Override
    public void logInformation(String content, String color)
    {
        String colorToPaint;
        if(Objects.equals(color, ""))
        {
            colorToPaint = map.get("white");
        }
        else
        {
            colorToPaint = map.get(color);
        }

        System.out.println(colorToPaint + content + map.get("reset"));
    }
}
