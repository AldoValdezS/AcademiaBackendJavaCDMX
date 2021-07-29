public class Incr {
    public static void main(String[] args) {
        //Resultado 33
        Integer x = 7;
        int y = 2;

        x *= x; // x = 49
        y *= y; // y = 4
        y *= y;// y= 16
        x -= y; // 33

        System.out.println(x);
    }
}
