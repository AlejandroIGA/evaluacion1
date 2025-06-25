package mx.edut.uteq.evaluacion1.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo")
    @JsonIgnoreProperties(value = "tipo")
    private List<Requisito> requisitos;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_categoria")
    private List<CategoriaRequisito> categorias;
}
