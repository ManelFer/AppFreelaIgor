package main.java.com.formulario.backend_pais.service;

import com.exemplo.alunosbackend.dto.AlunoRequestDTO;
import com.exemplo.alunosbackend.dto.AlunoResponseDTO;
import com.exemplo.alunosbackend.exception.ResourceNotFoundException;
import com.exemplo.alunosbackend.model.Aluno;
import com.exemplo.alunosbackend.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<AlunoResponseDTO> listarTodos() {
        return alunoRepository.findAll().stream()
                .map(AlunoResponseDTO::new)
                .collect(Collectors.toList());
    }

    public AlunoResponseDTO buscarPorId(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado com id: " + id));
        return new AlunoResponseDTO(aluno);
    }

    public AlunoResponseDTO criarAluno(AlunoRequestDTO alunoDTO) {
        Aluno aluno = new Aluno(
                alunoDTO.getNome(),
                alunoDTO.getSobrenome(),
                alunoDTO.getEmail(),
                alunoDTO.getIdade(),
                alunoDTO.getEndereco()
        );
        Aluno alunoSalvo = alunoRepository.save(aluno);
        return new AlunoResponseDTO(alunoSalvo);
    }

    public AlunoResponseDTO atualizarAluno(Long id, AlunoRequestDTO alunoDTO) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado com id: " + id));
        
        aluno.setNome(alunoDTO.getNome());
        aluno.setSobrenome(alunoDTO.getSobrenome());
        aluno.setEmail(alunoDTO.getEmail());
        aluno.setIdade(alunoDTO.getIdade());
        aluno.setEndereco(alunoDTO.getEndereco());
        
        Aluno alunoAtualizado = alunoRepository.save(aluno);
        return new AlunoResponseDTO(alunoAtualizado);
    }

    public void deletarAluno(Long id) {
        if (!alunoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Aluno não encontrado com id: " + id);
        }
        alunoRepository.deleteById(id);
    }
    
    // Métodos adicionais de busca
    public List<AlunoResponseDTO> buscarPorNome(String nome) {
        return alunoRepository.findByNomeContainingIgnoreCase(nome).stream()
                .map(AlunoResponseDTO::new)
                .collect(Collectors.toList());
    }
    
    // Implementar outros métodos de busca conforme necessário
}