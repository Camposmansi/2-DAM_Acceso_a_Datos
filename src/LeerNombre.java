public class LeerNombre {

    public static void main(String[] args) {
        if (args.length > 1) { //si hay más de 1 parámetro
            System.out.println("Hay demasiados parámetros. Solo se admite un parametro");
            System.exit(-1);
        } else if (args.length == 0) { //si no hay parámetros
            System.out.println("Falta el nombre de la Serializable.Persona");
            System.exit(1);
        } else {
            System.out.println("Que pasa " + args[0]);
            System.exit(0);
        }
    }
}
