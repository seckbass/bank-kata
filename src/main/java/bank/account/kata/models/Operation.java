package bank.account.kata.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Operation {

    private Long idClient;

    private OperationType type;

    private LocalDate date;

    private Double amount;

    private Double balance;
}
