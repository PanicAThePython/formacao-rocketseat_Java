package br.com.nataliaweise.gestaovagas.modules.company.dto;

import lombok.Data;

@Data
public class CreateJobDTO {

    private String name;
    private String description;
    private String benefits;
    private String level;
}
