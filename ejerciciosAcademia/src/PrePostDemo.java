public class PrePostDemo {
    public static void main(String[] args){
        int i = 3;
        i++;
        System.out.println(i);    // "4"
        ++i;
        System.out.println(i);    // "5"
        System.out.println(++i);  // "6"
        System.out.println(i++);  // "6"
//      El valor 6 se repite 2 veces debido a que primero se hace un preincremento y se imprime,
//      luego se realiza un postincremento lo que indica que primero se imprimirá valiendo aún 6
//      y al final se  incrementará vailendo 7.

        System.out.println(i);    // "7"
    }

}
