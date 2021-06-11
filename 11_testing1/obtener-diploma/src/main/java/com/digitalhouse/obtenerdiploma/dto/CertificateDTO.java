package com.digitalhouse.obtenerdiploma.dto;

public class CertificateDTO extends StudentDTO {

    private String message;
    private Double averageScore;

    public CertificateDTO() {
    }

    public CertificateDTO(StudentDTO student) {
        super(student.getStudentName(), student.getSubjects());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }


}
