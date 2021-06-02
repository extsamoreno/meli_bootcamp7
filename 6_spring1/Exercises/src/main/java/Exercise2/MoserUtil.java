package Exercise2;

import java.util.*;

public class MoserUtil {
    Map<Character, String> dicc = new HashMap<Character, String>();

    public Map<Character, String> cargarDiccionario() {
        this.dicc.put('A', ".-");
        this.dicc.put('B', "-...");
        this.dicc.put('C', "-.-.");
        this.dicc.put('D', "-..");
        this.dicc.put('E', ".");
        this.dicc.put('F', "..-.");
        this.dicc.put('G', "--.");
        this.dicc.put('H', "....");
        this.dicc.put('I', "..");
        this.dicc.put('J', ".---");
        this.dicc.put('K', "-.-");
        this.dicc.put('L', ".-..");
        this.dicc.put('M', "--");
        this.dicc.put('N', "-.");
        this.dicc.put('Ñ', "--.--");
        this.dicc.put('O', "---");
        this.dicc.put('P', ".--.");
        this.dicc.put('Q', "--.-");
        this.dicc.put('R', ".-.");
        this.dicc.put('S', "...");
        this.dicc.put('T', "-");
        this.dicc.put('U', "..-");
        this.dicc.put('V', "...-");
        this.dicc.put('W', ".--");
        this.dicc.put('X', "-..-");
        this.dicc.put('Y', "-.--");
        this.dicc.put('Z', "--..");
        this.dicc.put('0', "-----");
        this.dicc.put('1', ".----");
        this.dicc.put('2', "..---");
        this.dicc.put('3', "...--");
        this.dicc.put('4', "....-");
        this.dicc.put('5', ".....");
        this.dicc.put('6', "-....");
        this.dicc.put('7', "--...");
        this.dicc.put('8', "---..");
        this.dicc.put('9', "----.");
        this.dicc.put('.', ".-.-.-");
        this.dicc.put(',', "--..--");
        this.dicc.put(':', "---...");
        this.dicc.put('?', "..--..");
        this.dicc.put('\'', ".----.");
        this.dicc.put('-', "-....-");
        this.dicc.put('/', "-..-.");
        this.dicc.put('"', ".-..-.");
        this.dicc.put('@', ".--.-.");
        this.dicc.put('=', "-...-");
        this.dicc.put('!', "−.−.−−");
        return this.dicc;
    }

    public Character Sacarletra(String letra) {

        for (var t : this.dicc.entrySet()) {
            if (t.getValue().equals(letra)) {
                return t.getKey();
            }
        }
        return ' ';
    }
}

