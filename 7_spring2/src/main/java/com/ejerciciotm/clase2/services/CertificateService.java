package com.ejerciciotm.clase2.services;

import com.ejerciciotm.clase2.models.Certificate;
import com.ejerciciotm.clase2.models.Student;
import com.ejerciciotm.clase2.models.Subject;
import org.springframework.stereotype.Service;

@Service
public class CertificateService {

    public Certificate createCertificate(Student student){
        double average =
                student
                .getSubjects()
                .stream()
                .mapToDouble(Subject::getNote)
                .average()
                .orElse(0);

        String message;
        if(average >= 9){
            message = "Felicidades, obtuviste el diploma con promedio de "+ average +" y sos medalla dorada!";
        }
        else {
            message = "Obtuviste el diploma con promedio de "+ average +" ,esforzate mas la proxima!";
        }
        Certificate certificate = new Certificate(message,average ,student.getName());

        return certificate;
    }
}
