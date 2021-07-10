package JAVA;

public class User extends Account{
    Integer id;
    String email;
    String password;
    public User(Integer id, String name, String document, String email, String password){
        super(name, document);     
        this.id = id;
        this.email = email;
        this.password = password;
    }
    void data(){
        System.out.println("id: "+this.id+" Name: "+this.name+ " Document: "+this.document+" email: "+this.email+" Pass: "+this.password);

    }
}
