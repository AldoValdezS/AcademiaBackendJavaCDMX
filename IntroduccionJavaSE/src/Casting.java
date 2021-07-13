public class Casting {
    public static void main(String[] args) {
        double monthDogs = 30.0/12.0;
        System.out.println("monthDogs = " + monthDogs);

        int stimateMonthlyDogs = (int)monthDogs;
        System.out.println("stimateMonthlyDogs = " + stimateMonthlyDogs);
        int a = 30;
        int b = 12;
        System.out.println((double) a/b);

        double c = (double) a/b;
        System.out.println("c = " + c);
        char n = '1';
        int nI = n;
        System.out.println("n = " + nI);

        short nS = (short)n;
        System.out.println("nS = " + nS);
        char p = 'z';
        int pI = p;
        System.out.println("pI = " + pI);
        
        int i = 250;
        long iL = i;
        System.out.println("iL = " + iL);
        short iS = (short) iL;
        System.out.println("iS = " + iS);
        
        double d = 301.067;
        long dL = (long) d;
        System.out.println("dL = " + dL);
        
        int entero = 100;
        entero +=5000.66;
        System.out.println("(float)entero = " + (float)entero);

        int mul = 737*100;
        byte bMul = (byte) mul;
        System.out.println("bMul = " + bMul);
    }

}
