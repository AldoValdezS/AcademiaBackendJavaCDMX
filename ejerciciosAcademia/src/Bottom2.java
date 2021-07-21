
class Top{
    public Top(String s){
        System.out.println("B");
    }
}

public class Bottom2 extends Top {
    public Bottom2(String s){
        super(s);
        //Una clase hija siempre debe llamar al método padre en su constructor con super()
        //Error de compilación si no se llama a super()
        System.out.println("D");
    }

    public static void main(String[] args) {
        new Bottom2("C");
        System.out.println(" ");
    }

}
