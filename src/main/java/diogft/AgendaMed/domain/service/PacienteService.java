package diogft.AgendaMed.domain.service;

import diogft.AgendaMed.domain.entity.Paciente;
import diogft.AgendaMed.domain.repository.PacienteRepository;
import diogft.AgendaMed.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
@Service
@Transactional
@RequiredArgsConstructor
public class PacienteService {
    private final PacienteRepository repository;
    public Paciente salvar(Paciente paciente){
        boolean existeCpf=false;

        Optional<Paciente> optPaciente =repository.findByCpf(paciente.getCpf());
              if(optPaciente.isPresent()){
                  if(optPaciente.get().getId().equals(paciente.getId())){
                      existeCpf= true;
                  }
              }

              if(existeCpf){
                  throw new BusinessException("Cpf ja cadastrado.");
              }

        return repository.save(paciente);
    }
    public Paciente alterar(Long id, Paciente paciente) {
        Optional<Paciente> optPaciente = this.buscarPorId(id);

        if (optPaciente.isEmpty()) {
            throw new BusinessException("Paciente não cadastrado!");
        }

        paciente.setId(id);

        return salvar(paciente);
    }

    public List<Paciente> listarTodos() {
        return repository.findAll();
    }

    public Optional<Paciente> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

}