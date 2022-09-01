package mx.com.miniso.jpa.repositories;

import mx.com.miniso.jpa.entities.CountriesTaxesCodesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface CountriesTaxesCodesRepository extends JpaRepository<CountriesTaxesCodesEntity, Integer> {

    ArrayList<CountriesTaxesCodesEntity> findAllByCountry(String country);

}
