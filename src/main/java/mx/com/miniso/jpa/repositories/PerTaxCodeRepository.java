package mx.com.miniso.jpa.repositories;

import mx.com.miniso.jpa.entities.PerTaxCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface PerTaxCodeRepository  extends JpaRepository<PerTaxCodeEntity, Integer > {

    ArrayList<PerTaxCodeEntity> findAll();

    PerTaxCodeEntity save(PerTaxCodeEntity perTaxCodeEntity);
}
