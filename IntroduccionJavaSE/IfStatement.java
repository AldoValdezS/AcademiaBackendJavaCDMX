public class IfStatement {
    public static void main(String[] args) {
        boolean isBluetoothEnabled = false;
        int fileSended = 3;
        if (isBluetoothEnabled){
            fileSended++;
            System.out.println("Enviando archivo");
        }
        else {
            System.out.println("Bluetooth apagado");
        }
    }
}
