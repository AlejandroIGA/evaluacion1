package mx.edut.uteq.evaluacion1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.edut.uteq.evaluacion1.model.entity.Categoria;
import mx.edut.uteq.evaluacion1.model.entity.CategoriaRequisito;
import mx.edut.uteq.evaluacion1.model.entity.Tipo;
import mx.edut.uteq.evaluacion1.model.repository.CategoriaRepo;
import mx.edut.uteq.evaluacion1.model.repository.TipoRepo;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepo repo;

    @Autowired
    private TipoRepo tipoRepo;

    @GetMapping
    public List<Categoria> buscarTodos() {
        return repo.findAll();
    }

    // Insertar
    @PostMapping()
    public ResponseEntity<?> crear(@RequestBody Categoria c) {
        Categoria entity = repo.save(c);
        return ResponseEntity.ok(entity);
    }

    @PostMapping("/categoria-tipo")
    public ResponseEntity<?> agregarRequisitoACategoria(@RequestParam int idCategoria, @RequestParam int idTipo) {
    Optional<Categoria> categoriaOpt = repo.findById(idCategoria);
    Optional<Tipo> tipoOpt = tipoRepo.findById(idTipo);
    
        if (categoriaOpt.isEmpty() || tipoOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Categoría o tipo no encontrados");
        }

        Categoria entity = categoriaOpt.get();
        Tipo entityT = tipoOpt.get();

        CategoriaRequisito cr = new CategoriaRequisito();
        cr.setCategoria(entity);  
        cr.setTipo(entityT);            
        entity.getCategoriasTipo().add(cr);  

    return ResponseEntity.ok(repo.save(entity));
}

    // Editar
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable int id, @RequestBody Categoria c) {
        Optional<Categoria> opt = repo.findById(id);
        if (opt.isPresent()) {
            Categoria entity = opt.get();
            entity.setNombre(c.getNombre());
            entity.setCategoria_anterior(c.getCategoria_anterior());
            entity.setCategoria_federal(c.getCategoria_federal());
            entity.setCategoria_estatal(c.getCategoria_estatal());
            return ResponseEntity.ok(repo.save(entity));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        Optional<Categoria> opt = repo.findById(id);
        if (opt.isPresent()) {
            repo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
