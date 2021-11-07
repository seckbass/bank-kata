package bank.account.kata.services;

import bank.account.kata.exceptions.OperationErrorException;
import bank.account.kata.models.Operation;

import java.util.List;

public interface IOperationService {

    /**
     * to save money in my account
     * @param amount
     * @param idClient
     * @return
     * @throws OperationErrorException
     */
    Operation deposit(Double amount, Long idClient) throws OperationErrorException;

    /**
     * to retreive money to my account
     * @param amount
     * @param idClient
     * @return
     * @throws OperationErrorException
     */
    Operation withdrawal(Double amount, Long idClient) throws OperationErrorException;

    /**
     * list all my operations
     * @param idClient
     * @return
     */
    List<Operation> history(Long idClient);
}
