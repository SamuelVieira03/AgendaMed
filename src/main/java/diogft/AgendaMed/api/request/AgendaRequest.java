package diogft.AgendaMed.api.request;

import lombok.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

/*MODELO DE REQUISIÇÃO NECESSÁRIA DA AGENDA
COM NOTNULL PARA NUMEROS E NOTBLANK PARA STRINGS
FUTURE PARA NÃO TER A POSSIBILIDADE DE USAR DATAS PASSADAS.
* */
public class AgendaRequest {

    @NotBlank
    private String descricao;

    @NotNull
    @Future
    @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mn:ss")
    private LocalDateTime horario;

    @NotNull
    private Long pacienteId;
}
