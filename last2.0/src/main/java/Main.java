import Menus.Menu;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import logger.MailLogger;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Properties;


public class Main {
    private static Menu menu = new Menu();

    public static void setMenu(Menu newMenu) {
        menu = newMenu;
    }

    public static void main(String[] args) {
        MailLogger mailLogger = new MailLogger();

        try{
            menu.menu();
        } catch (Exception e)
        {
            String errorClass = e.getClass() != null ? e.getClass().toString() : "Unknown exception";
            String errorMessage = e.getMessage() != null ? e.getMessage() : "No message available";
            mailLogger.sendMessages(errorClass, errorMessage);
        }

    }
}