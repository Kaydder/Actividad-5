//Actividad: Elaborar un programa de línea de comandos que actúe como una calculadora de área y de perímetro para las siguientes figuras geométricas: círculo, cuadrado, triángulo, rectángulo, pentágono. El programa debe permitir la elección de la figura, luego permitir la elección de la operación (área o perímetro), luego solicitar los datos para el cálculo y finalmente presentar el resultado en pantalla.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nSeleccione una figura geométrica:");
            System.out.println("1. Círculo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Triángulo");
            System.out.println("4. Rectángulo");
            System.out.println("5. Pentágono");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            int figura = entrada.nextInt();

            if (figura == 6) {
                continuar = false;
                break;
            }

            System.out.println("\nSeleccione la operación:");
            System.out.println("1. Área");
            System.out.println("2. Perímetro");
            System.out.print("Opción: ");
            int operacion = entrada.nextInt();

            double resultado = 0;
            switch (figura) {
                case 1: // Círculo
                    System.out.print("Ingrese el radio: ");
                    double radio = entrada.nextDouble();
                    resultado = (operacion == 1) ? Math.PI * radio * radio : 2 * Math.PI * radio;
                    break;
                case 2: // Cuadrado
                    System.out.print("Ingrese el lado: ");
                    double lado = entrada.nextDouble();
                    resultado = (operacion == 1) ? lado * lado : 4 * lado;
                    break;
                case 3: // Triángulo (equilátero para perímetro)
                    if (operacion == 1) {
                        System.out.print("Ingrese la base: ");
                        double base = entrada.nextDouble();
                        System.out.print("Ingrese la altura: ");
                        double altura = entrada.nextDouble();
                        resultado = (base * altura) / 2;
                    } else {
                        System.out.print("Ingrese la longitud de un lado: ");
                        double ladoTriangulo = entrada.nextDouble();
                        resultado = 3 * ladoTriangulo;
                    }
                    break;
                case 4: // Rectángulo
                    System.out.print("Ingrese la base: ");
                    double baseR = entrada.nextDouble();
                    System.out.print("Ingrese la altura: ");
                    double alturaR = entrada.nextDouble();
                    resultado = (operacion == 1) ? baseR * alturaR : 2 * (baseR + alturaR);
                    break;
                case 5: // Pentágono (regular)
                    System.out.print("Ingrese la longitud de un lado: ");
                    double ladoPentagono = entrada.nextDouble();
                    if (operacion == 1) {
                        System.out.print("Ingrese la apotema: ");
                        double apotema = entrada.nextDouble();
                        resultado = (5 * ladoPentagono * apotema) / 2;
                    } else {
                        resultado = 5 * ladoPentagono;
                    }
                    break;
                default:
                    System.out.println("Opción inválida.");
                    continue;
            }

            String tipoOperacion = (operacion == 1) ? "Área" : "Perímetro";
            System.out.println(tipoOperacion + " calculado: " + resultado);
        }

        System.out.println("¡Hasta luego!");
        entrada.close();
    }
}
