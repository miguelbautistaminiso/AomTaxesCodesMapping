package mx.com.miniso.jpa.repositories;

import mx.com.miniso.jpa.entities.ColTaxCodeEntity;
import mx.com.miniso.jpa.entities.MexTaxCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

public interface MexTaxCodeRepository  extends JpaRepository<MexTaxCodeEntity, Integer > {

    ArrayList<MexTaxCodeEntity> findAll();

    MexTaxCodeEntity save(MexTaxCodeEntity mexTaxCodeEntity);

    ArrayList<MexTaxCodeEntity> findAllByAomTaxIdIsNull();

    @Transactional
    @Modifying
    @Query(value = "UPDATE MexTaxCodeEntity MEX SET MEX.aomTaxId = :aomTaxId  WHERE MEX.code = :code ")
    void updateAomTaxId(@Param("aomTaxId") String aomTax, @Param("code") String code);

}
