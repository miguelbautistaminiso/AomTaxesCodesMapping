package mx.com.miniso.jpa.repositories;

import mx.com.miniso.jpa.entities.UpcsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

public interface UpcsRepository  extends JpaRepository<UpcsEntity, Integer > {

    @Procedure
    void  SP_DELETE_UPCS();

    @Procedure
    void  SP_TEST();

    @Procedure
    void  SP_INSERT_UPCS();

    ArrayList<UpcsEntity> findAll();


    @Transactional
    @Modifying
    @Query(value = "UPDATE UpcsEntity up SET up.taxGroupId = :taxGroupId  WHERE up.taxGroup = :taxGroup ")
    void updateTaxGroupId(@Param("taxGroupId") int taxGroupId, @Param("taxGroup") String taxGroup);

}
