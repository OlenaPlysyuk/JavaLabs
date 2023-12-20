package command;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class SendEmail implements CommandInterface{
    @Override
    public CommandResult<String> execute() throws Exception {
        final String senderEmail = "olena.plusyyk@outlook.com";
        final String senderPassword = "Gta6pl73";
        final String recipientEmail = "o.plysyuuk@gmail.com";
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.office365.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        prop.put("mail.smtp.starttls.enable", "true");

        // Використовуйте javax.mail.Authenticator замість java.net.PasswordAuthentication
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        };

        Session session = Session.getInstance(prop, authenticator);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(recipientEmail)
            );
            message.setSubject("Запит на пошту");

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Вітаю , надсилаю Вам приклад лог файлу");
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(new File("C:/Users/oplys/output.txt"));
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);
            message.setContent(multipart);
            Transport.send(message);

            System.out.println("Done");
            CommandResult<String> result = new CommandResult<String>("Choosing self pick up was successful", "Without errors", true);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
