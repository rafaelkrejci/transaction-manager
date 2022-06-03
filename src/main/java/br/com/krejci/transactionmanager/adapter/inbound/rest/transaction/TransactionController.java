package br.com.krejci.transactionmanager.adapter.inbound.rest.transaction;

import br.com.krejci.transactionmanager.core.port.in.rest.account.AccountPortIn;
import br.com.krejci.transactionmanager.core.port.in.rest.transaction.TransactionPortIn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/transactions")
@Slf4j
public class TransactionController {

    @Autowired
    private AccountPortIn accountPort;
    @Autowired
    private TransactionPortIn transactionPort;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TransactionDTO> createTransaction(@RequestBody TransactionDTO transactionDTO){

        if(accountPort.findAccountById(transactionDTO.getAccount_number()).isEmpty()){
            log.info("account id not found for {}", transactionDTO.getAccount_number());

            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(
                TransactionMapper.transactionDTO(transactionPort.
                createTransaction(transactionDTO.getAccount_number(),transactionDTO.getOperation_type_id(), transactionDTO.getAmount())));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/accounts/{account_id}/totalamount")
    public ResponseEntity<Integer> findTotalTransactionAmountForAccount(@PathVariable(name = "account_id") Long account_id){

        if(!transactionPort.existTransactionsForAccount(account_id)){
            log.info("transaction not found for account id not found for {}", account_id);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(transactionPort.findTotalTransactionAmountForAccount(account_id));
    }
}
