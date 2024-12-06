package br.com.nataliaweise.gestaovagas.modules.candidate.controllers;
import br.com.nataliaweise.gestaovagas.modules.candidate.CandidateEntity;
import br.com.nataliaweise.gestaovagas.modules.candidate.CandidateRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //define que é um arquivo de rotas
@RequestMapping("/candidate") //define caminho inicial
public class CandidateController {

    @Autowired //td q estiver abaixo o spring vai instanciar
    private CandidateRepository candidateRepository;

    @PostMapping("/") //define metodo e rota
    public CandidateEntity create(@Valid @RequestBody CandidateEntity candidate){
        return this.candidateRepository.save(candidate);
    }
}
