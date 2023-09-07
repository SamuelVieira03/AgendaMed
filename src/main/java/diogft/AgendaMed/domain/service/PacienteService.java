package diogft.AgendaMed.domain.service;

import diogft.AgendaMed.domain.entity.Paciente;
import diogft.AgendaMed.domain.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
@RequiredArgsConstructor
public class PacienteService {

    private PacienteRepository repository;
    public Paciente salvar(Paciente paciente){
      return repository.save(paciente);
    }


    public List<Paciente> listarTodos(){
        return repository.findAll();
    }

    public Optional<Paciente> buscaPorId(Long id){
        return repository.findById(id);
    }

    public void deletar(Long id){
        repository.deleteById(id);
}
}