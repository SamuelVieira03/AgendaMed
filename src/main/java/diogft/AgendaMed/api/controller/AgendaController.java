package diogft.AgendaMed.api.controller;

import diogft.AgendaMed.api.request.AgendaRequest;
import diogft.AgendaMed.api.response.AgendaResponse;
import diogft.AgendaMed.domain.service.AgendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/agenda")
public class AgendaController {
    private final AgendaService service;

    @GetMapping
    public ResponseEntity<List<AgendaResponse>> buscarTodos(){

    }
    @GetMapping("/{id}")
    public ResponseEntity<AgendaResponse> buscarPorId(@PathVariable Long id){

    }

    @PostMapping
    public ResponseEntity<AgendaResponse> salvar (@RequestBody AgendaRequest request){}

}
