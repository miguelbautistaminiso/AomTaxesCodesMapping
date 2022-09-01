package mx.com.miniso.jpa.repositories;

import mx.com.miniso.jpa.entities.SkusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.ArrayList;

public interface SkusRepository extends JpaRepository<SkusEntity, Integer > {

    @Procedure
    void  SP_DELETE_SKUS();

    @Procedure
    void  SP_TEST();


    ArrayList<SkusEntity> findAll();


}
