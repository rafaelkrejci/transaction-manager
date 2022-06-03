package br.com.krejci.transactionmanager.adapter.inbound.rest.account;

import lombok.Data;

@Data
public class AccountDTO {

    private Long account_number;
    private Long document_number;
    private Integer limit;

}
