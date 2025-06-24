package mx.edut.uteq.evaluacion1.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class CategoriaRequisito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_categoria", unique = true)
    private int categoriaId;
    @Column(name = "id_requisito", unique = true)
    private int requisitoId;
    
}
