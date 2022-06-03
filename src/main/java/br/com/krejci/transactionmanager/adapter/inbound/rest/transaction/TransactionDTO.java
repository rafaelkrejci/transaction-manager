package br.com.krejci.transactionmanager.adapter.inbound.rest.transaction;

import lombok.Data;

@Data
public class TransactionDTO {

    private Long account_number;

    private int operation_type_id;

    private Integer amount;
}
