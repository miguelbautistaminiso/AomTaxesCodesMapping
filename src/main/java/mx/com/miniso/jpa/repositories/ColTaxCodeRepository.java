package mx.com.miniso.jpa.repositories;

import mx.com.miniso.jpa.entities.ColTaxCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ColTaxCodeRepository  extends JpaRepository<ColTaxCodeEntity, Integer > {

    ArrayList<ColTaxCodeEntity> findAll();

    ColTaxCodeEntity save(ColTaxCodeEntity colTaxCodeEntity);

}
