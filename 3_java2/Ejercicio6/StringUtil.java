package Ejercicio6;


public class StringUtil {

    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c,int n)
    {
        String output = "";
        for(int i=0;i<n;i++){
            output=output+c;
        }
        return output;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s,int n, char c)
    {
        String salida =s;
        while(salida.length()!= n ){
            salida=c+salida;
        }
        return salida;

    }
    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[])
    {
        int tamanio = arr.length;
        String[] arrString = new String[tamanio];
        for(int i=0; i<tamanio;i++){
            arrString[i]=String.valueOf(arr[i]);
        }
        return arrString;
    }

    // Retorna un int[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[])
    {
        int tamanio = arr.length;
        int[] intString = new int[tamanio];
        for(int i=0; i<tamanio;i++){
            intString[i]= Integer.parseInt(arr[i]);
        }
        return intString;
    }

    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[])
    {
        int maxLength=0;
        for(int i=0; i<arr.length;i++){
            if(arr[i].length()>maxLength){
                maxLength=arr[i].length();
            }
        }
        return maxLength;
    }
    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[],char c)
    {
        int maxLength = maxLength(arr);

        for(int i=0; i< arr.length;i++){
            if(arr[i].length() < maxLength){
                arr[i]=lpad(arr[i],maxLength, c);
            }
        }
    }
    // Agregando los caracteres a la derecha
    public static String rpad(String s,int n,char c){
        String salida =s;
        while(salida.length()!= n ){
            salida=salida+c;
        }
        return salida;
    }

    //Retorna una cadena idéntica a s pero sin espacios a la izquierda.
    public static String ltrim(String s){
        boolean encontrado=false;
        Character c='n';
        String output="";
        int i =0;
        while (!encontrado){
            if(s.charAt(i)!=' '){
                c=s.charAt(i);
                encontrado=true;
            }
            i++;
        }
        String[] parts = s.split(c.toString());
        for(int j=1; j<parts.length;j++){
            output= output+c.toString()+parts[j];
        }
        return output;

    }
    //Retorna una cadena idéntica a s pero sin espacios a la derecha.
    public static String rtrim(String s){
        boolean encontrado=false;
        Character c='n';
        String output="";
        int i =s.length()-1;
        while (!encontrado){
            if(s.charAt(i)!=' '){
                c=s.charAt(i);
                encontrado=true;
            }
            i--;
        }
        String[] parts = s.split(c.toString());

        for(int j=0; j<parts.length-1;j++){
            output= output+parts[j]+c.toString();
        }
        return output;
    }

    // idem lpad, pero sin espacios a derecha ni izquierda.
    public static String trim(String s){
        String lt = ltrim(s);
        String out = rtrim(lt);
        return out;

    }
    //Retorna la posición de la n-ésima ocurrencia del carácter c dentro de s, o -1 si s no contiene a c
    public static int indexOfN(String s,char c,int n){
        boolean flag = false;
        int i=0;
        int sum=0;
        int ocurrencia=0;
        while(!flag){
            if(s.charAt(i) == c){
                sum++;
            }
            if(sum == n){
                flag=true;
                ocurrencia=i;
            }
            if(i==s.length()-1){
                flag=true;
                ocurrencia=-1;
            }
            i++;
        }
        return ocurrencia;
    }



}

