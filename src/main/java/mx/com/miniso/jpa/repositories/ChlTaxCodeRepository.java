package mx.com.miniso.jpa.repositories;

import mx.com.miniso.jpa.entities.ChlTaxCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

public interface ChlTaxCodeRepository extends JpaRepository<ChlTaxCodeEntity, Integer> {

    ArrayList<ChlTaxCodeEntity> findAll();

    ChlTaxCodeEntity save(ChlTaxCodeEntity chlTaxCodeEntity);

    @Transactional
    @Modifying
    @Query(value = "UPDATE ChlTaxCodeEntity CHL SET CHL.aomTaxId = :aomTaxId  WHERE CHL.code = :code ")
    void updateAomTaxId(@Param("aomTaxId") String aomTax, @Param("code") String code);

}
