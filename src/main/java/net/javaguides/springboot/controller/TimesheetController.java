package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Timesheet;
import net.javaguides.springboot.repository.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
@RestController
@RequestMapping("/api/v1/timesheet")
public class TimesheetController {
    @Autowired
    private TimesheetRepository timesheetRepository;

    @GetMapping
    public List<Timesheet> getAllTimesheets() {
        return timesheetRepository.findAll();
    }

    // build create employee REST API
    @PostMapping
    public Timesheet createEmployee(@RequestBody Timesheet employee)   {
        return timesheetRepository.save(employee);
    }

    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Timesheet> getEmployeeById(@PathVariable Long id)    {
        Timesheet employee = timesheetRepository.findById(id).orElseThrow(()-> new ResourceAccessException("Employee not exist with id"+id));
        return ResponseEntity.ok(employee);
    }

    // build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Timesheet> updateEmployee(@PathVariable Long id,@RequestBody Timesheet employeeDetails)    {
        Timesheet updateEmployee = timesheetRepository.findById(id).orElseThrow(()-> new ResourceAccessException("Employee not exist with id: "+ id));

        updateEmployee.setUserId(employeeDetails.getUserId());
        updateEmployee.setCustomerId(employeeDetails.getCustomerId());
        updateEmployee.setTimesheetDate(employeeDetails.getTimesheetDate());
        updateEmployee.setDuration(employeeDetails.getDuration());
        updateEmployee.setLocation(employeeDetails.getLocation());
        updateEmployee.setTaskId(employeeDetails.getTaskId());
        updateEmployee.setDescription(employeeDetails.getDescription());
        updateEmployee.setCreateDate(employeeDetails.getCreateDate());

        timesheetRepository.save(updateEmployee);

        return  ResponseEntity.ok(updateEmployee);
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id)   {

        Timesheet employee = timesheetRepository.findById(id).orElseThrow(()-> new ResourceAccessException("Employee not exist with id: "+ id));

        timesheetRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
