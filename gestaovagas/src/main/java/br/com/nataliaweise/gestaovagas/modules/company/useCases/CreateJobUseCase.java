package br.com.nataliaweise.gestaovagas.modules.company.useCases;

import br.com.nataliaweise.gestaovagas.exceptions.UserFoundException;
import br.com.nataliaweise.gestaovagas.modules.company.entities.CompanyEntity;
import br.com.nataliaweise.gestaovagas.modules.company.entities.JobEntity;
import br.com.nataliaweise.gestaovagas.modules.company.repositories.CompanyRepository;
import br.com.nataliaweise.gestaovagas.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    public JobEntity execute(JobEntity jobRepository){
        return this.jobRepository.save(jobRepository);
    }
}
