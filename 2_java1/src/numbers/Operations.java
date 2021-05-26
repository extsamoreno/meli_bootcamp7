package numbers;

public class Operations {
    public static boolean isPrime(int n){
        boolean res = true;
        int aux = 2;
        while (res && aux < n/2 +1) {
            if ((n % aux) == 0) {
                res = false;
            }
            aux++;
        }
        return res;
    }
}
