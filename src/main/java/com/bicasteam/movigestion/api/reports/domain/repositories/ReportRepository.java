package com.bicasteam.movigestion.api.reports.domain.repositories;

import com.bicasteam.movigestion.api.reports.domain.model.aggregates.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
}
