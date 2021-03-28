package repository;

import customer.Customer;
import customer.Gender;
import exceptions.CustomerExistException;
import utils.AtmUtils;
import utils.Bootstrap;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerRepository {

    public static final Path customerPath;
    public static final String CUSTOMER_FILE = "customer.txt";

    static {
        customerPath = AtmUtils.getRepoDirectory(CUSTOMER_FILE);
    }

   public Customer addCustomer(Customer customer) {

        long count = AtmUtils.countLines(CUSTOMER_FILE);
        long customerId = (LocalDate.now().getYear() * 1000) + count + 1;

        if(count > 0) {
            try (Stream<String> line = Files.lines(customerPath)) {
                boolean exist = line.skip(1).anyMatch(record -> record.split(",")[1].trim().equals(customer.getId()));
                if (exist) {
                    throw new CustomerExistException("Customer with id number " + customer.getId() + " exists already! Use different id number.");
                }
            } catch (IOException e) {
                // Handle file I/O exception...
            }
        }

        try (BufferedWriter writer = Files.newBufferedWriter(customerPath, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {

            String data = String.format("%d, %s, %s, %s, %s, %s, %s, %s ",customerId, customer.getId(), customer.getFirstName(), customer.getLastName(),
                                            customer.getDateOfBirth(),customer.getGender(),customer.getEmail(),
                                            customer.getAddress());
           writer.newLine();
           writer.append(data);
       } catch (IOException e) {
           // Handle file I/O exception...
       }
       return  customer;
   }

    public Customer updateCustomer(Customer customer) {

        Customer old = findCustomer(customer.getId());
        Customer customerUpdate = update(old, customer);

        Set<Customer> customers = getAllCustomers()
                .stream()
                .collect(Collectors.toSet());

        customers.forEach(c -> {
            if(c.equals(customerUpdate)){
                update(c, customerUpdate);
            }
        });

        AtmUtils.emptyFile(CUSTOMER_FILE);
        Bootstrap.createCustomerHeading();

        try (BufferedWriter writer = Files.newBufferedWriter(customerPath, StandardOpenOption.APPEND)) {
            for(Customer c: customers) {
                String data = String.format("%d, %s, %s, %s, %s, %s, %s, %s ", c.getCid(), c.getId(), c.getFirstName(), c.getLastName(),
                        c.getDateOfBirth(), c.getGender(), c.getEmail(),
                        c.getAddress());
                writer.newLine();
                writer.append(data);
            }
        } catch (IOException e) {
            // Handle file I/O exception...
        }
        return  customer;
    }

    public Customer update(Customer old, Customer update){
        old.setAddress(update.getAddress());
        old.setEmail(update.getEmail());
        old.setLastName(update.getLastName());
        return old;
    }

    public List<Customer> getAllCustomers(){
        try {
           return Files.lines(customerPath).skip(1).map(CustomerRepository::getCustomer).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Customer findCustomer(String id){
        try {
            return getCustomer(
                    Files.lines(customerPath)
                            .skip(1)
                            .filter(record -> record.split(",")[1].trim().equals(id))
                            .findFirst()
                            .get());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Customer getCustomer(String line){
        String [] at = line.split(",");
        Customer customer = new Customer(at[1].trim(), at[2].trim(), at[3].trim(), LocalDate.parse(at[4].trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd")), Gender.valueOf(at[5].trim()));
        customer.setCid(Long.parseLong(at[0].trim()));
        customer.setEmail(at[6].trim());
        customer.setAddress(at[7].trim());
        return customer;
    }
}
