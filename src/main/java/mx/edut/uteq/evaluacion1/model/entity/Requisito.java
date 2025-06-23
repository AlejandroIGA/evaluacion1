package mx.edut.uteq.evaluacion1.model.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class Requisito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int id_tipo;
    private String requisito;

    @ManyToOne
    @JoinColumn (name = "id_tipo")
    private Tipo tipo;
}
