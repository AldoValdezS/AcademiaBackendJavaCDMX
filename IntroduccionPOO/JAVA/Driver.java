package JAVA;

public class Driver extends Account{
    Integer id;
    String email;
    String password;
    public Driver(Integer id, String name, String document, String email, String password){
        super(name, document);     
        this.id = id;
        this.email = email;
        this.password = password;
    }
    
}
