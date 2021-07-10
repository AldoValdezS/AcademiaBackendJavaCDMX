import java.util.Scanner;

public class DoWhileLoop {
    public static void main(String[] args) {
        int response = 0;
        do {

            System.out.println("Selecciona el número de la opción deseada");
            System.out.println("1. Movies");
            System.out.println("2. Series");
            System.out.println("0. Salir");
            Scanner opc = new Scanner(System.in);
            response = Integer.valueOf(opc.nextLine());
            switch (response){
                case 1:
                    System.out.println("Sección de Movies");
                    break;
                case 2:
                    System.out.println("Sección de Series");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Ingrese un valor válido");
            }

        }while (response!=0);
        System.out.println("Saliendo...");
    }
}
