package br.com.nataliaweise.gestaovagas.modules.company.controllers;

import br.com.nataliaweise.gestaovagas.modules.company.dto.CreateJobDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreateJobControllerTest {

    private MockMvc mvc; //isso simula um server

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup(){
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void should_create_a_new_job() throws Exception {

        var jobDTO = CreateJobDTO.builder()
                        .benefits("benefits_test")
                        .level("level test")
                        .name("name test")
                        .description("description test").build();

        mvc.perform(MockMvcRequestBuilders.post("/company/job/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectToJSON(jobDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    private static String objectToJSON(Object objt){
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(objt);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
