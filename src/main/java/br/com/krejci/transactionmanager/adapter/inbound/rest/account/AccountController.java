package br.com.krejci.transactionmanager.adapter.inbound.rest.account;

import br.com.krejci.transactionmanager.core.domain.model.AccountModel;
import br.com.krejci.transactionmanager.core.port.in.rest.account.AccountPortIn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(value ="/accounts")
@Slf4j
public class AccountController {

    @Autowired
    private AccountPortIn accountPort;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> createAccount(@RequestBody AccountRequestDTO request){

        Optional<AccountModel> accountModel = accountPort.findAccountByDocumentNumber(request.getAccount_number());
        if(accountModel.isPresent()){
            return ResponseEntity.ok().body(accountModel.get().getAccountId().toString());
        }

        return ResponseEntity.status(HttpStatus.CREATED).
                body(accountPort.createAccount(request.getAccount_number()).getAccountId().toString());

    }

    @RequestMapping(method = RequestMethod.GET, path = "/{account_id}")
    public ResponseEntity<AccountDTO> findAccount(@PathVariable(name = "account_id") Long account_id){

        if(accountPort.findAccountById(account_id).isEmpty()){
            log.info("account id not found for {}", account_id);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(AccountMapper.toDTO(accountPort.findAccountById(account_id).get()));
    }
}
