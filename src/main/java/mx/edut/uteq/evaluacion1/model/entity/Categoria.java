package mx.edut.uteq.evaluacion1.model.entity;

import java.util.List;

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
public class Categoria {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) 
private int id; 
private String nombre;
private String categoria_anterior;
private String categoria_federal;
private String categoria_estatal;

@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_categoria")
    private List<CategoriaRequisito> categoriasTipo;
}
