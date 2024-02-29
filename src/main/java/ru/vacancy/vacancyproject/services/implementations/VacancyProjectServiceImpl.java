package ru.vacancy.vacancyproject.services.implementations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.vacancy.vacancyproject.dto.VacancyProjectRequest;
import ru.vacancy.vacancyproject.dto.VacancyProjectResponse;
import ru.vacancy.vacancyproject.exceptions.IncorrectRequestBodyException;
import ru.vacancy.vacancyproject.services.VacancyProjectService;

/**
 * @author Alex Ukrainskyy
 */

@Service
@Slf4j
public class VacancyProjectServiceImpl implements VacancyProjectService {
    @Override
    public VacancyProjectResponse addData(VacancyProjectRequest vacancyProjectRequest) throws IncorrectRequestBodyException {
        if (vacancyProjectRequest.getUserId() == null || vacancyProjectRequest.getUserId() <= 0)
            throw new IncorrectRequestBodyException("Добавьте корректный user_id!");
        if (vacancyProjectRequest.getUserData() == null)
            throw new IncorrectRequestBodyException("Добавьте user_data!");

        log.debug("user_id:{} user_data:{}", vacancyProjectRequest.getUserId(), vacancyProjectRequest.getUserData());

        return new VacancyProjectResponse("Processed successfully");
    }
}
