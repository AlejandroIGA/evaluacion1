package mx.edut.uteq.evaluacion1.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.edut.uteq.evaluacion1.model.entity.Requisito;

public interface RequisitoRepo extends JpaRepository <Requisito, Integer> {
    
}
