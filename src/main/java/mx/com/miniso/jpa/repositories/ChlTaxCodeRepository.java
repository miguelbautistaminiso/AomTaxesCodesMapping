package mx.com.miniso.jpa.repositories;

import mx.com.miniso.jpa.entities.ChlTaxCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ChlTaxCodeRepository extends JpaRepository<ChlTaxCodeEntity, Integer> {

    ArrayList<ChlTaxCodeEntity> findAll();

    ChlTaxCodeEntity save(ChlTaxCodeEntity chlTaxCodeEntity);
}
