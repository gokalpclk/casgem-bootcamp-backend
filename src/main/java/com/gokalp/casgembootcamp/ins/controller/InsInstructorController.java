package com.gokalp.casgembootcamp.ins.controller;

import com.gokalp.casgembootcamp.gen.util.result.RestResponse;
import com.gokalp.casgembootcamp.ins.dto.requests.InsInstructorCreateRequest;
import com.gokalp.casgembootcamp.ins.dto.requests.InsInstructorUpdateRequest;
import com.gokalp.casgembootcamp.ins.dto.responses.InsInstructorGetResponse;
import com.gokalp.casgembootcamp.ins.dto.responses.InsInstructorUpdateResponse;
import com.gokalp.casgembootcamp.ins.services.InsInstructorService;
import com.gokalp.casgembootcamp.usr.dto.requests.UsrPasswordChangeRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Gokalp on 16.12.2022
 * @project casgem-bootcamp
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/instructors")
public class InsInstructorController {
    private InsInstructorService instructorService;

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok(RestResponse.of( instructorService.getAll()));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody InsInstructorCreateRequest instructorCreateRequest){
        return ResponseEntity.ok(RestResponse.of(instructorService.save(instructorCreateRequest)));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        InsInstructorGetResponse instructorGetResponse = instructorService.getById(id);
        return ResponseEntity.ok(RestResponse.of(instructorGetResponse));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody InsInstructorUpdateRequest instructorUpdateRequest, @PathVariable Long id){
        InsInstructorUpdateResponse instructorUpdateResponse = instructorService.update(instructorUpdateRequest, id);
        return ResponseEntity.ok(RestResponse.of(instructorUpdateResponse));
    }
    @PutMapping("/change-password/{id}")
    public ResponseEntity changePassword(@RequestBody UsrPasswordChangeRequest passwordChangeRequest, @PathVariable Long id){
        instructorService.changePassword(passwordChangeRequest, id);
        return ResponseEntity.ok(RestResponse.empty());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        instructorService.deleteById(id);
        return ResponseEntity.ok(RestResponse.empty());
    }



}
