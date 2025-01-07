package br.com.nataliaweise.gestaovagas.modules.candidate.useCases;

import br.com.nataliaweise.gestaovagas.exceptions.UserFoundException;
import br.com.nataliaweise.gestaovagas.modules.candidate.CandidateEntity;
import br.com.nataliaweise.gestaovagas.modules.candidate.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //useCase -> camada de serviço, onde tem a regra de negócio
public class CreateCandidateUseCase {

    @Autowired //td q estiver abaixo o spring vai instanciar
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidate){
        this.candidateRepository
                .findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        return this.candidateRepository.save(candidate);
    }
}
