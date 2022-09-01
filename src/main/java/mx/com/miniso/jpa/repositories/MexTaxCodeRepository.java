package mx.com.miniso.jpa.repositories;

import mx.com.miniso.jpa.entities.MexTaxCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface MexTaxCodeRepository  extends JpaRepository<MexTaxCodeEntity, Integer > {

    ArrayList<MexTaxCodeEntity> findAll();

    MexTaxCodeEntity save(MexTaxCodeEntity mexTaxCodeEntity);
}
