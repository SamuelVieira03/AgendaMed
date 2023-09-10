package diogft.AgendaMed.api.mapper;

import diogft.AgendaMed.api.request.PacienteRequest;
import diogft.AgendaMed.api.response.PacienteCompletoResponse;
import diogft.AgendaMed.api.response.PacienteResponse;
import diogft.AgendaMed.domain.entity.Paciente;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PacienteMapper {

    private final ModelMapper mapper;

    public Paciente toPaciente(PacienteRequest request) {
        return mapper.map(request, Paciente.class);
    }

    public PacienteResponse toPacienteResponse(Paciente paciente) {
        return mapper.map(paciente, PacienteResponse.class);
    }

    public PacienteCompletoResponse toPacienteCompletoResponse(Paciente paciente) {
        return mapper.map(paciente, PacienteCompletoResponse.class);
    }

    public List<PacienteResponse> toPacienteResponseList(List<Paciente> pacientes) {
        return pacientes.stream()
                .map(this::toPacienteResponse)
                .collect(Collectors.toList());
    }
}