package mx.com.miniso.jpa.repositories;

import mx.com.miniso.jpa.entities.MfrTaxCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface MfrTaxCodeRepository  extends JpaRepository<MfrTaxCodeEntity, Integer > {

    ArrayList<MfrTaxCodeEntity> findAll();

    MfrTaxCodeEntity save(MfrTaxCodeEntity mfrTaxCodeEntity);
}
