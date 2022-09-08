package mx.com.miniso.jpa.hana;

import mx.com.miniso.jpa.entities.MfrTaxCodeEntity;
import mx.com.miniso.jpa.repositories.MfrTaxCodeRepository;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.logging.Logger;

@Component(value = "hanaDbMfr")
public class HanaDbMfr  implements InitializingBean, DisposableBean {
    protected Logger log = Logger.getLogger(HanaDbMfr.class.getName());

    private Connection connection;

    @Autowired
    private MfrTaxCodeRepository mfrTaxCodeRepository;

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

    public void getMfrUpcs() {

        if(connection !=null)

        {
            try {
                System.out.println("Connection to HANA successful!");
                Statement stmt = connection.createStatement();
                ResultSet resultSet = stmt.executeQuery("SELECT \n" +
                        "DISTINCT (T4.\"BcdCode\") AS \"UPC\",\n" +
                        "T0.\"ItemCode\" AS \"SKU\", \n" +
                        "\"U_SYS_CIMP\" AS \"TaxGroup2\"\n" +
                        "FROM SBOMINISO.OITM T0\n" +
                        "LEFT JOIN SBOMINISO.\"@SUBFAMILIA\" AS T1 ON T0.\"U_SUBFAMILIA\" = T1.\"Name\"\n" +
                        "LEFT JOIN SBOMINISO.\"@SUBSUBFAMILIA\" AS T2 ON T0.\"U_SUBSUBFAMILIA\" = T2.\"Name\"\n" +
                        "LEFT JOIN SBOMINISO.OITB AS T3 ON T0.\"ItmsGrpCod\" = T3.\"ItmsGrpCod\"\n" +
                        "RIGHT JOIN SBOMINISO.OBCD AS T4 ON T0.\"ItemCode\" = T4.\"ItemCode\"\n" +
                        "LEFT JOIN (SELECT T6.\"ItemCode\" , SUM(T6.\"OnHand\"-T6.\"IsCommited\") AS \"stock\" FROM \"SBOMINISO\".\"OITW\"  T6  GROUP BY T6.\"ItemCode\" ) T7 ON T0.\"ItemCode\"=T7.\"ItemCode\"\n" +
                        "LEFT JOIN \"SBOMINISO\".\"OWHS\" as T8 ON 1 = 1\n" +
                        "LEFT JOIN \"SBOMINISO\".\"OCRD\" AS T9 ON T9.\"CardCode\" = T8.\"U_SYS_SONE\" \n" +
                        "LEFT JOIN \"SBOMINISO\".\"ITM1\" AS T5 ON T0.\"ItemCode\" = T5.\"ItemCode\" AND T5.\"PriceList\" = T9.\"U_MNSO_IDLP_POS\"\n" +
                        "INNER JOIN \"SBOMINISO\".\"ONCM\" AS T10 ON T0.\"NCMCode\" = T10.\"AbsEntry\" \n" +
                        "where \n" +
                        "T0.\"AvgPrice\" > 0\n" +
                        "--and T7.\"stock\" <> 0\n" +
                        "and T5.\"Price\">0\n" +
                        "AND T0.\"SellItem\" = 'Y'\n" +
                        "AND T0.\"validFor\" = 'Y'\n" +
                        "AND T0.\"frozenFor\"='N'\n" +
                        "AND T3.\"ItmsGrpNam\" <> 'OPEX'\n" +
                        "AND T3.\"ItmsGrpNam\" <> 'CAPEX'\n" +
                        "AND T3.\"ItmsGrpNam\" <> 'MUEBLES'\n" +
                        "AND T3.\"ItmsGrpNam\" <> 'INSUMOS'\n" +
                        "AND T0.\"U_SUBSUBFAMILIA\" IS NOT NULL\n" +
                        "AND T0.\"U_SYS_CIMP\" IS NOT NULL \n" +
                        "AND T0.\"ItemName\" IS NOT NULL\n" +
                        "AND T0.\"ItemName\" <> ''\n" +
                        "ORDER BY T0.\"ItemCode\" ");
                resultSet.next();

                while (resultSet.next()){
                    MfrTaxCodeEntity mfrTaxCodeEntity = new MfrTaxCodeEntity();
                    mfrTaxCodeEntity.setUpc(resultSet.getString(1));
                    mfrTaxCodeEntity.setSku(resultSet.getString(2));
                    mfrTaxCodeEntity.setCode(resultSet.getString(3));

                    mfrTaxCodeRepository.save(mfrTaxCodeEntity);
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
