package com.altunfatih.bookseller.service;

import java.util.List;

import com.altunfatih.bookseller.model.PurchaseHistory;
import com.altunfatih.bookseller.repository.projection.PurchaseItem;

public interface PurchaseHistoryService {
    PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);

    List<PurchaseItem> findPurchasedItemsOfUser(Long userId);
}
