public class StringInicialesNombre {
    public static void main(String[] args) {
        String nombre = "Aldo Valdez Solis";
        String [] nombreSeparado = nombre.split(" ");
        for (int i =0;i< nombreSeparado.length; i ++){
            System.out.print(nombreSeparado[i].charAt(0));
        }
    }
}
