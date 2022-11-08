import java.util.Scanner;

public class ObtenerLetraDNI {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int numero;
        System.out.print("Por favor, ingrese su numero de DNI: ");
        numero = sc.nextInt();
        DNI dni = new DNI(numero);
        dni.obtenerLetra();
    }


}
class DNI {
    private int numeroDNI;
    private final char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

    public DNI() {
        numeroDNI = 0;
    }

    public DNI(int num) {
        this.numeroDNI = num;
    }

    public void setNumeroDNI(int nuevoNum) {
        this.numeroDNI = nuevoNum;
    }

    public int getNumeroDNI() {
        return numeroDNI;
    }

    public void obtenerLetra() {
        int resto;
        resto = numeroDNI % 23;
        System.out.println("DNI COMPLETO: " + numeroDNI + letras[resto]);
    }
}
