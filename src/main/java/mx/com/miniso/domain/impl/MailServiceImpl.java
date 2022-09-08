package mx.com.miniso.domain.impl;

import mx.com.miniso.domain.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.logging.Logger;

@Component(value = "mailService")
public class MailServiceImpl implements MailService {

    private static final Logger LOGGER = Logger.getAnonymousLogger();


    @Value("${errors.mail}")
    private String mails;


    @Value("${errors.mail.html}")
    private String mailPath;

    @Value("${errors.mail.subject}")
    private String mailSubject;

    @Value("${mail.image.path}")
    private String mailImagePath;

    @Value("${spring.mail.username}")
    private String originMail;

    @Autowired
    private JavaMailSender sender;


    @Override
    public void sendMail() throws MessagingException, UnsupportedEncodingException {

        LOGGER.info("--------------------------------------------------");
        LOGGER.info("Enviando correo");

        MimeMessage mimeMsg = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMsg, true);
        helper.setFrom(new InternetAddress(originMail, originMail));

        // ArrayList<String> mails = getMails();
        //mails.forEach(u -> {
        try {
            helper.setTo(mails.split("\\;"));
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        StringBuilder contentBuilder = new StringBuilder();
        try {
            //            BufferedReader in = new BufferedReader(new FileReader(customMailPath));
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(mailPath),
                            "UTF-8"));
            String str;
            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }
            in.close();
        } catch (IOException e) {

        }

        String content = contentBuilder.toString();
/*
        content = content.replace("{service}", service);
        content = content.replace("{orden}", ecomId);
        content = content.replace("{status}", status);
*/

        helper.setText(content, true);
        helper.setSubject(mailSubject);

        Resource res = new FileSystemResource(new File(mailImagePath));
        helper.addInline("id1234", res);


        try {

            sender.send(mimeMsg);
        } catch (Exception e) {
            System.out.printf(e.getMessage());

        }


    }


    private String[] getMails() {

        String[] array = mails.split("\\;");

        return array;
    }


}
