package br.com.krejci.transactionmanager.adapter.outbound.persistence.account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    public Optional<AccountEntity> findByDocumentNumber(Long documentNumber);
}
