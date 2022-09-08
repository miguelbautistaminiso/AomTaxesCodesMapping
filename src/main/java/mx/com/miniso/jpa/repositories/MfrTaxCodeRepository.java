package mx.com.miniso.jpa.repositories;

import mx.com.miniso.jpa.entities.MexTaxCodeEntity;
import mx.com.miniso.jpa.entities.MfrTaxCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

public interface MfrTaxCodeRepository  extends JpaRepository<MfrTaxCodeEntity, Integer > {

    ArrayList<MfrTaxCodeEntity> findAll();

    MfrTaxCodeEntity save(MfrTaxCodeEntity mfrTaxCodeEntity);


    ArrayList<MfrTaxCodeEntity> findAllByAomTaxIdIsNull();


    @Transactional
    @Modifying
    @Query(value = "UPDATE MfrTaxCodeEntity MFR SET MFR.aomTaxId = :aomTaxId  WHERE MFR.code = :code ")
    void updateAomTaxId(@Param("aomTaxId") String aomTax, @Param("code") String code);

}
