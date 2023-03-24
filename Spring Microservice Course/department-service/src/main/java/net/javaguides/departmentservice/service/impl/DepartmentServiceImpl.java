package net.javaguides.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.departmentservice.dto.DepartmentDTO;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.exception.ErrorDetails;

import net.javaguides.departmentservice.exception.ResourceNotFoundException;
import net.javaguides.departmentservice.mapper.AutoDepartmentMapper;
import net.javaguides.departmentservice.repository.DepartmentRepository;
import net.javaguides.departmentservice.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	private ModelMapper modelMapper;

	private DepartmentRepository departmentRepository;



	@Override
	public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {

		// convert departmentdto to

		// Using MapStruct
//		Department department = AutoDepartmentMapper.MAPPER.departmentDtoToDepartment(departmentDTO);

		// Using ModelMapper
		Department department = modelMapper.map(departmentDTO, Department.class);

		Department savedDepartment = departmentRepository.save(department);

		// Using MapStruct
//		DepartmentDTO savedDepartmentDTO = AutoDepartmentMapper.MAPPER.departmentToDepartmentDto(department);

		// Using Model Mapper
		DepartmentDTO savedDepartmentDTO = modelMapper.map(savedDepartment, DepartmentDTO.class);



		return savedDepartmentDTO;
	}

	@Override
	public DepartmentDTO getDepartmentByCode(String code) {
		Department department = departmentRepository.findByDepartmentCode(code);

		if (department == null) {

			throw new ResourceNotFoundException("Department", "DepartmentCode", code);
		}

		// using MapStruct
//		DepartmentDTO departmentDTO = AutoDepartmentMapper.MAPPER.departmentToDepartmentDto(department);

		// using model mapper
		DepartmentDTO departmentDTO = modelMapper.map(department, DepartmentDTO.class);

		return departmentDTO;
	}

//	@ExceptionHandler(ResourceNotFoundException.class)
//	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
//	                                                                    WebRequest webRequest){
//
//		ErrorDetails errorDetails = new ErrorDetails(
//				LocalDateTime.now(),
//				exception.getMessage(),
//				webRequest.getDescription(false),
//				"DEPARTMENT_NOT_FOUND"
//		);
//
//		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//	}


}
