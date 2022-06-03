package br.com.krejci.transactionmanager.core.port.out.transaction;

import br.com.krejci.transactionmanager.core.domain.model.TransactionModel;

public interface TransactionPortOut {

    public TransactionModel save(TransactionModel transactionModel);

    public Integer findTotalAmountByAccount(Long accountId);

    public boolean existTransactionsForAccount(Long accountId);

}
