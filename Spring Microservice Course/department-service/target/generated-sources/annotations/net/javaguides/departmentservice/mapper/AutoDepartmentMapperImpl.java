package net.javaguides.departmentservice.mapper;

import javax.annotation.processing.Generated;
import net.javaguides.departmentservice.dto.DepartmentDTO;
import net.javaguides.departmentservice.entity.Department;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-24T14:45:38+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class AutoDepartmentMapperImpl implements AutoDepartmentMapper {

    @Override
    public DepartmentDTO departmentToDepartmentDto(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDTO departmentDTO = new DepartmentDTO();

        departmentDTO.setId( department.getId() );
        departmentDTO.setDepartmentName( department.getDepartmentName() );
        departmentDTO.setDepartmentDescription( department.getDepartmentDescription() );
        departmentDTO.setDepartmentCode( department.getDepartmentCode() );

        return departmentDTO;
    }

    @Override
    public Department departmentDtoToDepartment(DepartmentDTO departmentDTO) {
        if ( departmentDTO == null ) {
            return null;
        }

        Department department = new Department();

        department.setId( departmentDTO.getId() );
        department.setDepartmentName( departmentDTO.getDepartmentName() );
        department.setDepartmentDescription( departmentDTO.getDepartmentDescription() );
        department.setDepartmentCode( departmentDTO.getDepartmentCode() );

        return department;
    }
}
