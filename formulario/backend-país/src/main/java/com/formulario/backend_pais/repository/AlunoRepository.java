package main.java.com.formulario.backend_pais.repository;

import main.java.com.formulario.backend_pais.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByNomeContainingIgnoreCase(String nome);
    List<Aluno> findBySobrenomeContainingIgnoreCase(String sobrenome);
    List<Aluno> findByEmailContainingIgnoreCase(String email);
    List<Aluno> findByIdade(int idade);
    List<Aluno> findByEnderecoContainingIgnoreCase(String endereco);
}