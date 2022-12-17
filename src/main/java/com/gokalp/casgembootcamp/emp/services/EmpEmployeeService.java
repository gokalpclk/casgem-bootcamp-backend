package com.gokalp.casgembootcamp.emp.services;

import com.gokalp.casgembootcamp.emp.converter.EmpEmployeeConverter;
import com.gokalp.casgembootcamp.emp.dto.requests.EmpEmployeeCreateRequest;
import com.gokalp.casgembootcamp.emp.dto.requests.EmpEmployeeUpdateRequest;
import com.gokalp.casgembootcamp.emp.dto.responses.EmpEmployeeCreateResponse;
import com.gokalp.casgembootcamp.emp.dto.responses.EmpEmployeeGetAllResponse;
import com.gokalp.casgembootcamp.emp.dto.responses.EmpEmployeeGetResponse;
import com.gokalp.casgembootcamp.emp.dto.responses.EmpEmployeeUpdateResponse;
import com.gokalp.casgembootcamp.emp.entity.EmpEmployee;
import com.gokalp.casgembootcamp.emp.services.entityServices.EmpEmployeeEntityService;
import com.gokalp.casgembootcamp.gen.enums.ValidationErrorMessage;
import com.gokalp.casgembootcamp.gen.exceptions.ValidationException;
import com.gokalp.casgembootcamp.ins.entity.InsInstructor;
import com.gokalp.casgembootcamp.usr.dto.requests.UsrPasswordChangeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gokalp on 17.12.2022
 * @project casgem-bootcamp
 */
@Service
@RequiredArgsConstructor
public class EmpEmployeeService {

	private final EmpEmployeeEntityService employeeEntityService;

	public List<EmpEmployeeGetAllResponse> getAll() {
		List<EmpEmployee> employeeList = employeeEntityService.findAll();
		List<EmpEmployeeGetAllResponse> employeeGetAllResponseList = EmpEmployeeConverter.INSTANCE
				.convertToListOfEmpEmployeeGetAllResponse(employeeList);
		return employeeGetAllResponseList;
	}

	public EmpEmployeeGetResponse getById(Long id) {
		EmpEmployee empEmployee = employeeEntityService.getByIdWithControl(id);
		EmpEmployeeGetResponse empEmployeeGetResponse = EmpEmployeeConverter.INSTANCE
				.convertToEmpEmployeeGetResponse(empEmployee);
		return empEmployeeGetResponse;
	}

	public EmpEmployeeCreateResponse create(EmpEmployeeCreateRequest employeeCreateRequest) {
		confirmPassword(employeeCreateRequest.getPassword(), employeeCreateRequest.getConfirmPassword());
		EmpEmployee employee = EmpEmployeeConverter.INSTANCE.convertToEmpEmployee(employeeCreateRequest);
		employee = employeeEntityService.save(employee);
		EmpEmployeeCreateResponse employeeCreateResponse = EmpEmployeeConverter.INSTANCE
				.convertToEmpEmployeeCreateResponse(employee);
		return employeeCreateResponse;
	}

	public EmpEmployeeUpdateResponse update(EmpEmployeeUpdateRequest employeeUpdateRequest, Long id) {
		EmpEmployee employee = employeeEntityService.getByIdWithControl(id);
		employee = EmpEmployeeConverter.INSTANCE.convertToEmpEmployee(employeeUpdateRequest);
		employee = employeeEntityService.save(employee);
		EmpEmployeeUpdateResponse employeeUpdateResponse = EmpEmployeeConverter.INSTANCE
				.convertToEmpEmployeeUpdateResponse(employee);
		return employeeUpdateResponse;
	}

	public void delete(Long id) {
		EmpEmployee employee = employeeEntityService.getByIdWithControl(id);
		employeeEntityService.delete(employee);
	}

	public void changePassword(UsrPasswordChangeRequest passwordChangeRequest, Long id) {
		EmpEmployee employee = employeeEntityService.getByIdWithControl(id);
		checkPassword(passwordChangeRequest, employee);
		confirmPassword(passwordChangeRequest.getNewPassword(), passwordChangeRequest.getConfirmNewPassword());
		employeeEntityService.save(employee);
	}

	private static void checkPassword(UsrPasswordChangeRequest passwordChangeRequest, EmpEmployee employee) {
		if (!employee.getPassword().equals(passwordChangeRequest.getOldPassword())) {
			throw new ValidationException(ValidationErrorMessage.OldPasswordNotMatch);
		}
	}

	private static void confirmPassword(String password, String confirmPassword) {
		if (!password.equals(confirmPassword)) {
			throw new ValidationException(ValidationErrorMessage.ConfirmPasswordValid);
		}
	}

}
