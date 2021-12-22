package com.altunfatih.bookseller.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.altunfatih.bookseller.model.PurchaseHistory;
import com.altunfatih.bookseller.repository.PurchaseHistoryRepository;
import com.altunfatih.bookseller.repository.projection.PurchaseItem;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PurchaseHistoryServiceImpl implements PurchaseHistoryService {
    private final PurchaseHistoryRepository purchaseHistoryRepository;

    @Override
    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory) {
        purchaseHistory.setPurchaseTime(LocalDateTime.now());

        return purchaseHistoryRepository.save(purchaseHistory);
    }

    @Override
    public List<PurchaseItem> findPurchasedItemsOfUser(Long userId) {
        return purchaseHistoryRepository.findAllPurchasesOfUser(userId);
    }
}
