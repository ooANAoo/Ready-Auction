package com.readyauction.app.report.service;

import com.readyauction.app.report.dto.ProductReportDto;
import com.readyauction.app.report.entity.ProductReport;
import com.readyauction.app.report.repository.ProductReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductReportService {

    @Autowired
    private ProductReportRepository productReportRepository;

    public ProductReport saveReport(ProductReportDto productReportDto) {
        // 엔티티 저장
        ProductReport report = productReportDto.toEntity();
        return productReportRepository.save(report);
    }

    public List<ProductReport> getAllReports() {
        return productReportRepository.findAll();
    }
}