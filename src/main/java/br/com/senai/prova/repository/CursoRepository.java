package br.com.senai.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.prova.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{
    
}
