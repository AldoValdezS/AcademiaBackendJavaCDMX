import java.util.HashMap;
import java.util.Map;

class MyKeys {

        Integer key;

        MyKeys(Integer k) { key = k; }

        public boolean equals(Object O) {

            return ((MyKeys) O).key == this.key;

        }

    }
public class PreguntaSorpresa {

    public static void main(String[] args) {

    Map m = new HashMap();

    MyKeys m1 = new MyKeys(1);

    MyKeys m2 = new MyKeys(2);

    MyKeys m3 = new MyKeys(1);

    MyKeys m4 = new MyKeys(new Integer(2));

m.put(

    m1, "car");

m.put(m2, "boat");

m.put(m3, "plane");

m.put(m4, "bus");

System.out.print(m.size());
}
    }

