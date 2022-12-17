package com.gokalp.casgembootcamp.emp.converter;

import com.gokalp.casgembootcamp.emp.dto.requests.EmpEmployeeCreateRequest;
import com.gokalp.casgembootcamp.emp.dto.requests.EmpEmployeeUpdateRequest;
import com.gokalp.casgembootcamp.emp.dto.responses.EmpEmployeeCreateResponse;
import com.gokalp.casgembootcamp.emp.dto.responses.EmpEmployeeGetAllResponse;
import com.gokalp.casgembootcamp.emp.dto.responses.EmpEmployeeGetResponse;
import com.gokalp.casgembootcamp.emp.dto.responses.EmpEmployeeUpdateResponse;
import com.gokalp.casgembootcamp.emp.entity.EmpEmployee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Gokalp on 17.12.2022
 * @project casgem-bootcamp
 */
@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface EmpEmployeeConverter {

	EmpEmployeeConverter INSTANCE = Mappers.getMapper(EmpEmployeeConverter.class);

	List<EmpEmployeeGetAllResponse> convertToListOfEmpEmployeeGetAllResponse(List<EmpEmployee> employeeList);

	EmpEmployeeGetResponse convertToEmpEmployeeGetResponse(EmpEmployee employee);

	EmpEmployee convertToEmpEmployee(EmpEmployeeCreateRequest empEmployeeCreateRequest);

	EmpEmployeeCreateResponse convertToEmpEmployeeCreateResponse(EmpEmployee employee);

	EmpEmployee convertToEmpEmployee(EmpEmployeeUpdateRequest employeeUpdateRequest);

	EmpEmployeeUpdateResponse convertToEmpEmployeeUpdateResponse(EmpEmployee employee);

}
