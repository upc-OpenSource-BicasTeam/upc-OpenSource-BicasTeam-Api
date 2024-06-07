package com.bicasteam.movigestion.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {
    private final ReportCommandService reportCommandService;
    private final ReportQueryService reportQueryService;

    @Autowired
    public ReportController(ReportCommandService reportCommandService, ReportQueryService reportQueryService) {
        this.reportCommandService = reportCommandService;
        this.reportQueryService = reportQueryService;
    }

    @GetMapping
    public List<Report> getAllReports() {
        return reportQueryService.getAllReports();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Report> getReportById(@PathVariable Long id) {
        return reportQueryService.getReportById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Report createReport(@RequestBody CreateReportCommand command) {
        Report report = new Report(command.idUser(), command.type(), command.description(), command.dateTime());
        return reportCommandService.createReport(report);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReport(@PathVariable Long id) {
        reportCommandService.deleteReport(id);
    }
}
