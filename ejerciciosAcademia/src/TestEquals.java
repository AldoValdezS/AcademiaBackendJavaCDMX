class Person { }

class Student {
    int id;
    Student(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
//        Comprobar si apuntan a la misma dirección de memoria
        if(this == obj ){
            return true;
        }
//        Comprobar si son de la misma clase
        if (obj instanceof Student) {
//        Repornar un booleano si sus atributos son iguales, pero primero castear el obj a la clase Student.
            return this.id == ((Student) obj).id;
        }

        return false;

    }
}

public class TestEquals {
    public static void main(String[] args) {
        Person p = new Person();
        Student s1 = new Student(1001);
        Student s2 = new Student(1001);
        System.out.println(s1.equals(p));
        System.out.println(s1.equals(s2));
    }
}
