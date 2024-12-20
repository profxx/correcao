package br.com.senai.prova.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.prova.entity.Curso;
import br.com.senai.prova.service.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoContoller {
    
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> findAll(){
        List<Curso> cursos = cursoService.findAll();
        return ResponseEntity.ok().body(cursos);
    }

    @PostMapping
    public ResponseEntity<Curso> insertNew(@RequestBody Curso cursoInserido){
        Curso curso = cursoService.insertNew(cursoInserido);
        return ResponseEntity.ok().body(curso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        Boolean flag = cursoService.deleteById(id);
        return ResponseEntity.ok().body(flag);
    }

}
