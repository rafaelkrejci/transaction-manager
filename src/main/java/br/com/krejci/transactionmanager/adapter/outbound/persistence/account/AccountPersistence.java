package br.com.krejci.transactionmanager.adapter.outbound.persistence.account;

import br.com.krejci.transactionmanager.core.domain.model.AccountModel;
import br.com.krejci.transactionmanager.core.port.out.account.AccountPortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AccountPersistence implements AccountPortOut {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountModel save(AccountModel accountModel) {
        AccountEntity entity = accountRepository.save(AccountMapperPersistence.to(accountModel));
        return AccountMapperPersistence.to(entity);
    }

    @Override
    public Optional<AccountModel> findById(Long accountId) {
        Optional<AccountEntity> entity = accountRepository.findById(accountId);
        if (entity.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(AccountMapperPersistence.to(entity.get()));
    }

    @Override
    public Optional<AccountModel> findByDocumentNumber(Long documentNumber) {
        Optional<AccountEntity> entity = accountRepository.findByDocumentNumber(documentNumber);
        if (entity.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(AccountMapperPersistence.to(entity.get()));
    }
}
