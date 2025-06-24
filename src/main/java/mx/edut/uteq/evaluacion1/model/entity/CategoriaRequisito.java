package mx.edut.uteq.evaluacion1.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class CategoriaRequisito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_categoria", unique = true)
    private int categoriaId;
    
    @Column(name = "id_requisito", nullable = false)
    private int requisitoId;
}
