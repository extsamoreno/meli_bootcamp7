package practicaTM.ejercicio3;

public class Main {

    public static void main(String[] args) {
        MarteGroupSA marte = new MarteGroupSA();

        agregarCohetes(marte);
        agregarInvitados(marte);

        marte.festejar();

    }

    public static void agregarInvitados(MarteGroupSA marte) {
        for (int i = 0; i < 5; i++) {
            marte.agregarInvitado(new InvitadoEstandar());
            marte.agregarInvitado(new InvitadoMeli());
        }
    }

    public static void agregarCohetes(MarteGroupSA marte) {
        for (int i = 0; i < 3; i++) {
            marte.agregarFuegoArtificial(new FuegoArtificial("PA"));
        }
        marte.agregarFuegoArtificial(coheteCompuesto());
    }

    public static FuegoArtificial coheteCompuesto() {
        FuegoArtificial cohete= new FuegoArtificial("PIM");
        cohete.agregarCohete(new FuegoArtificial("PUM"));
        cohete.agregarCohete(new FuegoArtificial("PAM"));
        return cohete;
    }

}
