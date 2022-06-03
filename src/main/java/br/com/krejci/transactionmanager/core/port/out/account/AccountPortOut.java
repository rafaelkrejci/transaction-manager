package br.com.krejci.transactionmanager.core.port.out.account;

import br.com.krejci.transactionmanager.core.domain.model.AccountModel;

import java.util.Optional;

public interface AccountPortOut {

    public AccountModel save (AccountModel accountModel);

    public AccountModel update (AccountModel accountModel);

    public Optional<AccountModel> findById(Long accountId);

    public Optional<AccountModel> findByDocumentNumber(Long documentNumber);

}
