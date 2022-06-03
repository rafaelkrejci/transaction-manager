package br.com.krejci.transactionmanager.adapter.outbound.persistence.transaction;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TRANSACTIONS")
@Data
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "TRANSACTION_ID")
    private Long id;

    @Column(name = "ACCOUNT_ID")
    private Long accountId;

    @Column(name = "OPERATION_TYPE_ID", nullable = false, unique = false)
 //   @Temporal(value = TemporalType.TIMESTAMP)
    //TODO: criar enum
    private int operationType;

    @Column(name = "AMOUNT", nullable = false, unique = false)
    private Integer amount;

    @Column(name = "REGISTRY_DATE", nullable = false, unique = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date registryDate;
}
