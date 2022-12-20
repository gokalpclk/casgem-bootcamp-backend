package com.gokalp.casgembootcamp.apo.controller;

import com.gokalp.casgembootcamp.apo.dto.requests.ApoApplicationCreateRequest;
import com.gokalp.casgembootcamp.apo.dto.responses.ApoApplicationCreateResponse;
import com.gokalp.casgembootcamp.apo.dto.responses.ApoApplicationGetAllResponse;
import com.gokalp.casgembootcamp.apo.services.ApoApplicationService;
import com.gokalp.casgembootcamp.gen.util.result.RestResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Gokalp on 19.12.2022
 * @project casgem-bootcamp
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/application")
public class ApoApplicationController {
    ApoApplicationService applicationService;

    @GetMapping
    public ResponseEntity getAll() {
        List<ApoApplicationGetAllResponse> applicationGetAllResponse = applicationService.getAll();
        return ResponseEntity.ok(RestResponse.of(applicationGetAllResponse));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ApoApplicationCreateRequest applicationCreateRequest){
        ApoApplicationCreateResponse applicationCreateResponse = applicationService.create(applicationCreateRequest);
        return ResponseEntity.ok(RestResponse.of(applicationCreateResponse));
    }
}
