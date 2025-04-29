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
    public void updateEmployee( Emplyee emplyee) {
        Optional<EmployeeEntity> existingEmployee = repository.findById(emplyee.getId());
        if(existingEmployee.isPresent()) {
            EmployeeEntity entityToUpdate = existingEmployee.get();
            entityToUpdate.setName(emplyee.getName());
            entityToUpdate.setEmail(emplyee.getEmail());
            entityToUpdate.setDepartment(emplyee.getDepartment());
            entityToUpdate.setCreateAt(emplyee.getCreateAt());
            entityToUpdate.setUpdateAt(emplyee.getUpdateAt());
            repository.save(entityToUpdate);
        } else {
            throw new RuntimeException("Employee with ID " + emplyee.getId() + " not found.");
        }
    }

    @Override
    public Emplyee searchById(Integer id) {
        return modelMapper.map(repository.findById(id), Emplyee.class);
    }

    @Override
    public List<Emplyee> searchByName(String name) {
        List<EmployeeEntity> byName = repository.findByName(name);
        List<Emplyee> emplyeeList = new ArrayList<>();

        byName.forEach(employeeEntity -> {
            emplyeeList.add(modelMapper.map(employeeEntity, Emplyee.class));
        });
        return emplyeeList;
    }

    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }
}
