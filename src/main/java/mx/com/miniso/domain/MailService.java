package mx.com.miniso.domain;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface MailService {

    public void sendMail() throws MessagingException, UnsupportedEncodingException;

}
