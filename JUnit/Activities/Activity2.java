//writing tests for testing exceptions
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Activity2 {
    //Write two @Test annotations, notEnoughFunds() and enoughFunds().
    @Test
    public void notEnoughFunds(){
        //In notEnoughFunds(),
        //Create an object for the BankAccount and set balance to 10.
        BankAccount objBA = new BankAccount(9);
        //Add an assertion, assertThrows(), that expects the NotEnoughFundsException custom exception to be thrown
        assertThrows(NotEnoughFundsException.class, () -> objBA.withdraw(10));
    }
    @Test
    public void enoughFunds(){
        //In enoughFunds(),
        //Create an object for the BankAccount and set balance to 100.
        BankAccount objBA = new BankAccount(100);
        //Add an assertion, assertDoesNotThrow(), that expects the NotEnoughFundsException custom exception to NOT be thrown.
        assertDoesNotThrow(() -> objBA.withdraw(100));
    }
}
