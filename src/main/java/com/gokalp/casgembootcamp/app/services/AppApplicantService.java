package com.gokalp.casgembootcamp.app.services;

import com.gokalp.casgembootcamp.app.converter.AppApplicantConverter;
import com.gokalp.casgembootcamp.app.dto.requests.AppApplicantCreateRequest;
import com.gokalp.casgembootcamp.app.dto.requests.AppApplicantUpdateRequest;
import com.gokalp.casgembootcamp.app.dto.responses.AppApplicantCreateResponse;
import com.gokalp.casgembootcamp.app.dto.responses.AppApplicantGetAllResponse;
import com.gokalp.casgembootcamp.app.dto.responses.AppApplicantGetResponse;
import com.gokalp.casgembootcamp.app.dto.responses.AppApplicantUpdateResponse;
import com.gokalp.casgembootcamp.app.entity.AppApplicant;
import com.gokalp.casgembootcamp.app.services.entityServices.AppApplicantEntityService;
import com.gokalp.casgembootcamp.gen.enums.ValidationErrorMessage;
import com.gokalp.casgembootcamp.gen.exceptions.ValidationException;
import com.gokalp.casgembootcamp.sec.enums.Authority;
import com.gokalp.casgembootcamp.usr.dto.requests.UsrPasswordChangeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gokalp on 15.12.2022
 * @project casgem-bootcamp
 */
@Service
@RequiredArgsConstructor
public class AppApplicantService {

    private final AppApplicantEntityService applicantEntityService;

    public List<AppApplicantGetAllResponse> getAll() {
        List<AppApplicant> applicantList = applicantEntityService.findAll();
        List<AppApplicantGetAllResponse> applicantGetAllResponseList = AppApplicantConverter.INSTANCE.convertToListOfAppApplicantGetAllResponse(applicantList);
        return applicantGetAllResponseList;
    }

    public AppApplicantCreateResponse create(AppApplicantCreateRequest appApplicantCreateRequest) {
        //todo: Check control user registered before
        confirmPassword(appApplicantCreateRequest.getPassword(),appApplicantCreateRequest.getConfirmPassword());
        AppApplicant appApplicant = AppApplicantConverter.INSTANCE.convertToAppApplicant(appApplicantCreateRequest);
        appApplicant.setRole(Authority.APPLICANT);
        appApplicant = applicantEntityService.save(appApplicant);
        AppApplicantCreateResponse applicantCreateResponse = AppApplicantConverter.INSTANCE.convertToAppApplicantCreateResponse(appApplicant);
        return applicantCreateResponse;
    }

    public AppApplicantGetResponse getById(Long id){
        AppApplicant applicant = applicantEntityService.getByIdWithControl(id);
        AppApplicantGetResponse applicantGetResponse = AppApplicantConverter.INSTANCE.convertToAppApplicantGetResponse(applicant);
        return applicantGetResponse;
    }

    public AppApplicantUpdateResponse update(AppApplicantUpdateRequest applicantUpdateRequest, Long id){
        AppApplicant applicant = AppApplicantConverter.INSTANCE.convertToAppApplicant(applicantUpdateRequest);
        applicant.setId(id);
        applicant = applicantEntityService.save(applicant);
        AppApplicantUpdateResponse applicantUpdateResponse = AppApplicantConverter.INSTANCE.convertToAppApplicantUpdateResponse(applicant);
        return applicantUpdateResponse;
    }

    public void delete(Long id){
        AppApplicant applicant = applicantEntityService.getByIdWithControl(id);
        applicantEntityService.delete(applicant);
    }

    public void changePassword(UsrPasswordChangeRequest passwordChangeRequest, Long id) {
        AppApplicant applicant = applicantEntityService.getByIdWithControl(id);
        checkPassword(passwordChangeRequest, applicant);
        confirmPassword(passwordChangeRequest.getNewPassword(), passwordChangeRequest.getConfirmNewPassword());
        applicantEntityService.save(applicant);
    }

    private static void checkPassword(UsrPasswordChangeRequest passwordChangeRequest, AppApplicant applicant) {
        if (!applicant.getPassword().equals(passwordChangeRequest.getOldPassword())) {
            throw new ValidationException(ValidationErrorMessage.OldPasswordNotMatch);
        }
    }

    private static void confirmPassword(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            throw new ValidationException(ValidationErrorMessage.ConfirmPasswordValid);
        }
    }

}
