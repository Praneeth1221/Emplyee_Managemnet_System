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
        service.deleteEmployee(id);
    }
    @PutMapping("/update-employee")
    public void updateEmployee(@RequestBody Emplyee emplyee) {
        service.updateEmployee(emplyee);
    }
    @GetMapping("/search-by-id/{id}")
    public Emplyee searchById(@PathVariable Integer id){
        return service.searchById(id);
    }

    @GetMapping("/search-by-name/{name}")
    public List<Emplyee> searchByName(@PathVariable String name){
        return service.searchByName(name);
    }
}
