package com.livecode.livecode_loan_app.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livecode.livecode_loan_app.model.InstalmentType;
import com.livecode.livecode_loan_app.service.InstalmentTypeService;

// ini buat inisialisasi bikin api nya
@RestController
@RequestMapping("/api/instalment-type")
public class InstalmentTypeController {

    @Autowired
    private InstalmentTypeService instalmetTypeService;

    // create
    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public InstalmentType saveInstalmentType(@RequestBody InstalmentType instalmetType) {
        return instalmetTypeService.saveInstalmentType(instalmetType);
    }

    // read
    @GetMapping("/")
    public List<InstalmentType> getAllInstalmentType() {
        return instalmetTypeService.getAllInstalmentType();
    }

    // read by id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<InstalmentType>> getInstalmentTypeByid(@PathVariable String id) {
        try {
            Optional<InstalmentType> instalmetType = instalmetTypeService.getInstalmentTypeByid(id);
            return ResponseEntity.ok(instalmetType);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<InstalmentType> updateInstalmentTypeByid(@PathVariable(value = "id") String id,
            @RequestBody InstalmentType instalmetTypeDetails) {
        try {
            InstalmentType updatedInstalmentType = instalmetTypeService.updateInstalmentTypeByid(id,
                    instalmetTypeDetails);
            return ResponseEntity.ok(updatedInstalmentType);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInstalmentTypeByid(@PathVariable String id) {
        try {
            instalmetTypeService.deleteInstalmentTypeByid(id);
            return ResponseEntity.ok("InstalmentType with id " + id + " deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}