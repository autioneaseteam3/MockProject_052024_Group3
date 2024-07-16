package com.trade.autioneaseproject.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuctionItemRequest {
    private Integer auctionItemID;
    private Integer auctionSessionID;
    private Integer assetID;
    private Float startingBids;
    private Float bidIncrement;
    private Boolean delflag;
}