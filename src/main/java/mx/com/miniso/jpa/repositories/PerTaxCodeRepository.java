package mx.com.miniso.jpa.repositories;

import mx.com.miniso.jpa.entities.PerTaxCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

public interface PerTaxCodeRepository  extends JpaRepository<PerTaxCodeEntity, Integer > {

    ArrayList<PerTaxCodeEntity> findAll();

    PerTaxCodeEntity save(PerTaxCodeEntity perTaxCodeEntity);


    @Transactional
    @Modifying
    @Query(value = "UPDATE PerTaxCodeEntity PER SET PER.aomTaxId = :aomTaxId  WHERE PER.code = :code ")
    void updateAomTaxId(@Param("aomTaxId") String aomTax, @Param("code") String code);

}
