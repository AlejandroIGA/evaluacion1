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
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo")
    private List<Requisito> requisitos;

    @OneToMany
    @JoinColumn(name = "id_requisito")
    private List<Tipo> tipos;
}
