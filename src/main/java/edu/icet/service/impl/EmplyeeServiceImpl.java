package edu.icet.service.impl;

import edu.icet.dto.Emplyee;
import edu.icet.entity.EmployeeEntity;
import edu.icet.repository.EmployeeRepository;
import edu.icet.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmplyeeServiceImpl implements EmployeeService {
    final EmployeeRepository repository;
    final ModelMapper modelMapper;

    @Override
    public void addEmplyee(Emplyee emplyee) {
        repository.save(modelMapper.map(emplyee, EmployeeEntity.class));
    }

    @Override
    public List<Emplyee> getAll() {
        List<Emplyee> emplyeeList = new ArrayList<>();
        List<EmployeeEntity> all =repository.findAll();

        all.forEach(employeeEntity -> {
            emplyeeList.add(modelMapper.map(employeeEntity, Emplyee.class));
        });
        return emplyeeList;
    }

    @Override
    public void deleteEmployee(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void updateEmployee(Integer id, Emplyee emplyee) {
        Optional<EmployeeEntity> optionalEmployee = repository.findById(id);

        if (optionalEmployee.isPresent()) {
            EmployeeEntity existingEmployee = optionalEmployee.get();

            existingEmployee.setName(emplyee.getName());
            existingEmployee.setAddress(emplyee.getAddress());
            existingEmployee.setSalary(emplyee.getSalary());

            repository.save(existingEmployee);
        } else {
            throw new RuntimeException("Employee with ID " + id + " not found.");
        }
    }



}
