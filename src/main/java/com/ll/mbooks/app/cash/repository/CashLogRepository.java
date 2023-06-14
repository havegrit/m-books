package com.ll.mbooks.app.cash.repository;

import com.ll.mbooks.app.cash.entity.CashLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashLogRepository extends JpaRepository<CashLog, Long> {
}
