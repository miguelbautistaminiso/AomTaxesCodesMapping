package mx.com.miniso.domain.impl;

import mx.com.miniso.domain.AomTaxesCodesIntegration;
import mx.com.miniso.domain.GetCountriesUPCS;
import mx.com.miniso.domain.UpdateTaxesCodes;
import mx.com.miniso.jpa.repositories.SkusRepository;
import mx.com.miniso.jpa.repositories.TaxesRepository;
import mx.com.miniso.jpa.repositories.UpcsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.logging.Logger;

import com.sap.db.jdbc.Driver;

@Component(value = "aomTaxesCodesIntegration")
public class AomTaxesCodesIntegrationImpl implements AomTaxesCodesIntegration {

    protected Logger log = Logger.getLogger(AomTaxesCodesIntegrationImpl.class.getName());

    @Autowired
    private UpcsRepository upcsRepository;

    @Autowired
    private GetCountriesUPCS getCountriesUPCS;

    @Autowired
    private TaxesRepository taxesRepository;

    @Autowired
    private UpdateTaxesCodes updateTaxesCodes;

    @Override
    public void exec() {


        log.info("**************************");
        log.info("Borrando registros del proceso anterior");
        log.info("**************************");
        upcsRepository.SP_DELETE_UPCS();

        log.info("**************************");
        log.info("Obteniendo UPCS de Mexico");
        log.info("**************************");
        getCountriesUPCS.getUpcs();

        log.info("**************************");
        log.info("Cargando Taxes");
        log.info("**************************");
        taxesRepository.SP_INSERT_TAXES();

        log.info("**************************");
        log.info("Actualizando AOM taxes por pais");
        log.info("**************************");
        updateTaxesCodes.updateAomId();

        log.info("**************************");
        log.info("Actualizando AOM taxes por pais");
        log.info("**************************");
        taxesRepository.SP_MERGE_AOM_TAX_ID();

        log.info("**************************");
        log.info("Actualizando AOM taxes por pais");
        log.info("**************************");
        upcsRepository.SP_INSERT_UPCS();

        log.info("**************************");
        log.info("Actualizando Id de grupo de impuestos");
        log.info("**************************");
        updateTaxesCodes.updateTaxesGroupsId();
        
        log.info("**************************");
        log.info("Validando");
        log.info("**************************");
        updateTaxesCodes.validateAomTaxesCodes();



    }

    private void conHana(){

        Connection connection = null;
        try

        {
            connection = DriverManager.getConnection(
                    "jdbc:sap://10.35.242.174:30015/?autocommit=false", "MNSO_READER_012", "Mi123456*");
        } catch(
                SQLException e)

        {
            System.err.println("Connection Failed:");
            System.err.println(e);
            return;
        }
        if(connection !=null)

        {
            try {
                System.out.println("Connection to HANA successful!");
                Statement stmt = connection.createStatement();
                ResultSet resultSet = stmt.executeQuery("\n" +
                        "SELECT * FROM SBOMINISO.OITM  LIMIT 10");
                resultSet.next();
                String hello = resultSet.getString(1);
                System.out.println(hello);
            } catch (SQLException e) {
                System.err.println("Query failed!");
            }
        }

    }
}
