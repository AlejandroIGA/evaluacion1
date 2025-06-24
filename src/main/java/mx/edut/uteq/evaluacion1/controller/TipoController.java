package mx.edut.uteq.evaluacion1.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edut.uteq.evaluacion1.model.entity.Tipo;
import mx.edut.uteq.evaluacion1.model.repository.TipoRepo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/api/tipos")
public class TipoController {
    @Autowired
    private TipoRepo tipoRepo;

    @GetMapping
    public List<Tipo> getTipos() {
        return tipoRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTipo(@PathVariable int id) {
        Optional<Tipo> opt = tipoRepo.findById(id);
        if(opt.isPresent()){
            return ResponseEntity.ok(opt.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Tipo tipo) {
        return ResponseEntity.ok(tipoRepo.save(tipo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Tipo tipo) {
        Optional<Tipo> opt = tipoRepo.findById(id);
        if(opt.isPresent()){
            Tipo t = opt.get();
            t.setNombre(tipo.getNombre());
            return ResponseEntity.ok(tipoRepo.save(t));
        }        
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        Optional<Tipo> opt = tipoRepo.findById(id);
        if(opt.isPresent()){
            tipoRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }
    
    
}
