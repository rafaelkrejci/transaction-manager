package br.com.krejci.transactionmanager.adapter.inbound.rest.account;

import lombok.Data;

@Data
public class AccountRequestDTO {

    private Long account_number;
    private Integer limit;
}
