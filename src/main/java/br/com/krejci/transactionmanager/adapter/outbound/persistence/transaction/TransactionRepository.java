package br.com.krejci.transactionmanager.adapter.outbound.persistence.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    @Query( value = "select sum (AMOUNT) from TRANSACTIONS GROUP BY ACCOUNT_ID", nativeQuery = true)
    public Integer findTotalAmountByAccount(Long accountId);

    public Optional<TransactionEntity> findFirstTransactionByAccountId(Long accountId);

}
