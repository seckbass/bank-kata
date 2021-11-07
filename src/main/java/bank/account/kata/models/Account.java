package bank.account.kata.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {

    private Long id;

    private Long idClient;

    private Double amount;
}
