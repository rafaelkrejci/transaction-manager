package br.com.krejci.transactionmanager.adapter.inbound.rest.account;

import br.com.krejci.transactionmanager.core.domain.model.AccountModel;

public class AccountMapper {

    public static AccountDTO toDTO(AccountModel accountModel){
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setDocument_number(accountModel.getDocumentNumber());
        accountDTO.setAccount_number(accountModel.getAccountId());
        return accountDTO;
    }
}
