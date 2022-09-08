package mx.com.miniso.jpa.repositories;

import mx.com.miniso.jpa.entities.TaxesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

public interface TaxesRepository extends JpaRepository <TaxesEntity, Integer> {

    @Procedure
    void  SP_INSERT_TAXES();

    @Procedure
    void  SP_MERGE_AOM_TAX_ID();

    TaxesEntity save(TaxesEntity taxesEntity);

    //CHIlE

    @Transactional
    @Modifying
    @Query(value = "UPDATE TaxesEntity tax SET tax.chlIva19 = :aomTax  WHERE tax.upc = :upc ")
    void updateChlIva19(@Param("aomTax") String aomTax, @Param("upc") String upc);

    @Transactional
    @Modifying
    @Query(value = "UPDATE TaxesEntity tax SET tax.chlIva19 = :aomTax  WHERE tax.upc = :upc ")
    void updateChlIva0(@Param("aomTax") String aomTax, @Param("upc") String upc);

    //COLOMBIA

    @Transactional
    @Modifying
    @Query(value = "UPDATE TaxesEntity tax SET tax.colIvag0119 = :aomTax  WHERE tax.upc = :upc ")
    void updateColIvag0119(@Param("aomTax") String aomTax, @Param("upc") String upc);

    @Transactional
    @Modifying
    @Query(value = "UPDATE TaxesEntity tax SET tax.colIvaexe0 = :aomTax  WHERE tax.upc = :upc ")
    void updateColIvaexe0(@Param("aomTax") String aomTax, @Param("upc") String upc);

    @Transactional
    @Modifying
    @Query(value = "UPDATE TaxesEntity tax SET tax.colIvaexc0 = :aomTax  WHERE tax.upc = :upc ")
    void updateColIvaexc0(@Param("aomTax") String aomTax, @Param("upc") String upc);

    @Transactional
    @Modifying
    @Query(value = "UPDATE TaxesEntity tax SET tax.colImpocon9 = :aomTax  WHERE tax.upc = :upc ")
    void updateColImpocon9(@Param("aomTax") String aomTax, @Param("upc") String upc);

    @Transactional
    @Modifying
    @Query(value = "UPDATE TaxesEntity tax SET tax.colImpocon00 = :aomTax  WHERE tax.upc = :upc ")
    void updateColImpocon00(@Param("aomTax") String aomTax, @Param("upc") String upc);

    //MEXICO

    @Transactional
    @Modifying
    @Query(value = "UPDATE TaxesEntity tax SET tax.mexV1616 = :aomTax  WHERE tax.upc = :upc ")
    void updateMexV1616(@Param("aomTax") String aomTax, @Param("upc") String upc);

    @Transactional
    @Modifying
    @Query(value = "UPDATE TaxesEntity tax SET tax.mexV00 = :aomTax  WHERE tax.upc = :upc ")
    void updateMexV00(@Param("aomTax") String aomTax, @Param("upc") String upc);

    @Transactional
    @Modifying
    @Query(value = "UPDATE TaxesEntity tax SET tax.mexV0188 = :aomTax  WHERE tax.upc = :upc ")
    void updateMexV0188(@Param("aomTax") String aomTax, @Param("upc") String upc);

    @Transactional
    @Modifying
    @Query(value = "UPDATE TaxesEntity tax SET tax.mexV16I8168 = :aomTax  WHERE tax.upc = :upc ")
    void updateMexV16I8168(@Param("aomTax") String aomTax, @Param("upc") String upc);


    //MEXICO FRONTERA

    @Transactional
    @Modifying
    @Query(value = "UPDATE TaxesEntity tax SET tax.mfrV168 = :aomTax  WHERE tax.upc = :upc ")
    void updateMfrV168(@Param("aomTax") String aomTax, @Param("upc") String upc);

    @Transactional
    @Modifying
    @Query(value = "UPDATE TaxesEntity tax SET tax.mfrV00 = :aomTax  WHERE tax.upc = :upc ")
    void updateMfrV00(@Param("aomTax") String aomTax, @Param("upc") String upc);

    @Transactional
    @Modifying
    @Query(value = "UPDATE TaxesEntity tax SET tax.mfrV0I88 = :aomTax  WHERE tax.upc = :upc ")
    void updateMfrV0I88(@Param("aomTax") String aomTax, @Param("upc") String upc);

    @Transactional
    @Modifying
    @Query(value = "UPDATE TaxesEntity tax SET tax.mfrV16I888 = :aomTax  WHERE tax.upc = :upc ")
    void updateMfrV16I888(@Param("aomTax") String aomTax, @Param("upc") String upc);


    //PERU

    @Transactional
    @Modifying
    @Query(value = "UPDATE TaxesEntity tax SET tax.perIgv18 = :aomTax  WHERE tax.upc = :upc ")
    void updatePerIgv18(@Param("aomTax") String aomTax, @Param("upc") String upc);

    @Transactional
    @Modifying
    @Query(value = "UPDATE TaxesEntity tax SET tax.perIgv00 = :aomTax  WHERE tax.upc = :upc ")
    void updatePerIgv00(@Param("aomTax") String aomTax, @Param("upc") String upc);

    @Transactional
    @Modifying
    @Query(value = "UPDATE TaxesEntity tax SET tax.perIgvIcbper18 = :aomTax  WHERE tax.upc = :upc ")
    void updatePerIgvIcbper18(@Param("aomTax") String aomTax, @Param("upc") String upc);

}
