package br.com.krejci.transactionmanager.adapter.outbound.persistence.transaction;

import br.com.krejci.transactionmanager.core.domain.model.TransactionModel;
import br.com.krejci.transactionmanager.core.port.out.transaction.TransactionPortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionPersistence implements TransactionPortOut {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public TransactionModel save(TransactionModel transactionModel) {
        TransactionEntity entity = transactionRepository.save(TransactionMapperPersistence.to(transactionModel));
        return TransactionMapperPersistence.to(entity);
    }

    @Override
    public Integer findTotalAmountByAccount(Long accountId) {
        return transactionRepository.findTotalAmountByAccount(accountId);
    }

    @Override
    public boolean existTransactionsForAccount(Long accountId) {
        return transactionRepository.findFirstTransactionByAccountId(accountId).isPresent();
    }
}
