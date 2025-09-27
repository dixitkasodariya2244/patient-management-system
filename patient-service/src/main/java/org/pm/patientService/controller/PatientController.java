package org.pm.patientService.controller;

import jakarta.validation.Valid;
import org.pm.patientService.dto.PatientRequestDTO;
import org.pm.patientService.dto.PatientResponseDTO;
import org.pm.patientService.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getPatient() {
        List<PatientResponseDTO> patient = patientService.getPatient();
        return ResponseEntity.ok().body(patient);
    }

    @PostMapping
    public ResponseEntity<PatientResponseDTO> createPetient(@Valid @RequestBody PatientRequestDTO patientRequestDTO) {
        PatientResponseDTO patientResponseDTO = patientService.createPatient(patientRequestDTO);
        return ResponseEntity.ok().body(patientResponseDTO);
    }
}
