package clasesTardeEjercicio1;

public class Main {

    public static void main(String[] args) {

        PasswordDebil pd= new PasswordDebil("");
        pd.setValue("asduAD12**");
        System.out.println(pd.getValue());
        pd.setValue("asdu");
        System.out.println(pd.getValue());
    }
}

