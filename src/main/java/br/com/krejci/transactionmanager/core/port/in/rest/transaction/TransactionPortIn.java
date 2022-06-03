package br.com.krejci.transactionmanager.core.port.in.rest.transaction;

import br.com.krejci.transactionmanager.core.domain.model.TransactionModel;

public interface TransactionPortIn {

    public TransactionModel createTransaction(Long accountId, int operation, Integer amount);

    public Integer findTotalTransactionAmountForAccount(Long accountId);

    public boolean existTransactionsForAccount(Long accountId);
}
