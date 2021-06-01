package com.meli.romanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Hashtable;
import java.util.Set;

@RestController
@RequestMapping("/morse")
public class MorseConversionController {

    @GetMapping("/{morseBuscado}")
    public static String morseAAscii(@PathVariable String morseBuscado) {
        String fraseFinal="";
        Hashtable<String, String> equivalencias = obtenerEquivalenciasMAP();
        // La clave es la letra ASCII
        String[] morseDividido= morseBuscado.split("   "); // Divide por palabras (o lo que es lo mismo 3 espacios)
        for (int i = 0; i < morseDividido.length; i++) {
            String[] letrasPorPalabra= morseDividido[i].split(" "); // Se divide la palabra por cada letra (o lo que es lo mismo 1 espacio)
            for (int j = 0; j < letrasPorPalabra.length; j++) {
                fraseFinal+=equivalencias.get(letrasPorPalabra[j]);
            }
            if (i!=morseDividido.length-1) fraseFinal+=" ";
        }
        return fraseFinal;
    }

    // Este metodo genera un hashtable para convertir de palabra a morse
    public static Hashtable<String, String> obtenerEquivalenciasPAM() {
        Hashtable<String, String> equivalencias = new Hashtable<>();
        equivalencias.put("A", ".-");
        equivalencias.put("B", "-...");
        equivalencias.put("C", "-.-.");
        equivalencias.put("CH", "----");
        equivalencias.put("D", "-..");
        equivalencias.put("E", ".");
        equivalencias.put("F", "..-.");
        equivalencias.put("G", "--.");
        equivalencias.put("H", "....");
        equivalencias.put("I", "..");
        equivalencias.put("J", ".---");
        equivalencias.put("K", "-.-");
        equivalencias.put("L", ".-..");
        equivalencias.put("M", "--");
        equivalencias.put("N", "-.");
        equivalencias.put("Ñ", "--.--");
        equivalencias.put("O", "---");
        equivalencias.put("P", ".--.");
        equivalencias.put("Q", "--.-");
        equivalencias.put("R", ".-.");
        equivalencias.put("S", "...");
        equivalencias.put("T", "-");
        equivalencias.put("U", "..-");
        equivalencias.put("V", "...-");
        equivalencias.put("W", ".--");
        equivalencias.put("X", "-..-");
        equivalencias.put("Y", "-.--");
        equivalencias.put("Z", "--..");
        equivalencias.put("0", "-----");
        equivalencias.put("1", ".----");
        equivalencias.put("2", "..---");
        equivalencias.put("3", "...--");
        equivalencias.put("4", "....-");
        equivalencias.put("5", ".....");
        equivalencias.put("6", "-....");
        equivalencias.put("7", "--...");
        equivalencias.put("8", "---..");
        equivalencias.put("9", "----.");
        equivalencias.put(".", ".-.-.-");
        equivalencias.put(",", "--..--");
        equivalencias.put(":", "---...");
        equivalencias.put("?", "..--..");
        equivalencias.put("'", ".----.");
        equivalencias.put("-", "-....-");
        equivalencias.put("/", "-..-.");
        equivalencias.put("\"", ".-..-.");
        equivalencias.put("@", ".--.-.");
        equivalencias.put("=", "-...-");
        equivalencias.put("!", "−.−.−−");
        return equivalencias;
    }

    // este metodo genera un hashtable con las equivalencias para pasar de morse a palabra
    public static Hashtable<String, String> obtenerEquivalenciasMAP() {
        Hashtable<String, String> equivalencias = new Hashtable<>();
        equivalencias.put(".-","A");
        equivalencias.put("-...","B");
        equivalencias.put("-.-.","C");
        equivalencias.put("----","CH");
        equivalencias.put("-..","D");
        equivalencias.put(".","E");
        equivalencias.put("..-.","F");
        equivalencias.put( "--.","G");
        equivalencias.put("....","H");
        equivalencias.put( "..","I");
        equivalencias.put(".---","J");
        equivalencias.put("-.-","K");
        equivalencias.put( ".-..","L");
        equivalencias.put( "--","M");
        equivalencias.put("-.","N");
        equivalencias.put( "--.--","Ñ");
        equivalencias.put("---","O");
        equivalencias.put(".--.","P");
        equivalencias.put("--.-","Q");
        equivalencias.put( ".-.","R");
        equivalencias.put( "...","S");
        equivalencias.put("-","T");
        equivalencias.put( "..-","U");
        equivalencias.put( "...-","V");
        equivalencias.put( ".--","W");
        equivalencias.put( "-..-","X");
        equivalencias.put("-.--","Y");
        equivalencias.put( "--..","Z");
        equivalencias.put( "-----","0");
        equivalencias.put( ".----","1");
        equivalencias.put( "..---","2");
        equivalencias.put( "...--","3");
        equivalencias.put( "....-","4");
        equivalencias.put( ".....","5");
        equivalencias.put( "-....","6");
        equivalencias.put( "--...","7");
        equivalencias.put("---..","8");
        equivalencias.put( "----.","9");
        equivalencias.put( ".-.-.-",".");
        equivalencias.put( "--..--",",");
        equivalencias.put( "---...",":");
        equivalencias.put( "..--..","?");
        equivalencias.put( ".----.","'");
        equivalencias.put( "-....-","-");
        equivalencias.put( "-..-.","/");
        equivalencias.put( ".-..-.","\"");
        equivalencias.put( ".--.-.","@");
        equivalencias.put( "-...-","=");
        equivalencias.put( "−.−.−−","!");
        return equivalencias;
    }
}
