package Actividad15;

public class LDNI {
    private int numeroLDNI;
    private final char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

    public LDNI(String dni) {
        numeroLDNI = 0;
    }

    public LDNI(int num) {
        this.numeroLDNI = num;
    }

    public void setNumeroLDNI(int nuevoNum) {
        this.numeroLDNI = nuevoNum;
    }

    public int getNumeroLDNI() {
        return numeroLDNI;
    }

    public char obtenerLetra() {
        int resto;
        resto = numeroLDNI % 23;
        //System.out.println(letras[resto]);
        return letras[resto];
    }
}
