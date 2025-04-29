package edu.icet.service;

import edu.icet.dto.Emplyee;

import java.util.List;

public interface EmployeeService {
    void addEmplyee(Emplyee emplyee);

   List<Emplyee> getAll();
}
