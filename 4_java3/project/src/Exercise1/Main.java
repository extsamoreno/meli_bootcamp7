package Exercise1;

public class Main {

    public static void main(String[] args) {
	    Persona per1 = new Persona();
        Persona per2 = new Persona();
        Persona per3 = new Persona();
        Persona per4 = new Persona();
        Persona per5 = new Persona();
        per1.setDni(4);
        per2.setDni(1);
        per3.setDni(5);
        per4.setDni(3);
        per5.setDni(2);
        Persona[] personas = new Persona[]{per1,per2,per3,per4,per5};
        SortUtil.ordenar(personas);
        for(Persona persona : personas){
            System.out.println(persona.getDni());
        }
        Celular cel1 = new Celular();
        Celular cel2 = new Celular();
        Celular cel3 = new Celular();
        Celular cel4 = new Celular();
        Celular cel5 = new Celular();
        cel1.setNumero("4");
        cel2.setNumero("1");
        cel3.setNumero("5");
        cel4.setNumero("3");
        cel5.setNumero("2");
        Celular[] celulares = new Celular[]{cel1,cel2,cel3,cel4,cel5};
        SortUtil.ordenar(celulares);
        for(Celular celular : celulares){
            System.out.println(celular.getNumero());
        }
    }
}
