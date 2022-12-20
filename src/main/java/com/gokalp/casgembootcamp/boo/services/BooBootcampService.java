package com.gokalp.casgembootcamp.boo.services;

import com.gokalp.casgembootcamp.boo.converter.BooBootcampConverter;
import com.gokalp.casgembootcamp.boo.dto.requests.BooBootcampCreateRequest;
import com.gokalp.casgembootcamp.boo.dto.responses.BooBootcampCreateResponse;
import com.gokalp.casgembootcamp.boo.dto.responses.BooBootcampGetAllResponse;
import com.gokalp.casgembootcamp.boo.entity.BooBootcamp;
import com.gokalp.casgembootcamp.boo.services.entityServices.BooBootcampEntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gokalp on 20.12.2022
 * @project casgem-bootcamp
 */
@Service
@AllArgsConstructor
public class BooBootcampService {

    private BooBootcampEntityService bootcampEntityService;

    public List<BooBootcampGetAllResponse>  getAll(){
        List<BooBootcamp> bootcampList = bootcampEntityService.findAll();
        List<BooBootcampGetAllResponse> bootcampGetAllResponseList = BooBootcampConverter.INSTANCE.convertToListOfBooBootcampGetAllResponse(bootcampList);
        return bootcampGetAllResponseList;
    }

    public BooBootcampCreateResponse create(BooBootcampCreateRequest bootcampCreateRequest){
        BooBootcamp bootcamp = BooBootcampConverter.INSTANCE.convertToBooBootcamp(bootcampCreateRequest);
        bootcamp = bootcampEntityService.save(bootcamp);
        BooBootcampCreateResponse bootcampCreateResponse = BooBootcampConverter.INSTANCE.convertTooBooBootcampCreateResponse(bootcamp);
        return bootcampCreateResponse;
    }
}
