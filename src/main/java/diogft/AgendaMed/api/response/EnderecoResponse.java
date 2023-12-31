package diogft.AgendaMed.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor

    /*RESPOSTA DAS REQUISIÇÕES DE ENDEREÇO
    * */
    public class EnderecoResponse {

        private Long id;
        private String rua;
        private Long numero;
        private String complemento;
        private String bairro;
    }

