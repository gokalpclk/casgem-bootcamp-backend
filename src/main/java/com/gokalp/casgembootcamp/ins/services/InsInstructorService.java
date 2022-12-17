package com.gokalp.casgembootcamp.ins.services;

import com.gokalp.casgembootcamp.gen.enums.ValidationErrorMessage;
import com.gokalp.casgembootcamp.gen.exceptions.ValidationException;
import com.gokalp.casgembootcamp.ins.converter.InsInstructorConverter;
import com.gokalp.casgembootcamp.ins.dto.requests.InsInstructorCreateRequest;
import com.gokalp.casgembootcamp.ins.dto.requests.InsInstructorUpdateRequest;
import com.gokalp.casgembootcamp.ins.dto.responses.InsInstructorCreateResponse;
import com.gokalp.casgembootcamp.ins.dto.responses.InsInstructorGetAllResponse;
import com.gokalp.casgembootcamp.ins.dto.responses.InsInstructorGetResponse;
import com.gokalp.casgembootcamp.ins.dto.responses.InsInstructorUpdateResponse;
import com.gokalp.casgembootcamp.ins.entity.InsInstructor;
import com.gokalp.casgembootcamp.ins.services.entityServices.InsInstructorEntityService;
import com.gokalp.casgembootcamp.usr.dto.requests.UsrPasswordChangeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@author Gokalp on 16.12.2022
 *@project casgem-bootcamp
*/
@Service
@RequiredArgsConstructor
public class InsInstructorService {
    private final InsInstructorEntityService instructorEntityService;

    public InsInstructorCreateResponse save(InsInstructorCreateRequest instructorCreateRequest){
        confirmPassword(instructorCreateRequest.getPassword(),instructorCreateRequest.getConfirmPassword());
        //todo national identity control
        InsInstructor insInstructor = InsInstructorConverter.INSTANCE.convertToInsInstructor(instructorCreateRequest);
        insInstructor = instructorEntityService.save(insInstructor);
        return InsInstructorConverter.INSTANCE.convertToInsInstructorCreateResponse((insInstructor));
    }

    public List<InsInstructorGetAllResponse> getAll(){
        List<InsInstructor> instructorList = instructorEntityService.findAll();
        List<InsInstructorGetAllResponse> insInstructorGetAllResponseList = InsInstructorConverter.INSTANCE.convertToListOfInsInstructorGetAllResponse(instructorList);
        return insInstructorGetAllResponseList;
    }

    public InsInstructorGetResponse getById(Long id){
        InsInstructor insInstructor = instructorEntityService.getByIdWithControl(id);
        InsInstructorGetResponse insInstructorGetResponse = InsInstructorConverter.INSTANCE.convertToInsInstructorGetResponse(insInstructor);
        return insInstructorGetResponse;
    }

    public InsInstructorUpdateResponse update(InsInstructorUpdateRequest instructorUpdateRequest, Long id){
        InsInstructor instructor = InsInstructorConverter.INSTANCE.convertToInsInstructor(instructorUpdateRequest);
        instructor.setId(id);
        instructor = instructorEntityService.save(instructor);
        InsInstructorUpdateResponse insInstructorUpdateResponse = InsInstructorConverter.INSTANCE.convertToInsInstructorUpdateResponse(instructor);
        return insInstructorUpdateResponse;
    }

    public void deleteById(Long id){
        InsInstructor instructor = instructorEntityService.getByIdWithControl(id);
        instructorEntityService.delete(instructor);
    }

    public void changePassword(UsrPasswordChangeRequest passwordChangeRequest, Long id){
        InsInstructor instructor = instructorEntityService.getByIdWithControl(id);
        checkPassword(passwordChangeRequest, instructor);
        confirmPassword(passwordChangeRequest.getNewPassword(), passwordChangeRequest.getConfirmNewPassword());
        instructorEntityService.save(instructor);
    }

    private static void checkPassword(UsrPasswordChangeRequest passwordChangeRequest, InsInstructor instructor) {
        if(!instructor.getPassword().equals(passwordChangeRequest.getOldPassword())){
            throw new ValidationException(ValidationErrorMessage.OldPasswordNotMatch);
        }
    }

    private static void confirmPassword(String password, String confirmPassword) {
        if(!password.equals(confirmPassword)){
            throw new ValidationException(ValidationErrorMessage.ConfirmPasswordValid);
        }
    }
}
