package com.bicasteam.movigestion.api.reports.domain.services;

import com.bicasteam.movigestion.api.reports.domain.model.aggregates.Report;
import com.bicasteam.movigestion.api.reports.domain.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportCommandService {
    private final ReportRepository reportRepository;

    @Autowired
    public ReportCommandService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public Report createReport(Report report) {
        return reportRepository.save(report);
    }

    public void deleteReport(Long reportId) {
        reportRepository.deleteById(reportId);
    }
}
