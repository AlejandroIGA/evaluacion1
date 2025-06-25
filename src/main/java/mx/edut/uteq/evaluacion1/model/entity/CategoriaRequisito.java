package mx.edut.uteq.evaluacion1.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Entity
@Data
public class CategoriaRequisito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    @JsonBackReference
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_tipo", nullable = false)
    private Tipo tipo;
}
