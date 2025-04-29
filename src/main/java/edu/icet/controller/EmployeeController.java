package edu.icet.controller;

import edu.icet.dto.Emplyee;
import edu.icet.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@CrossOrigin
public class EmployeeController {
    final EmployeeService service;
    @PostMapping("/add")

    public void addEmployee(@RequestBody Emplyee emplyee){
        service.addEmplyee(emplyee);
    }
    @GetMapping("/get-all")
    public List<Emplyee> getAll(){
        return service.getAll();
    }
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Integer id){
        service.deleteCustomer(id);
    }

}
