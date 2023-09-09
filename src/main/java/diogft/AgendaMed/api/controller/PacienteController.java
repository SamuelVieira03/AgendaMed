package diogft.AgendaMed.api.controller;

import diogft.AgendaMed.api.mapper.PacienteMapper;
import diogft.AgendaMed.api.request.PacienteRequest;
import diogft.AgendaMed.api.response.PacienteResponse;
import diogft.AgendaMed.domain.entity.Paciente;
import diogft.AgendaMed.domain.service.PacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/paciente")
public class PacienteController {
    private final PacienteService service;
    private  final PacienteMapper mapper;

    @PostMapping
    public ResponseEntity<PacienteResponse> salvar (@Valid @RequestBody PacienteRequest request){
        Paciente paciente = mapper.toPaciente(request);
        Paciente pacienteSalvo = service.salvar(paciente);
        PacienteResponse pacienteResponse = mapper.toPacienteResponse(pacienteSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteResponse);
    }

    @GetMapping
        public ResponseEntity<List<PacienteResponse>> listarTodos(){
        List<Paciente>pacientes = service.listarTodos();
        List<PacienteResponse>pacienteResponses = mapper.toPacienteResponseList(pacientes);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteResponses);
    }


    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponse>buscarPorId(@PathVariable Long id){
        Optional<Paciente> optPaciente= service.buscarPorId(id);
        if (optPaciente.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toPacienteResponse((optPaciente.get())));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponse> alterar(@PathVariable Long id, @RequestBody PacienteRequest request) {
        Paciente paciente = mapper.toPaciente(request);
        Paciente pacienteSalvo = service.alterar(id, paciente);
        PacienteResponse pacienteResponse = mapper.toPacienteResponse(pacienteSalvo);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}