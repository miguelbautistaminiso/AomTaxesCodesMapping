package mx.com.miniso.jpa.repositories;

import mx.com.miniso.jpa.entities.TaxesGroupsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface TaxesGroupsRepository extends JpaRepository <TaxesGroupsEntity, Integer> {

    ArrayList<TaxesGroupsEntity> findAll();



}
