package com.ll.mbooks.app.cash.service;

import com.ll.mbooks.app.cash.entity.CashLog;
import com.ll.mbooks.app.cash.repository.CashLogRepository;
import com.ll.mbooks.app.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashService {
    private final CashLogRepository cashLogRepository;

    public CashLog addCash(Member member, long price, String relTypeCode, long relId, CashLog.EvenType eventType) {
        CashLog cashLog = CashLog.builder()
                .member(member)
                .price(price)
                .relTypeCode(relTypeCode)
                .relId(relId)
                .eventType(eventType)
                .build();

        cashLogRepository.save(cashLog);

        return cashLog;
    }
}
