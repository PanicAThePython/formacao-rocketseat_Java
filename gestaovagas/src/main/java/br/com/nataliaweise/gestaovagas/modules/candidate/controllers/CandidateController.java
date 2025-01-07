package br.com.nataliaweise.gestaovagas.modules.candidate.controllers;
import br.com.nataliaweise.gestaovagas.modules.candidate.CandidateEntity;
import br.com.nataliaweise.gestaovagas.modules.candidate.useCases.CreateCandidateUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //define que é um arquivo de rotas
@RequestMapping("/candidate") //define caminho inicial
public class CandidateController {

    @Autowired
    private CreateCandidateUseCase createCandidateUseCase;

    @PostMapping("/") //define metodo e rota
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidate){
        try{
            var result = this.createCandidateUseCase.execute(candidate);
            return ResponseEntity.ok().body(result);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
