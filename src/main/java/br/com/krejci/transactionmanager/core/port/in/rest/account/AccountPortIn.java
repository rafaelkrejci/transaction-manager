package br.com.krejci.transactionmanager.core.port.in.rest.account;

import br.com.krejci.transactionmanager.core.domain.model.AccountModel;

import java.util.Optional;

public interface AccountPortIn {

    public AccountModel createAccount(Long documentNumber, Integer limit);

    public Optional<AccountModel> findAccountById(Long id);

    public Optional<AccountModel>  findAccountByDocumentNumber(Long documentNumber);
}
