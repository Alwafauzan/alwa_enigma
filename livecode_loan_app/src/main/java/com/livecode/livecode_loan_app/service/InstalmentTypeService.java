package com.livecode.livecode_loan_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livecode.livecode_loan_app.model.InstalmentType;
import com.livecode.livecode_loan_app.repository.InstalmentTypeRepository;

@Service
public class InstalmentTypeService {

    private final InstalmentTypeRepository instalmentRepository;

    @Autowired
    public InstalmentTypeService(InstalmentTypeRepository instalmentRepository) {
        this.instalmentRepository = instalmentRepository;
    }

    // create
    public InstalmentType saveInstalmentType(InstalmentType instalment) {
        return instalmentRepository.save(instalment);
    }

    // read
    public List<InstalmentType> getAllInstalmentType() {
        return instalmentRepository.findAll();

    }

    // read by id
    public Optional<InstalmentType> getInstalmentTypeByid(String id) {
        return instalmentRepository.findByid(id);
    }

    // update
    public InstalmentType updateInstalmentTypeByid(String id, InstalmentType instalmentDetails) {
        InstalmentType instalment = instalmentRepository.findByid(id)
                .orElseThrow(() -> new RuntimeException("InstalmentType with id " + id + " not found"));

        instalment.setInstalmentType(instalmentDetails.getInstalmentType());

        return instalmentRepository.save(instalment);
    }

    // delete
    public void deleteInstalmentTypeByid(String id) {
        Optional<InstalmentType> instalment = instalmentRepository.findByid(id);
        if (instalment.isPresent()) {
            instalmentRepository.delete(instalment.get());
        } else {
            throw new RuntimeException("InstalmentType with id " + id + " not found");
        }
    }

}