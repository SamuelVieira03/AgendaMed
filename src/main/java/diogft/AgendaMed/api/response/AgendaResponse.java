package diogft.AgendaMed.api.response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

/*AQUI SÃO AS RESPOSTAS QUE AS REQUISIÇÕES PEDEM NO CADASTRO
* */
public class AgendaResponse {

    private Long id;
    private String descricao;
    private LocalDateTime horario;
    private  LocalDateTime dataCriacao;
    private PacienteResponse paciente;


    }
