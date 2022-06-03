package br.com.krejci.transactionmanager.core.usecase;

import br.com.krejci.transactionmanager.core.domain.model.AccountModel;
import br.com.krejci.transactionmanager.core.port.in.rest.account.AccountPortIn;
import br.com.krejci.transactionmanager.core.port.out.account.AccountPortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountUseCase implements AccountPortIn {

    @Autowired
    private AccountPortOut accountPortOut;

    public AccountModel createAccount(Long documentNumber){

        AccountModel account = new AccountModel();
        account.setDocumentNumber(documentNumber);
        return accountPortOut.save(account);
    }

    public Optional<AccountModel>  findAccountById(Long id){

        return accountPortOut.findById(id);
    }

    public Optional<AccountModel>  findAccountByDocumentNumber(Long documentNumber){

        return accountPortOut.findByDocumentNumber(documentNumber);
    }
}
