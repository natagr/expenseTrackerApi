package com.example.expenseTrackerApi.model;

import com.example.expenseTrackerApi.model.base.AbstractIdentifiable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Notice extends AbstractIdentifiable {

    @Column(name="notice_summary")
    private String noticeSummary;

    @Column(name="notice_details")
    private String noticeDetails;

    @Column(name="notic_beg_dt")
    private Date noticBegDt;

    @Column(name="notic_end_dt")
    private Date noticEndDt;

    @Column(name = "create_dt")
    private String createDt;

    @Column(name = "update_dt")
    private Date updateDt;
}
