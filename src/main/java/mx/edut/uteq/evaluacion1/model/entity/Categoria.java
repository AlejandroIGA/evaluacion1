package mx.edut.uteq.evaluacion1.model.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Categoria {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) 
private Long id; 
private String nombre;
private String categoria_anterior;
private String categoria_federal;
private String categoria_estatal;
    
}
