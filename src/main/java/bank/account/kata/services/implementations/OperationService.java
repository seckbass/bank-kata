package bank.account.kata.services.implementations;

import bank.account.kata.exceptions.AccountNotFoundException;
import bank.account.kata.exceptions.OperationErrorException;
import bank.account.kata.models.Account;
import bank.account.kata.models.Operation;
import bank.account.kata.models.OperationType;
import bank.account.kata.services.IAccountService;
import bank.account.kata.services.IOperationService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OperationService implements IOperationService {

    // injection of OperationRepository operationRepository

    private final IAccountService accountService;

    public OperationService(IAccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public Operation deposit(Double amount, Long idClient) throws OperationErrorException {
        Account aAccount = getAccount(idClient);
        return saveOperation(amount, aAccount, OperationType.DEPOSIT);
    }

    @Override
    public Operation withdrawal(Double amount, Long idClient) throws OperationErrorException {
        Account aAccount = getAccount(idClient);
        // where overdraft is not allowed
        if(amount > aAccount.getAmount()) {
            throw new OperationErrorException("Overdraft is not allowed");
        }

        return saveOperation(amount, aAccount, OperationType.WITHDRAWAL);
    }

    @Override
    public List<Operation> history(Long idClient) {
        // Call at operationRepository to get all operation of idClient
        return null;
    }

    private Account getAccount(Long idClient) throws OperationErrorException {
        try {
            return accountService.findByIdClient(idClient);
        } catch (AccountNotFoundException e) {
            throw new OperationErrorException("Account not found", e);
        }
    }

    private Operation saveOperation(Double amount, Account aAccount, OperationType type) throws OperationErrorException  {

        try {
            Operation operation = Operation.builder()
                    .idClient(aAccount.getIdClient())
                    .amount(amount)
                    .balance(aAccount.getAmount() - amount)
                    .date(LocalDate.now())
                    .type(type)
                    .build();
            // Map Operation to OperationEntity
            // call to operationRepository for saving OperationEntity
            // Map OperationEntity to Operation

            return operation;

        } catch (Exception e) {
            throw new OperationErrorException("Error to save this operation", e);
        }
    }
}
