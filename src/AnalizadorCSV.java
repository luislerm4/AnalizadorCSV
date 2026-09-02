public class AnalizadorCSV {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Uso: java AnalizadorCSV <archivo.csv>");
            return;
        }

        String archivo = args[0];

        System.out.println("Archivo a procesar: " + archivo);
    }
}