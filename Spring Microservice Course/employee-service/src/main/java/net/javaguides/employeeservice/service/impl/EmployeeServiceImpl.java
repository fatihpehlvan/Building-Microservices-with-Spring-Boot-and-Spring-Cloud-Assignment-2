package net.javaguides.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.EmployeeDTO;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.exception.ErrorDetails;
import net.javaguides.employeeservice.exception.ResourceNotFoundException;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	private ModelMapper modelMapper;

	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {

		// Using MapStruct
//		Employee employee = AutoEmployeeMapper.MAPPER.mapEmployeeDtoToEmployee(employeeDTO);

		// Using ModelMapper
		Employee employee = modelMapper.map(employeeDTO, Employee.class);

		Employee savedEmployee = employeeRepository.save(employee);

		// Using MapStruct
//		EmployeeDTO savedEmployeeDto = AutoEmployeeMapper.MAPPER.mapEmployeeToEmployeeDto(savedEmployee);

		// Using ModelMapper
		EmployeeDTO savedEmployeeDto = modelMapper.map(savedEmployee, EmployeeDTO.class);

		return savedEmployeeDto;
	}

	@Override
	public EmployeeDTO getEmployee(Long employeeId) {
		Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
		if(employeeOptional.isEmpty()) throw new ResourceNotFoundException("Employee", "Employee id", employeeId);
		// Using MapStruct
//		EmployeeDTO employeeDTO = AutoEmployeeMapper.MAPPER.mapEmployeeToEmployeeDto(employee);
		Employee employee = employeeOptional.get();
		// Using ModalMapper
		EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);

		return employeeDTO;
	}

//	@ExceptionHandler(ResourceNotFoundException.class)
//	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
//	                                                                    WebRequest webRequest){
//
//		ErrorDetails errorDetails = new ErrorDetails(
//				LocalDateTime.now(),
//				exception.getMessage(),
//				webRequest.getDescription(false),
//				"EMPLOYEE_NOT_FOUND"
//		);
//
//		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//	}
}
