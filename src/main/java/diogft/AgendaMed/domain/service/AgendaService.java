package diogft.AgendaMed.domain.service;

import diogft.AgendaMed.domain.entity.Agenda;
import diogft.AgendaMed.domain.entity.Paciente;
import diogft.AgendaMed.domain.repository.AgendaRepository;
import diogft.AgendaMed.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AgendaService {
    private final AgendaRepository repository;
    private final PacienteService pacienteService;
    public List<Agenda> listarTodos(){
        return repository.findAll();
    }
    public Optional <Agenda> buscarPorId(Long id){
    return repository.findById(id);
    }

    public Agenda salvar(Agenda agenda){
        Optional<Paciente> optPaciente = pacienteService.buscarPorId(agenda.getPaciente().getId());
        if(optPaciente.isEmpty()){
            throw new BusinessException("Paciente não encontrado!");
        }

       Optional<Agenda>optHorario= repository.findByHorario(agenda.getHorario());
        if(optHorario.isPresent()){
            throw new BusinessException("Já existe agendamento pra esse horario!");

        }
        agenda.setPaciente(optPaciente.get());
        agenda.setDataCriacao(LocalDateTime.now());

        return repository.save(agenda);
    }

}
