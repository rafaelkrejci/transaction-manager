package br.com.krejci.transactionmanager.core.usecase;

import br.com.krejci.transactionmanager.core.domain.model.AccountModel;
import br.com.krejci.transactionmanager.core.domain.model.TransactionModel;
import br.com.krejci.transactionmanager.core.port.in.rest.transaction.TransactionPortIn;
import br.com.krejci.transactionmanager.core.port.out.transaction.TransactionPortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionUseCase implements TransactionPortIn {

    @Autowired
    private TransactionPortOut transactionPortOut;

    @Autowired
    private AccountUseCase accountUseCase;

    public TransactionModel createTransaction(Long accountId, int operation, Integer amount){

        Optional<AccountModel> acountModel = accountUseCase.findAccountById(accountId);

        TransactionModel transaction = new TransactionModel();
        transaction.setAccountId(accountId);
        transaction.setOperationType(operation);
        transaction.setAmount(calculateAmountBasedbyOperationType(operation,amount, acountModel.get().getLimit()));
        transactionPortOut.save(transaction);

        acountModel.get().setLimit(acountModel.get().getLimit()-amount);
        accountUseCase.update(acountModel.get());

        return transaction;
    }

    public Integer findTotalTransactionAmountForAccount(Long accountId){

        return transactionPortOut.findTotalAmountByAccount(accountId);
    }

    public boolean existTransactionsForAccount(Long accountId){

        return transactionPortOut.existTransactionsForAccount(accountId);
    }

    private int calculateAmountBasedbyOperationType (int operationType, int amount, int limit){

        if(operationType == 1 || operationType == 2 || operationType == 3 ){
            amount = amount * -1;
        }

        if(limit < amount){
            throw new RuntimeException("limite excedido");
        }
        return amount;
    }
}
