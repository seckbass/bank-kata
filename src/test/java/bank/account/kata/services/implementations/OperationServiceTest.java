package bank.account.kata.services.implementations;

import bank.account.kata.models.Account;
import bank.account.kata.models.Operation;
import bank.account.kata.models.OperationType;
import bank.account.kata.services.IAccountService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class OperationServiceTest {


    // Mocking of OperationRepository

    @Mock
    IAccountService accountService;


    //Injection
    OperationService operationService;


    @Test
    void deposit() throws Exception {
        // Mockito.when(Repositoty..........
        Mockito.when(accountService.findByIdClient(1L)).thenReturn(Account.builder().amount(60.0).build());

        Operation operation = operationService.deposit(20.0, 1L);

        assertEquals(80.0, operation.getAmount());
        assertEquals(OperationType.DEPOSIT, operation.getType());

    }

    @Test
    void withdrawal() {
    }

    @Test
    void history() {
    }
}