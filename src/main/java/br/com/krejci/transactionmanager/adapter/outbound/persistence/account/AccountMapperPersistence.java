package br.com.krejci.transactionmanager.adapter.outbound.persistence.account;

import br.com.krejci.transactionmanager.core.domain.model.AccountModel;

import java.util.Date;

public class AccountMapperPersistence {

    public static AccountModel to(AccountEntity entity){
        AccountModel model = new AccountModel();
        model.setAccountId(entity.getId());
        model.setLimit(entity.getLimit());
        model.setDocumentNumber(entity.getDocumentNumber());
        model.setLimit(entity.getLimit());
        return model;
    }

    public static AccountEntity to(AccountModel model){
        AccountEntity entity = new AccountEntity();
        entity.setDocumentNumber(model.getDocumentNumber());
        entity.setLimit(model.getLimit());
        entity.setRegistryDate(new Date());
        return entity;
    }
}
