package marteGroupSA;

import java.util.ArrayList;
import java.util.Random;

public class FuegoArtificialIndividual implements FuegoArtificial{

    @Override
    public void hacerRuido() {
        String s = "";
        for (int i = 0; i < 5; i++){
            Random r = new Random();
            char c = (char)(r.nextInt(26) + 'a');
            s += c;
        }
        System.out.println(s);
    }
}
