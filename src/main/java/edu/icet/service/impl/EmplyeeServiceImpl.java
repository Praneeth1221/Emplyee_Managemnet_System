package edu.icet.service.impl;

import edu.icet.dto.Emplyee;
import edu.icet.entity.EmployeeEntity;
import edu.icet.repository.EmployeeRepository;
import edu.icet.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmplyeeServiceImpl implements EmployeeService {
    final EmployeeRepository repository;
    final ModelMapper modelMapper;

    @Override
    public void addEmplyee(Emplyee emplyee) {
        repository.save(modelMapper.map(emplyee, EmployeeEntity.class));
    }
}
