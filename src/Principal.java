import com.google.gson.Gson;

import java.util.Map;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        ConsultaMoneda consultaMoneda = new ConsultaMoneda();
        Moneda moneda = consultaMoneda.BuscarMoneda();
        FiltroMoneda filtro = new FiltroMoneda(moneda);

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. ARS (Peso argentino ↔ USD)");
            System.out.println("2. BRL (Real brasileño ↔ USD)");
            System.out.println("3. CLP (Peso chileno ↔ USD)");
            System.out.println("4. COP (Peso colombiano ↔ USD)");
            System.out.println("5. BOB (Boliviano ↔ USD)");
            System.out.println("6. Salir");
            System.out.print("Opción: ");

            int opcion = scanner.nextInt();
            if (opcion == 6) {
                salir = true;
                System.out.println("Gracias por usar el conversor.");
                break;
            }



            String baseCode = "";
            switch (opcion) {
                case 1 -> baseCode = "ARS";
                case 2 -> baseCode = "BRL";
                case 3 -> baseCode = "CLP";
                case 4 -> baseCode = "COP";
                case 5 -> baseCode = "BOB";
                default -> {
                    System.out.println("Opción no válida. Intente nuevamente.");
                    continue;
                }
            }

            System.out.println("Seleccione el tipo de conversión:");
            System.out.println("1. De " + baseCode + " a USD");
            System.out.println("2. De USD a " + baseCode);
            System.out.print("Opción: ");
            int tipoConversion = scanner.nextInt();

            System.out.print("Ingrese el valor a convertir: ");
            double valor = scanner.nextDouble();

            double resultado = 0.0;
            try {
                if (tipoConversion == 1) {
                    // De otra moneda a USD
                    resultado = filtro.monedaAnterior(baseCode, valor);
                    System.out.println("El resultado de la conversión de " + valor + " " + baseCode + " a USD es: " + resultado);
                } else if (tipoConversion == 2) {
                    // De USD a otra moneda
                    resultado = filtro.convertirMoneda(baseCode, valor);
                    System.out.println("El resultado de la conversión de " + valor + " USD a " + baseCode + " es: " + resultado);
                } else {
                    System.out.println("Opción de conversión no válida. Intente nuevamente.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }

}
