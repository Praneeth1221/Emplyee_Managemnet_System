package edu.icet.controller;

import edu.icet.dto.Emplyee;
import edu.icet.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@CrossOrigin
public class EmployeeController {
    final EmployeeService service;
    @PostMapping("/add")

    public void addEmployee(@RequestBody Emplyee emplyee){
        service.addEmplyee(emplyee);
        System.out.println(emplyee);
    }
}
