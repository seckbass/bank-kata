package bank.account.kata.services;

import bank.account.kata.exceptions.AccountNotFoundException;
import bank.account.kata.models.Account;

public interface IAccountService {

    /**
     * find account
     * @param idClient
     * @return
     * @throws AccountNotFoundException
     */
    Account findByIdClient(Long idClient) throws AccountNotFoundException;
}
