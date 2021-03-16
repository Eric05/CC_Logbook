package car_withDatabase.models;

public class Customer {
    private String username;
    private String pw;
    private Car rented;

    public Customer(String username, String pw) {
        this.username = username;
        this.pw = pw;
        this.rented = null;
    }

    public Customer(String name, Car car) {
        this.username = name;
        this.rented = car;
    }

    public void orderCar(Car car){
        this.rented = car;
    }

    public String getUsername() {
        return username;
    }

    public String getPw() {
        return pw;
    }


}
