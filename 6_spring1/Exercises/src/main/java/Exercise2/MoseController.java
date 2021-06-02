package Exercise2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoseController {
    @GetMapping("/morse/{entrada}")
    public String getMorse(@PathVariable String entrada){
        MoserUtil mor= new MoserUtil();
        mor.cargarDiccionario();
        String salida="";
        String []palabras= entrada.split("  ");
        for (int i = 0; i < palabras.length; i++) {
            String[] letras= palabras[i].split(" ");
            for (int j = 0; j < letras.length; j++) {
                salida += mor.Sacarletra(letras[j].toUpperCase());
            }
            if(i<palabras.length)
            salida.concat(" ");
        }
        return salida;
    }
}
