package ru.vacancy.vacancyproject.services;

import ru.vacancy.vacancyproject.dto.VacancyProjectRequest;
import ru.vacancy.vacancyproject.dto.VacancyProjectResponse;
import ru.vacancy.vacancyproject.exceptions.IncorrectRequestBodyException;

/**
 * @author Alex Ukrainskyy
 */
public interface VacancyProjectService {
    VacancyProjectResponse addData(VacancyProjectRequest vacancyProjectRequest) throws IncorrectRequestBodyException;
}
