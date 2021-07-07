package com.meli.muelitas.mapper;

import com.meli.muelitas.dto.*;
import com.meli.muelitas.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MapStructConverter {

    MapStructConverter MAPPER = Mappers.getMapper(MapStructConverter.class);

    //Specialty-------------------------------------------------------------------------------------------------------

    Specialty specialtyDTOtoSpecialty(SpecialtyDTO dto);

    SpecialtyDTO toSpecialtyDTO(Specialty model);

    List<SpecialtyDTO> toSpecialtyDtoList(List<Specialty> modelList);

    //Dentist---------------------------------------------------------------------------------------------------------
    @Mapping(target = "specialtyDTO.id", source = "specialty.id")
    DentistDTO dentistToDentistDTO(Dentist model);

    @Mapping(target = "specialty.id", source = "specialtyDTO.id")
    Dentist dentistDTOToDentist(DentistDTO dto);

    Dentist dentistInDTOToDentist(DentistInDTO dentistInDTO);

    List<DentistDTO> dentistListToDentistDTOList(List<Dentist> modelList);

    //DentistAvailability--------------------------------------------------------------------------------------------
    @Mapping(target = "id.dentistId", source = "dentistId")
    @Mapping(target = "id.dayOfWeek", source = "dayOfWeek")
    DentistAvailability dentistAvailabilityDTOToDentistAvailability(DentistAvailabilityDTO dto);

    @Mapping(target = "dentistId", source = "id.dentistId")
    @Mapping(target = "dayOfWeek", source = "id.dayOfWeek")
    DentistAvailabilityDTO dentistAvailabilityToDentistAvailabilityDTO(DentistAvailability model);

    List<DentistAvailabilityDTO> dentistAvailabilityListToDentistAvailabilityDTOList(List<DentistAvailability> modelList);

    //Patient----------------------------------------------------------------------------------------------

    Patient patientDTOToPatient(PatientDTO dto);

    PatientDTO patientToPatientDTO(Patient model);

    List<PatientDTO> patientListToPatientDTOList(List<Patient> modelList);

    //Appointment

    @Mapping(target = "patientDTO", source = "patient")
    @Mapping(target = "dentistDTO", source = "dentist")
    AppointmentDTO appointmentToAppointmentDTO(Appointment model);

    Appointment appointmentDTOToAppointment(AppointmentDTO dto);

    AppointmentDTO appointmentInDTOToAppointmentDTO(AppointmentInDTO appointmentInDTO);

    @Mapping(target = "patientId", source = "patient.id")
    @Mapping(target = "dentistId", source = "dentist.id")
    AppointmentInDTO appointmentToAppointmentInDTO(Appointment appointment);

    List<AppointmentDTO> appointmentListToAppointmentDTOList(List<Appointment> modelList);

}
