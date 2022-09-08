package mx.com.miniso.jpa.hana;

import mx.com.miniso.jpa.entities.ColTaxCodeEntity;
import mx.com.miniso.jpa.repositories.ColTaxCodeRepository;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.logging.Logger;

@Component(value = "hanaDbCol")
public class HanaDbCol  implements InitializingBean, DisposableBean {
    protected Logger log = Logger.getLogger(HanaDbCol.class.getName());

    private Connection connection;

    @Autowired
    private ColTaxCodeRepository colTaxCodeRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        try {

            System.out.println("Java version: " + com.sap.db.jdbc.Driver.getJavaVersion());
            Class.forName("com.sap.db.jdbc.Driver");
            String url = "jdbc:sap://10.35.242.174:30015/SBO_MINISO_COLOMBIA";
            String user = "MNSO_READER_005";
            String password = "Mi12345*";
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            log.info("TaskStoreService afterPropertiesSet : " + e.getMessage());
        }
    }

    public void getColUpcs() {

        if(connection !=null)

        {
            try {
                System.out.println("Connection to HANA successful!");
                Statement stmt = connection.createStatement();
                ResultSet resultSet = stmt.executeQuery("SELECT \n" +
                        "DISTINCT (T4.\"BcdCode\") AS \"UPC\",\n" +
                        "T0.\"ItemCode\" AS \"SKU\", \n" +
                        "IFNULL(T0.\"TaxCodeAR\",'')  AS \"TaxGroup\"\n" +
                        "FROM SBO_MINISO_COLOMBIA.OITM T0\n" +
                        "LEFT JOIN SBO_MINISO_COLOMBIA.\"@SUBFAMILIA\" AS T1 ON T0.\"U_SUBFAMILIA\" = T1.\"Name\"\n" +
                        "LEFT JOIN SBO_MINISO_COLOMBIA.\"@SUBSUBFAMILIA\" AS T2 ON T0.\"U_SUBSUBFAMILIA\" = T2.\"Name\"\n" +
                        "LEFT JOIN SBO_MINISO_COLOMBIA.OITB AS T3 ON T0.\"ItmsGrpCod\" = T3.\"ItmsGrpCod\"\n" +
                        "RIGHT JOIN SBO_MINISO_COLOMBIA.OBCD AS T4 ON T0.\"ItemCode\" = T4.\"ItemCode\"\n" +
                        "LEFT JOIN (SELECT T6.\"ItemCode\" , SUM(T6.\"OnHand\"-T6.\"IsCommited\") AS \"stock\" FROM \"SBO_MINISO_COLOMBIA\".\"OITW\"  T6  GROUP BY T6.\"ItemCode\" ) T7 ON T0.\"ItemCode\"=T7.\"ItemCode\"\n" +
                        "LEFT JOIN \"SBO_MINISO_COLOMBIA\".\"OWHS\" as T8 ON 1=1\n" +
                        "LEFT JOIN \"SBO_MINISO_COLOMBIA\".\"OCRD\" AS T9 ON T9.\"CardCode\" = T8.\"U_SYS_SONE\" \n" +
                        "LEFT JOIN \"SBO_MINISO_COLOMBIA\".\"ITM1\" AS T5 ON T0.\"ItemCode\" = T5.\"ItemCode\" AND T5.\"PriceList\" = T9.\"U_MNSO_IDLP_POS\"\n" +
                        "where \n" +
                        "T0.\"AvgPrice\" > 0\n" +
                        "--and T7.\"stock\" <> 0\n" +
                        "and T5.\"Price\">0\n" +
                        "AND T0.\"SellItem\" = 'Y'\n" +
                        "AND T0.\"validFor\" = 'Y'\n" +
                        "AND T0.\"frozenFor\"='N'\n" +
                        "and T0.\"ItmsGrpCod\" NOT IN('112','113','114','121')\n" +
                        "AND T0.\"U_SUBSUBFAMILIA\" IS NOT NULL\n" +
                        "AND T0.\"TaxCodeAR\" IS NOT NULL \n" +
                        "AND T0.\"ItemName\" IS NOT NULL\n" +
                        "AND T0.\"ItemName\" <> ''\n" +
                        "ORDER BY T0.\"ItemCode\"");
                resultSet.next();

                while (resultSet.next()){
                    ColTaxCodeEntity colTaxCodeEntity = new ColTaxCodeEntity();
                    colTaxCodeEntity.setUpc(resultSet.getString(1));
                    colTaxCodeEntity.setSku(resultSet.getString(2));
                    colTaxCodeEntity.setCode(resultSet.getString(3));

                    colTaxCodeRepository.save(colTaxCodeEntity);
                }

            } catch (SQLException e) {
                System.err.println("Query failed!");
            }
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

