package main.java.com.formulario.backend_pais.service;

import com.exemplo.alunosbackend.exception.AlunoAlreadyExistsException;
import com.exemplo.alunosbackend.model.Aluno;
import com.exemplo.alunosbackend.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno cadastrarAluno(Aluno aluno) {
        if (alunoRepository.existsByEmail(aluno.getEmail())) {
            throw new AlunoAlreadyExistsException("Email já cadastrado");
        }
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    public void deletarAluno(Long id) {
        alunoRepository.deleteById(id);
    }
}