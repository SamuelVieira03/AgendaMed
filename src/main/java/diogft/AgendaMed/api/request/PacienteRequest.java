package diogft.AgendaMed.api.request;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
/*REQUISIÇÃO DA CLASSE PACIENTE E OS ATRIBUTOS NECESSÁRIOS.
* */
public class PacienteRequest {

    @NotBlank(message = "Nome do paciente é obritagtório!")
    private String nome;

    @NotBlank(message = "Nome do paciente é obritagtório!")

    private String sobrenome;
    private String email;
    @NotBlank(message = "CPF do paciente é obritagtório!")

    private String cpf;
}
