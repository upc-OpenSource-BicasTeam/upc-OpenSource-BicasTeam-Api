package com.bicasteam.movigestion.api.domain.services;

import com.bicasteam.movigestion.api.domain.model.aggregates.Report;
import com.bicasteam.movigestion.api.domain.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportQueryService {
    private final ReportRepository reportRepository;

    @Autowired
    public ReportQueryService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public Optional<Report> getReportById(Long reportId) {
        return reportRepository.findById(reportId);
    }

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }
}
