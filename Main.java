
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ArrayList<Registro> registros = new ArrayList<>();

        int opcion;

        do {
            System.out.println("\n===== VALIDADOR DE REGISTROS =====");
            System.out.println("1. Registrar datos");
            System.out.println("2. Mostrar registros");
            System.out.println("3. Validar registros");
            System.out.println("4. Mostrar tipos de datos");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opcion: ");

            try {
                opcion = Integer.parseInt(teclado.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Ingresa una opcion numerica.");
                opcion = -1;
                continue;
            }

            switch (opcion) {

                case 1:
                    try {
                        System.out.print("ID: ");
                        int id = Integer.parseInt(teclado.nextLine());

                        System.out.print("Ubicacion: ");
                        String ubicacion = teclado.nextLine();

                        System.out.print("Fecha y hora (dd/MM/yyyy HH:mm): ");
                        String fecha = teclado.nextLine();

                        System.out.print("Valor: ");
                        double valor = Double.parseDouble(teclado.nextLine());

                        System.out.print("Unidad (C, H o P): ");
                        String entradaUnidad = teclado.nextLine();

                        if (entradaUnidad.length() != 1) {
                            System.out.println("Debes ingresar una sola letra.");
                            break;
                        }

                        char unidad = entradaUnidad.charAt(0);

                        System.out.print("Activo (true/false): ");
                        String estado = teclado.nextLine();

                        if (!estado.equalsIgnoreCase("true") &&
                            !estado.equalsIgnoreCase("false")) {
                            System.out.println("Estado no valido.");
                            break;
                        }

                        boolean activo = Boolean.parseBoolean(estado);

                        Registro nuevo = new Registro(
                            id, ubicacion, fecha,
                            valor, unidad, activo
                        );

                        ArrayList<String> errores =
                            Validador.validar(nuevo);

                        if (errores.isEmpty()) {
                            registros.add(nuevo);
                            System.out.println("Registro guardado correctamente.");
                        } else {
                            System.out.println("Registro rechazado:");
                            for (String error : errores) {
                                System.out.println("- " + error);
                            }
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Error: ID o valor numerico incorrecto.");
                    }
                    break;

                case 2:
                    if (registros.isEmpty()) {
                        System.out.println("No hay registros guardados.");
                    } else {
                        for (Registro r : registros) {
                            r.mostrar();
                        }
                    }
                    break;

                case 3:
                    if (registros.isEmpty()) {
                        System.out.println("No hay registros para validar.");
                    } else {
                        for (Registro r : registros) {
                            ArrayList<String> errores =
                                Validador.validar(r);

                            System.out.println("Registro ID: " + r.getId());

                            if (errores.isEmpty()) {
                                System.out.println("Datos validos.");
                            } else {
                                for (String error : errores) {
                                    System.out.println(error);
                                }
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("\nTIPOS DE DATOS UTILIZADOS");
                    System.out.println("int: identificador.");
                    System.out.println("double: valor del registro.");
                    System.out.println("boolean: estado activo.");
                    System.out.println("char: unidad de medida.");
                    System.out.println("String: ubicacion y fecha.");
                    System.out.println("Registro: objeto con todos los datos.");
                    break;

                case 0:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
            }

        } while (opcion != 0);

        teclado.close();
    }
}
