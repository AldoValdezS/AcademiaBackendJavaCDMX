class AgedP {
    public AgedP (int x){

    }
    //crear un constructor vacío con sobrecarga
    AgedP(){

    }
}
public class Kinder extends AgedP{
    public Kinder(int x){
        //agregar la llamada al constructor padre
        super();
    }

    //main para comprobar funcionamiento
    public static void main(String[] args) {
        AgedP p = new AgedP(2);

    }

}