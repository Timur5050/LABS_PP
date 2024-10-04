package logging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class FileLogger extends BaseLogger {
    String filePath = "droids.txt";
    File file = new File(filePath);

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
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(colorToPaint + content + map.get("reset"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
