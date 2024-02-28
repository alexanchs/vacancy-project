package ru.vacancy.vacancyproject.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import ru.vacancy.vacancyproject.dto.VacancyProjectRequest;
import ru.vacancy.vacancyproject.dto.VacancyProjectResponse;
import ru.vacancy.vacancyproject.exceptions.IncorrectRequestBodyException;
import ru.vacancy.vacancyproject.services.VacancyProjectService;

/**
 * @author Alex Ukrainskyy
 */

@RestController
@RequiredArgsConstructor
@Slf4j
public class VacancyProjectController {
    private final VacancyProjectService vacancyProjectService;

    @PostMapping(value = "/add_data")
    public ResponseEntity<VacancyProjectResponse> addData(
            @RequestBody VacancyProjectRequest vacancyProjectRequest) throws IncorrectRequestBodyException {
        VacancyProjectResponse response = vacancyProjectService.addData(vacancyProjectRequest);
        return ResponseEntity.ok()
                .body(response);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(IncorrectRequestBodyException exception) {
        return ErrorResponse.builder(exception, HttpStatus.BAD_REQUEST,exception.getMessage())
                .build();
    }
}
