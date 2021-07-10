/**
 * @author Aldo Valdez Solis
 * */
public class Funciones {

    public static void main(String[] args) {
        double y = 3;
        //círculo
        double area = circleArea(y);
        System.out.println("circle area= "+circleArea(y));
        //esfera
        System.out.println("Sphere area = "+sphereArea(y));
        //volumen
        System.out.println("Sphere volumen= "+sphereVolumen(y));

        System.out.println("200 Pesos a dolares: "+converToDolar(200,"MXN"));
        System.out.println("1000 Pesos colombianos a dolares: "+converToDolar(1000,"COP"));

    }
    /**
     * @since 8/7/2021}
     * Descripción: Calcula el área de un círculo
     * @param r es el radio del círculo
     * @return retorna r, el cuál tiene el valor del área del círculo
     * */
    public static double circleArea(double r){
        return (Math.PI*Math.pow(r,2));
    }

    /**
     * Descripción: Calcula el área de una esfera
     * @param r es el radio de la esfera
     * @return retorna el valor del área de la esfera
     * */
    public static  double sphereArea(double r){
        return 4*Math.PI*Math.pow(r,2);
    }
    /**
     * Descripción: Calcula el volumen de una esfera
     * @param r Es el radio de la esfera
     * @return retorna el volumen de la esfera
     * */
    public static  double sphereVolumen(double r){
        return (4/3)*Math.PI*Math.pow(r,3);
    }


    /**
     * Descripción: función que convierte dinero a una moneda específica
     * @param quantity Cantidad de dinero
     * @param currency Tipo de moneda: sólo acepta MXN o COP
     * @return devuelve quantity que es la cantidad de dinero en dólares
     * */
    public static double converToDolar(double quantity, String currency){
        switch (currency) {
            case "MXN":
                quantity = quantity * 0.052;
                break;
            case "COP":
                quantity = quantity*0.00031;
                break;

        }
        return quantity;
    }
}
