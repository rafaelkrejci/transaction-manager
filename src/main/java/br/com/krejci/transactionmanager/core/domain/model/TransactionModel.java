package br.com.krejci.transactionmanager.core.domain.model;

import lombok.Data;

@Data
public class TransactionModel {

    private Long transactionId;

    private int operationType;

    private Integer amount;

    private Long accountId;

}
