# Banking Demo
The project is to demonstrate simple banking operations.

## Supported functionality

* get account by account number
* get all accounts
* get transactions by account number

### Installing

To setup please clone the project and run mvn clean install.
Then run the com.kdanil.dkbank.DkBankApplication

### Testing

After startup the following URLs should be responsive in your browser with JSON data

http://localhost:8080/api/accountList

http://localhost:8080/api/account?number=1001
http://localhost:8080/api/account?number=2002

http://localhost:8080/api/transactions?account=1001
http://localhost:8080/api/transactions?account=2002

### Implementation notes

* The application is implemented as simple SpringBoot app
* The model classes Account and Transaction linked to H2 DB using JPA persistence.
* Rest controller is mapped using spring.
* Initial data populated by the script in data.sql
* Lombok library is used to generated som boiler plate code as getters and setters, log declaration, etc.
* Mockito and JUnit4 is used for unit testing

### Author

Danil Klimontov