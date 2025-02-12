package com.workintech.sqlrelations.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "surgery")
public class Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nurse_id")
    private Nurse nurse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    // Convenience getter and setter for patientId
    public long getPatientId() {
        return patient != null ? patient.getId() : 0;
    }

    public void setPatientId(long patientId) {
        if (this.patient == null) {
            this.patient = new Patient();
        }
        this.patient.setId(patientId);
    }

    // Convenience getter and setter for nurseId
    public long getNurseId() {
        return nurse != null ? nurse.getId() : 0;
    }

    public void setNurseId(long nurseId) {
        if (this.nurse == null) {
            this.nurse = new Nurse();
        }
        this.nurse.setId(nurseId);
    }

    // Convenience getter and setter for doctorId
    public long getDoctorId() {
        return doctor != null ? doctor.getId() : 0;
    }

    public void setDoctorId(long doctorId) {
        if (this.doctor == null) {
            this.doctor = new Doctor();
        }
        this.doctor.setId(doctorId);
    }
}
