package logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    public void logInformation(String data)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("logger.txt", true))) {
            writer.write(data);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
