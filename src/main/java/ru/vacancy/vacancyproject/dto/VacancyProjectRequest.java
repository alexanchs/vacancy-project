package ru.vacancy.vacancyproject.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Alex Ukrainskyy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VacancyProjectRequest {
    @JsonAlias("user_id")
    private Integer userId;
    @JsonAlias("user_data")
    private String userData;
}
