package com.trade.autioneaseproject.service.impl;

import com.trade.autioneaseproject.entity.AuctionItem;
import com.trade.autioneaseproject.service.AuctionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionItemImpl implements AuctionItemService {
    @Override
    public List<AuctionItem> findAll() {
        return null;
    }
//    @Autowired
//    AuctionItemDAO aidao;
//
//    @Override
//    public List<AuctionItem> findAll() {
//        return aidao.findAll();
//    }

}