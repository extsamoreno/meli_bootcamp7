package spring2.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring2.demo.models.Casa;
import spring2.demo.models.CasaResponseDTO;
import spring2.demo.models.Habitacion;
import spring2.demo.models.M2PorHabitacion;

import java.util.ArrayList;

//Se necesita desarrollar un API que reciba una Casa con su “nombre”, “dirección” y sus “habitaciones”, estas contienen un “nombre”, “ancho” y “largo”.
//Se pide, retornar un objeto que diga la cantidad totales de metros cuadrados de la casa.
//Indicar el valor de la casa tomando en cuenta que se toma como referencia USD 800 el metro cuadrado.
//Retornar el objeto con la habitación más grande.
//Retornar la cantidad de metros cuadrados por habitación.

@RestController
@RequestMapping("/casa")
public class CasaController {
    @PostMapping("/getm2")
    public ResponseEntity<CasaResponseDTO>  getm2 (@RequestBody Casa casa){
        int m2total = 0;
        Habitacion habM2Max = new Habitacion();
        var m2PorHab = new ArrayList<M2PorHabitacion>();
        for (Habitacion h : casa.getHabitaciones()) {
            m2PorHab.add(new M2PorHabitacion(h.getNombre(),h.getM2()));
            m2total += h.getM2();
            if(h.getM2() > habM2Max.getM2()){
                habM2Max = h;
            }
        }
        return new ResponseEntity<>(new CasaResponseDTO(m2total,800*m2total,habM2Max,m2PorHab), HttpStatus.OK);
    }

}
