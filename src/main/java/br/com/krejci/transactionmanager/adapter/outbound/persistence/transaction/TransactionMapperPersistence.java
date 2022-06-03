package br.com.krejci.transactionmanager.adapter.outbound.persistence.transaction;

import br.com.krejci.transactionmanager.core.domain.model.TransactionModel;

import java.util.Date;

public class TransactionMapperPersistence {

    public static TransactionEntity to(TransactionModel transactionModel){
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAmount(transactionModel.getAmount());
        transactionEntity.setAccountId(transactionModel.getAccountId());
        transactionEntity.setOperationType(transactionModel.getOperationType());
        transactionEntity.setRegistryDate(new Date());
        return transactionEntity;
    }

    public static TransactionModel to(TransactionEntity transactionEntity){
        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setAmount(transactionEntity.getAmount());
        transactionModel.setAccountId(transactionEntity.getAccountId());
        transactionModel.setOperationType(transactionEntity.getOperationType());
        return transactionModel;
    }
}
