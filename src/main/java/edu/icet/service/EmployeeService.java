package edu.icet.service;

import edu.icet.dto.Emplyee;

import java.util.List;

public interface EmployeeService {
    void addEmplyee(Emplyee emplyee);

    List<Emplyee> getAll();

    void deleteEmployee(Integer id);

    void updateEmployee(Emplyee emplyee);

    Emplyee searchById(Integer id);

    List<Emplyee> searchByName(String name);
}
