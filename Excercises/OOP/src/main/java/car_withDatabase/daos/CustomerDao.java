package car_withDatabase.daos;

import car_withDatabase.models.Customer;

public interface CustomerDao {
    Customer getCustomer(String name, String pw);
    void registerCustomer(String name, String pw);
}
