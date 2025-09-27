package org.pm.patientService.service;

import org.pm.patientService.dto.PatientResponseDTO;
import org.pm.patientService.mapper.PatientMapper;
import org.pm.patientService.model.Patient;
import org.pm.patientService.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatient(){
        List<Patient> patients = patientRepository.findAll();

        return patients.stream()
                .map(PatientMapper::toDTO).toList();
    }
}
