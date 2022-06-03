package br.com.krejci.transactionmanager.core.usecase;

import br.com.krejci.transactionmanager.core.domain.model.TransactionModel;
import br.com.krejci.transactionmanager.core.port.in.rest.transaction.TransactionPortIn;
import br.com.krejci.transactionmanager.core.port.out.transaction.TransactionPortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionUseCase implements TransactionPortIn {

    @Autowired
    private TransactionPortOut transactionPortOut;

    public TransactionModel createTransaction(Long accountId, int operation, Integer amount){

        TransactionModel transaction = new TransactionModel();
        transaction.setAccountId(accountId);
        transaction.setOperationType(operation);
        transaction.setAmount(calculateAmountBasedbyOperationType(operation,amount));
        return transactionPortOut.save(transaction);
    }

    public Integer findTotalTransactionAmountForAccount(Long accountId){

        return transactionPortOut.findTotalAmountByAccount(accountId);
    }

    public boolean existTransactionsForAccount(Long accountId){

        return transactionPortOut.existTransactionsForAccount(accountId);
    }

    private int calculateAmountBasedbyOperationType (int operationType, int amount){

        if(operationType == 1 || operationType == 2 || operationType == 3 ){
            amount = amount * -1;
        }
        return amount;
    }
}
