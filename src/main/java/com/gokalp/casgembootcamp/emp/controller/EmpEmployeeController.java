package com.gokalp.casgembootcamp.emp.controller;

import com.gokalp.casgembootcamp.emp.dto.requests.EmpEmployeeCreateRequest;
import com.gokalp.casgembootcamp.emp.dto.requests.EmpEmployeeUpdateRequest;
import com.gokalp.casgembootcamp.emp.dto.responses.EmpEmployeeCreateResponse;
import com.gokalp.casgembootcamp.emp.dto.responses.EmpEmployeeGetAllResponse;
import com.gokalp.casgembootcamp.emp.dto.responses.EmpEmployeeGetResponse;
import com.gokalp.casgembootcamp.emp.dto.responses.EmpEmployeeUpdateResponse;
import com.gokalp.casgembootcamp.emp.services.EmpEmployeeService;
import com.gokalp.casgembootcamp.gen.util.result.RestResponse;
import com.gokalp.casgembootcamp.usr.dto.requests.UsrPasswordChangeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Gokalp on 17.12.2022
 * @project casgem-bootcamp
 */
@RequestMapping("/api/v1/employees")
@RestController
@RequiredArgsConstructor
public class EmpEmployeeController {

	private final EmpEmployeeService employeeService;

	@GetMapping
	public ResponseEntity getAll() {
		List<EmpEmployeeGetAllResponse> employeeGetAllResponseList = employeeService.getAll();
		return ResponseEntity.ok(RestResponse.of(employeeGetAllResponseList));
	}

	@PostMapping
	public ResponseEntity create(@RequestBody EmpEmployeeCreateRequest employeeCreateRequest) {
		EmpEmployeeCreateResponse employeeCreateResponse = employeeService.create(employeeCreateRequest);
		return ResponseEntity.ok(RestResponse.of(employeeCreateResponse));
	}

	@GetMapping("/{id}")
	public ResponseEntity getById(@PathVariable Long id) {
		EmpEmployeeGetResponse employeeGetResponse = employeeService.getById(id);
		return ResponseEntity.ok(RestResponse.of(employeeGetResponse));
	}

	@PutMapping("/{id}")
	public ResponseEntity update(@RequestBody EmpEmployeeUpdateRequest employeeUpdateRequest, @PathVariable Long id) {
		EmpEmployeeUpdateResponse employeeUpdateResponse = employeeService.update(employeeUpdateRequest, id);
		return ResponseEntity.ok(RestResponse.of(employeeUpdateResponse));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		employeeService.delete(id);
		return ResponseEntity.ok(RestResponse.empty());
	}

	@PutMapping("/change-password/{id}")
	public ResponseEntity changPassword(@RequestBody UsrPasswordChangeRequest passwordChangeRequest,
			@PathVariable Long id) {
		employeeService.changePassword(passwordChangeRequest, id);
		return ResponseEntity.ok(RestResponse.empty());
	}

}
