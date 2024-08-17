package com.readyauction.app.auction.repository;

import com.readyauction.app.auction.dto.TopBidDto;
import com.readyauction.app.auction.entity.Bid;
import com.readyauction.app.auction.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {
    // 여기에 추가적인 쿼리 메서드를 정의할 수 있습니다.

    Optional<Bid> findByMemberIdAndProduct(Long memberId, Product product);
    Optional<List<Bid>> findByProduct(Product product);

    @Query("SELECT new com.readyauction.app.auction.dto.TopBidDto(b.memberId, b.product, MAX(b.myPrice), MAX(b.bidTime)) " +
            "FROM Bid b WHERE b.product IN :products GROUP BY b.memberId, b.product")
    Optional<List<TopBidDto>> findTopBidsByProducts(@Param("products") List<Product> products);
}
