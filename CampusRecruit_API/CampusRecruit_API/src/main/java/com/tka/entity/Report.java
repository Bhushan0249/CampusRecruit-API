package com.tka.entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    private String reportType; // "Job Report", "Student Report", etc.
    private Date generatedDate; // Date the report was generated

    @ManyToOne
    @JoinColumn(name = "generated_by", nullable = false)
    private User generatedBy; // User who generated the report

    private Date startDate;
    private Date endDate;
    private String filters; // String representation of applied filters
    private String exportFormat; // Format: PDF, CSV, etc.
    private String summaryStatistics;
    private String remarks;

    // Getters and Setters
    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public Date getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(Date generatedDate) {
        this.generatedDate = generatedDate;
    }

    public User getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(User generatedBy) {
        this.generatedBy = generatedBy;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public String getExportFormat() {
        return exportFormat;
    }

    public void setExportFormat(String exportFormat) {
        this.exportFormat = exportFormat;
    }

    public String getSummaryStatistics() {
        return summaryStatistics;
    }

    public void setSummaryStatistics(String summaryStatistics) {
        this.summaryStatistics = summaryStatistics;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
