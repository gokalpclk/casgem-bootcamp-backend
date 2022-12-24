package com.gokalp.casgembootcamp.app.controller;

import com.gokalp.casgembootcamp.app.dto.requests.AppApplicantCreateRequest;
import com.gokalp.casgembootcamp.app.dto.requests.AppApplicantUpdateRequest;
import com.gokalp.casgembootcamp.app.dto.responses.AppApplicantCreateResponse;
import com.gokalp.casgembootcamp.app.dto.responses.AppApplicantGetAllResponse;
import com.gokalp.casgembootcamp.app.dto.responses.AppApplicantGetResponse;
import com.gokalp.casgembootcamp.app.dto.responses.AppApplicantUpdateResponse;
import com.gokalp.casgembootcamp.app.services.AppApplicantService;
import com.gokalp.casgembootcamp.gen.util.result.RestResponse;
import com.gokalp.casgembootcamp.usr.dto.requests.UsrPasswordChangeRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Gokalp on 24.12.2022
 * @project casgem-bootcamp
 */
@RestController
@RequestMapping("/api/v1/applicants")
@AllArgsConstructor
public class AppApplicantController {
    private AppApplicantService applicantService;

    @GetMapping
    public ResponseEntity getAll() {
        List<AppApplicantGetAllResponse> applicantGetAllResponses = applicantService.getAll();
        return ResponseEntity.ok(RestResponse.of(applicantGetAllResponses));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody AppApplicantCreateRequest applicantCreateRequest) {
        AppApplicantCreateResponse applicantCreateResponse = applicantService.create(applicantCreateRequest);
        return ResponseEntity.ok(RestResponse.of(applicantCreateResponse));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        AppApplicantGetResponse applicantGetResponse = applicantService.getById(id);
        return ResponseEntity.ok(RestResponse.of(applicantGetResponse));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody AppApplicantUpdateRequest applicantUpdateRequest, @PathVariable Long id) {
        AppApplicantUpdateResponse applicantUpdateResponse = applicantService.update(applicantUpdateRequest, id);
        return ResponseEntity.ok(RestResponse.of(applicantUpdateResponse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        applicantService.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

    @PutMapping("/change-password/{id}")
    public ResponseEntity changPassword(@RequestBody UsrPasswordChangeRequest passwordChangeRequest,
                                        @PathVariable Long id) {
        applicantService.changePassword(passwordChangeRequest, id);
        return ResponseEntity.ok(RestResponse.empty());
    }


}
