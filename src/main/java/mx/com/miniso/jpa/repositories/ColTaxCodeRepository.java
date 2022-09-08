package mx.com.miniso.jpa.repositories;

import mx.com.miniso.jpa.entities.ChlTaxCodeEntity;
import mx.com.miniso.jpa.entities.ColTaxCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

public interface ColTaxCodeRepository  extends JpaRepository<ColTaxCodeEntity, Integer > {

    ArrayList<ColTaxCodeEntity> findAll();

    ArrayList<ColTaxCodeEntity> findAllByAomTaxIdIsNull();

    ColTaxCodeEntity save(ColTaxCodeEntity colTaxCodeEntity);

    @Transactional
    @Modifying
    @Query(value = "UPDATE ColTaxCodeEntity COL SET COL.aomTaxId = :aomTaxId  WHERE COL.code = :code ")
    void updateAomTaxId(@Param("aomTaxId") String aomTax, @Param("code") String code);


}
