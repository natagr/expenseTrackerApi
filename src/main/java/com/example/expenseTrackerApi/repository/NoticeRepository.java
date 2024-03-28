package com.example.expenseTrackerApi.repository;

import com.example.expenseTrackerApi.model.Loan;
import com.example.expenseTrackerApi.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer> {

    @Query("SELECT n FROM Notice n WHERE CURRENT_DATE BETWEEN n.noticBegDt AND n.noticEndDt")
    List<Notice> findAllActiveNotices();


}
