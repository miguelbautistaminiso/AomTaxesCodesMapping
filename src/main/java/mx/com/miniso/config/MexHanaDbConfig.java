package mx.com.miniso.config;

import mx.com.miniso.domain.impl.UpdateTaxesCodesImpl;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

public class MexHanaDbConfig implements InitializingBean, DisposableBean {


    protected Logger log = Logger.getLogger(UpdateTaxesCodesImpl.class.getName());

    private Connection connection;

    @Override
    public void afterPropertiesSet() throws Exception {
        try {

            System.out.println("Java version: " + com.sap.db.jdbc.Driver.getJavaVersion());
            Class.forName("com.sap.db.jdbc.Driver");
            String url = "jdbc:sap://10.35.242.174:30015/SBOMINISO";
            String user = "MNSO_READER_005";
            String password = "Mi12345*";
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            log.info("TaskStoreService afterPropertiesSet : " + e.getMessage());
        }
    }

    @Override
    public void destroy() throws Exception {
        try {
            log.info("TaskStoreService: destroy ");
            if (connection != null && !connection.isClosed())
                connection.close();
        } catch (Exception e) {
            log.info("TaskStoreService: error close connection");
        }
    }
}
