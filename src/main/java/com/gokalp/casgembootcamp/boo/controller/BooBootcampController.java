package com.gokalp.casgembootcamp.boo.controller;

import com.gokalp.casgembootcamp.boo.dto.requests.BooBootcampCreateRequest;
import com.gokalp.casgembootcamp.boo.dto.requests.BooBootcampUpdateRequest;
import com.gokalp.casgembootcamp.boo.dto.responses.BooBootcampCreateResponse;
import com.gokalp.casgembootcamp.boo.dto.responses.BooBootcampGetAllResponse;
import com.gokalp.casgembootcamp.boo.dto.responses.BooBootcampGetResponse;
import com.gokalp.casgembootcamp.boo.dto.responses.BooBootcampUpdateResponse;
import com.gokalp.casgembootcamp.boo.services.BooBootcampService;
import com.gokalp.casgembootcamp.gen.util.result.RestResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Gokalp on 20.12.2022
 * @project casgem-bootcamp
 */
@RestController
@RequestMapping("/api/v1/bootcamp")
@AllArgsConstructor
public class BooBootcampController {
    private BooBootcampService bootcampService;

    @GetMapping
    public ResponseEntity getAll(){
        List<BooBootcampGetAllResponse> bootcampGetAllResponseList = bootcampService.getAll();
        return ResponseEntity.ok(RestResponse.of(bootcampGetAllResponseList));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody BooBootcampCreateRequest bootcampCreateRequest){
        BooBootcampCreateResponse bootcampCreateResponse = bootcampService.create(bootcampCreateRequest);
        return ResponseEntity.ok(RestResponse.of(bootcampCreateResponse));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        BooBootcampGetResponse bootcampGetResponse = bootcampService.getById(id);
        return ResponseEntity.ok(RestResponse.of(bootcampGetResponse));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody BooBootcampUpdateRequest bootcampUpdateRequest, @PathVariable Long id){
        BooBootcampUpdateResponse bootcampUpdateResponse = bootcampService.update(bootcampUpdateRequest, id);
        return ResponseEntity.ok(RestResponse.of(bootcampUpdateResponse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        bootcampService.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }
}
