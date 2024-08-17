package com.readyauction.app.auction.service;

import com.readyauction.app.auction.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Slf4j
@RequiredArgsConstructor
public class AuctionCloseScheduler {
//일분 마다 업데이트
    final BidService bidService;
    @Scheduled(cron = "0 * * * * *")	// 1분마다
    public void closeAuction() throws Exception {
        System.out.println("옥션마감!");
        bidService.endAuction();

        alarmToWinner();
    }
    public void alarmToWinner(){
        log.info("alarmToWinner");
    }

}