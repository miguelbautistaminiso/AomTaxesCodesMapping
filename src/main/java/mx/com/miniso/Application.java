package mx.com.miniso;

import mx.com.miniso.domain.impl.AomTaxesCodesIntegrationImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.logging.Logger;

@SpringBootApplication
public class Application {

    protected static Logger log = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) {
        System.out.println("Starting main...");
        final ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        final AomTaxesCodesIntegrationImpl execute = context.getBean("aomTaxesCodesIntegration", AomTaxesCodesIntegrationImpl.class);

        execute.exec();

        System.out.println("Ending...  ");
        System.exit(0);
    }

}
