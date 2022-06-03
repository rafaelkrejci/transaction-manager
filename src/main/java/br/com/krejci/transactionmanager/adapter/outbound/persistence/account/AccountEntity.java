package br.com.krejci.transactionmanager.adapter.outbound.persistence.account;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ACCOUNTS")
@Data
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_ID")
    private Long id;

    @Column(name = "DOCUMENT_NUMBER", length = 30, nullable = false, unique = true)
    private Long documentNumber;

    @Column(name = "REGISTRY_DATE", nullable = false, unique = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date registryDate;
}
