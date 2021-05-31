package marteGroupSA;

import java.util.Random;

public class FuegoArtificialIndividual implements FuegoArtificial{

    private String[] ruidos = {"BOOM", "PUM", "KABOOM"};

    @Override
    public void hacerRuido() {
        System.out.println(ruidos[(int) (Math.random() * 3)]);
    }
}
