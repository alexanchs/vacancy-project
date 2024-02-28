package ru.vacancy.vacancyproject;

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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.vacancy.vacancyproject.dto.VacancyProjectRequest;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author Alex Ukrainskyy
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class VacancyProjectControllerTests {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void givenVacancyProjectRequest_shouldSucceedWith200() throws Exception {
        VacancyProjectRequest vacancyProjectRequest = getVacancyProjectRequest();
        String vacancyProjectRequestString = objectMapper.writeValueAsString(vacancyProjectRequest);
        mockMvc.perform(MockMvcRequestBuilders.post("/add_data")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(vacancyProjectRequestString))
                .andExpect(status().isOk());
    }

    @Test
    public void givenVacancyProjectRequest_shouldSucceedWith400() throws Exception {
        VacancyProjectRequest vacancyProjectRequest = getVacancyProjectRequestNull();
        String vacancyProjectRequestString = objectMapper.writeValueAsString(vacancyProjectRequest);
        mockMvc.perform(MockMvcRequestBuilders.post("/add_data")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(vacancyProjectRequestString))
                .andExpect(status().isBadRequest());
    }
    private VacancyProjectRequest getVacancyProjectRequest() {
        return VacancyProjectRequest.builder()
                .userId(12)
                .userData("User data")
                .build();
    }

    private VacancyProjectRequest getVacancyProjectRequestNull() {
        return VacancyProjectRequest.builder()
                .userId(12)
                .userData(null)
                .build();
    }
}
