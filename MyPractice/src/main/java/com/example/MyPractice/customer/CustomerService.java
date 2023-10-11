package com.example.MyPractice.customer;

import com.example.MyPractice.exception.DuplicateResourceException;
import com.example.MyPractice.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerDao customerDao;

    public CustomerService(@Qualifier("jpa") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers(){
        return customerDao.selectAllCustomers();
    }

    public Customer getCustomer(Integer id){
        return customerDao.selectCustomerById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id [%s] Not Found"
                        .formatted(id)));
    }

    public void addCustomer(CustomerRegistrationRequest customerRegistrationRequest){

        String email = customerRegistrationRequest.email();

        if(customerDao.existsUserWithEmail(email)){
            throw new DuplicateResourceException("User with Email Already Exists".formatted(email));
        }

        Customer customer = new Customer(
                customerRegistrationRequest.name(),
                customerRegistrationRequest.email(),
                customerRegistrationRequest.age()
        );
        customerDao.insertPerson(customer);

    }

    public void deleteCustomerById(Integer customerId){

        if(!customerDao.existsUserWithId(customerId)) {
             throw new ResourceNotFoundException("Customer with id [%s] Not Found"
                    .formatted(customerId));
        }
            customerDao.deleteUserWithId(customerId);
    }


//    public Customer(String name, String email, Integer age)

}
