package br.com.nataliaweise.gestaovagas.modules.company.controllers;

import br.com.nataliaweise.gestaovagas.modules.company.dto.CreateJobDTO;
import br.com.nataliaweise.gestaovagas.modules.company.entities.JobEntity;
import br.com.nataliaweise.gestaovagas.modules.company.useCases.CreateJobUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/company/job")
public class JobController {

    @Autowired
    public CreateJobUseCase createJobUseCase;

    @PostMapping("/")
    @PreAuthorize("hasRole('COMPANY')")
    public JobEntity create(@Valid @RequestBody CreateJobDTO createJobDTO, HttpServletRequest request){
        var companyId = request.getAttribute("company_id");

        var job = JobEntity.builder()
                .companyId(UUID.fromString(companyId.toString()))
                .name(createJobDTO.getName())
                .benefits(createJobDTO.getBenefits())
                .level(createJobDTO.getLevel())
                .description(createJobDTO.getDescription()).build();

        return this.createJobUseCase.execute(job);
    }
}
