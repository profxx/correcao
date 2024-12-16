package br.com.senai.prova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.prova.entity.Curso;
import br.com.senai.prova.repository.CursoRepository;

@Service
public class CursoService {
    
    @Autowired
    private CursoRepository cursoRepository;

    // Listar cursos
    public List<Curso> findAll(){
        return cursoRepository.findAll();
    }

    // Mostrar um curso pelo ID
    public Curso findById(Long id){
        return cursoRepository.findById(id).orElse(null);
    }

    // Cadastrar novo curso
    public Curso insertNew(Curso curso){
        return cursoRepository.save(curso);
    }

    // Deletar curso
    public Boolean deleteById(Long id){
        Curso curso = findById(id);
        if (curso == null){
            return false;
        }else{
            cursoRepository.deleteById(id);
            return true;
        }
    }
}
