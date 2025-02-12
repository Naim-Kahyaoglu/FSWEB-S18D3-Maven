package com.workintech.sqlrelations.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "operation")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    // Convenience getter for patientId
    public long getPatientId() {
        return patient != null ? patient.getId() : 0;
    }

    // Convenience setter for patientId
    public void setPatientId(long patientId) {
        if (this.patient == null) {
            this.patient = new Patient();
        }
        this.patient.setId(patientId);
    }

    // Convenience getter for doctorId
    public long getDoctorId() {
        return doctor != null ? doctor.getId() : 0;
    }

    // Convenience setter for doctorId
    public void setDoctorId(long doctorId) {
        if (this.doctor == null) {
            this.doctor = new Doctor();
        }
        this.doctor.setId(doctorId);
    }
}
