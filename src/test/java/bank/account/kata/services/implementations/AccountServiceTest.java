package bank.account.kata.services.implementations;

import bank.account.kata.exceptions.AccountNotFoundException;
import bank.account.kata.models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {

    private AccountService accountService = new AccountService();

    @Test
    void findShoulOK() throws AccountNotFoundException {
        // Mockito.when(accountRepository.find(any()))).then(any())
        Account account = accountService.findByIdClient(1L);

        assertEquals(1L, account.getId());
        // etc.
    }

    @Test
    void findShoulKO() throws AccountNotFoundException {
        //Mockito.when(accountRepository.find(any()))).thenThrow(AccountNotFoundException.class)

        assertThrows(AccountNotFoundException.class, () -> accountService.findByIdClient(1L));
    }
}