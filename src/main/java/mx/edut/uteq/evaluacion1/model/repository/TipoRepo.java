package mx.edut.uteq.evaluacion1.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.edut.uteq.evaluacion1.model.entity.Tipo;

public interface TipoRepo extends JpaRepository<Tipo, Integer>{
    
}
