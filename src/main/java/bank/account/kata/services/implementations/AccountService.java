package bank.account.kata.services.implementations;

import bank.account.kata.exceptions.AccountNotFoundException;
import bank.account.kata.models.Account;
import bank.account.kata.services.IAccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {

    // injection of AccountRepository

    @Override
    public Account findByIdClient(Long idClient) throws AccountNotFoundException {
        // TODO
        return null;
    }
}
