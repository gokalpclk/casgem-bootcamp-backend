package com.gokalp.casgembootcamp.boo.converter;

import com.gokalp.casgembootcamp.boo.dto.requests.BooBootcampCreateRequest;
import com.gokalp.casgembootcamp.boo.dto.requests.BooBootcampUpdateRequest;
import com.gokalp.casgembootcamp.boo.dto.responses.BooBootcampCreateResponse;
import com.gokalp.casgembootcamp.boo.dto.responses.BooBootcampGetAllResponse;
import com.gokalp.casgembootcamp.boo.dto.responses.BooBootcampGetResponse;
import com.gokalp.casgembootcamp.boo.dto.responses.BooBootcampUpdateResponse;
import com.gokalp.casgembootcamp.boo.entity.BooBootcamp;
import com.gokalp.casgembootcamp.ins.services.entityServices.InsInstructorEntityService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Gokalp on 20.12.2022
 * @project casgem-bootcamp
 */
@Mapper(componentModel = "spring", uses = {InsInstructorEntityService.class})
public interface BooBootcampConverter {

    BooBootcampConverter INSTANCE = Mappers.getMapper(BooBootcampConverter.class);

    @Mapping(target = "instructorId", source = "instructor.id")
    @Mapping(target = "instructorFirstName", source = "instructor.firstName")
    @Mapping(target = "instructorLastName", source = "instructor.lastName")
    BooBootcampGetResponse convertToBooBootcampGetResponse(BooBootcamp bootcamp);

    //todo: list mapping
    List<BooBootcampGetAllResponse> convertToListOfBooBootcampGetAllResponse(List<BooBootcamp> bootcampList);


    @Mapping(target = "instructor.id", source = "instructorId")
    BooBootcamp convertToBooBootcamp(BooBootcampCreateRequest bootcampCreateRequest);

    @Mapping(target = "instructor.id", source = "instructorId")
    BooBootcamp convertToBooBootcamp(BooBootcampUpdateRequest bootcampUpdateRequest);

    @Mapping(target = "instructorId", source = "instructor.id")
    BooBootcampCreateResponse convertTooBooBootcampCreateResponse(BooBootcamp bootcamp);
    @Mapping(target = "instructorId", source = "instructor.id")
    BooBootcampUpdateResponse convertTooBooBootcampUpdateResponse(BooBootcamp bootcamp);
}
