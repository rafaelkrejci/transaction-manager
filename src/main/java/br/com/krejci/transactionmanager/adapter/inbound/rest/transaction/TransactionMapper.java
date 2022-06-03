package br.com.krejci.transactionmanager.adapter.inbound.rest.transaction;

import br.com.krejci.transactionmanager.core.domain.model.TransactionModel;

public class TransactionMapper {

    public static TransactionDTO transactionDTO(TransactionModel transactionModel){

        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setAccount_number(transactionModel.getAccountId());
        transactionDTO.setOperation_type_id(transactionModel.getOperationType());
        transactionDTO.setAmount(transactionModel.getAmount());
        return transactionDTO;
    }
}
