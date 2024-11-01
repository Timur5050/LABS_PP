package logger;
import java.util.Properties;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;

public class MailLogger {
    private final jakarta.mail.Session session;
    private Properties props;
    private jakarta.mail.Message message;

    public MailLogger()
    {
        props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        session = jakarta.mail.Session.getInstance(props, new jakarta.mail.Authenticator() {
            @Override
            protected jakarta.mail.PasswordAuthentication getPasswordAuthentication() {
                return new jakarta.mail.PasswordAuthentication("nonametestgg@gmail.com", "dksz tald wxxa bbny");
            }
        });
    }

    public void sendMessages(String subject, String text)
    {
        try {
            message = new jakarta.mail.internet.MimeMessage(session);
            message.setFrom(new jakarta.mail.internet.InternetAddress("nonametestgg@gmail.com"));
            message.setRecipients(jakarta.mail.Message.RecipientType.TO, InternetAddress.parse("stukantimur811@gmail.com"));
            message.setSubject(subject);
            message.setText(text);

            jakarta.mail.Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
