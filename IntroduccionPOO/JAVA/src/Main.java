package JAVA;
class Main {
    public static void main(String[] args) {
         
        UberX uberX = new UberX("AAMW123", new Account("Aldo vs", "And123"),"Chevrolet"," prueba" );
        uberX.setPassenger(4);
        uberX.printDataCar();

        UberVan uberVan = new UberVan("AWAM", new Account("Ivan Cast", "passport"));
        uberVan.setPassenger(4);
        uberVan.printDataCar();


        User usuario = new User(1, "Pedro", "credencial", "pedro@gmail.com", "1234");
        usuario.data();
    }
}