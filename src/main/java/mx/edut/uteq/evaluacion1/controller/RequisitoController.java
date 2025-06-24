package mx.edut.uteq.evaluacion1.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.edut.uteq.evaluacion1.model.entity.Requisito;
import mx.edut.uteq.evaluacion1.model.entity.Tipo;
import mx.edut.uteq.evaluacion1.model.repository.RequisitoRepo;
import mx.edut.uteq.evaluacion1.model.repository.TipoRepo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/api/requisitos")
public class RequisitoController {
    @Autowired
    private RequisitoRepo requisitoRepo;

    @Autowired
    private TipoRepo tipoRepo;

    @GetMapping()
    public List<Requisito> getRequisitos() {
        return requisitoRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRequisito(@PathVariable int id){
        Optional <Requisito> opt = requisitoRepo.findById(id);
        if(opt.isPresent()){
            Requisito requisito = opt.get();
            return ResponseEntity.ok(requisito);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> create(@RequestBody Requisito requisito, @PathVariable int id) {
        Optional<Tipo> opt = tipoRepo.findById(id);
        if(opt.isPresent()){
            Tipo t = opt.get();
            requisito.setTipo(t);
            return ResponseEntity.ok(requisitoRepo.save(requisito));
        }       
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable int id,@RequestBody Requisito requisito ) {
        Optional<Requisito> opt = requisitoRepo.findById(id);
        if(opt.isPresent()){
            Requisito r = opt.get();
            Optional<Tipo> tipoOpt = tipoRepo.findById(r.getTipo().getId());
            if(tipoOpt.isPresent()){
                Tipo t = tipoOpt.get();
                r.setDescripcion(requisito.getDescripcion());
                r.setTipo(t);
                return ResponseEntity.ok(requisitoRepo.save(r));
            }
        }       
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        Optional<Requisito> opt = requisitoRepo.findById(id);
        if(opt.isPresent()){
            requisitoRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }
    
    
}
