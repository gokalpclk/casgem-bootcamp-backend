package com.gokalp.casgembootcamp.boo.converter;

import com.gokalp.casgembootcamp.boo.dto.requests.BooBootcampCreateRequest;
import com.gokalp.casgembootcamp.boo.dto.requests.BooBootcampUpdateRequest;
import com.gokalp.casgembootcamp.boo.dto.responses.BooBootcampCreateResponse;
import com.gokalp.casgembootcamp.boo.dto.responses.BooBootcampGetAllResponse;
import com.gokalp.casgembootcamp.boo.dto.responses.BooBootcampGetResponse;
import com.gokalp.casgembootcamp.boo.dto.responses.BooBootcampUpdateResponse;
import com.gokalp.casgembootcamp.boo.entity.BooBootcamp;
import com.gokalp.casgembootcamp.ins.entity.InsInstructor;
import com.gokalp.casgembootcamp.ins.services.entityServices.InsInstructorEntityService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Gokalp on 20.12.2022
 * @project casgem-bootcamp
 */
@Mapper(componentModel = "spring", uses = {InsInstructorEntityService.class})
public interface BooBootcampConverter {

    BooBootcampConverter INSTANCE = Mappers.getMapper(BooBootcampConverter.class);
    List<BooBootcampGetAllResponse> convertToListOfBooBootcampGetAllResponse(List<BooBootcamp> bootcampList);
    BooBootcampGetResponse convertToBooBootcampGetResponse(BooBootcamp bootcamp);

     @Mapping(target = "instructor.id", source = "instructorId")
    BooBootcamp convertToBooBootcamp(BooBootcampCreateRequest bootcampCreateRequest);
    BooBootcamp convertToBooBootcamp(BooBootcampUpdateRequest bootcampUpdateRequest);
    BooBootcampCreateResponse convertTooBooBootcampCreateResponse(BooBootcamp bootcamp);
    BooBootcampUpdateResponse convertTooBooBootcampUpdateResponse(BooBootcamp bootcamp);
}
