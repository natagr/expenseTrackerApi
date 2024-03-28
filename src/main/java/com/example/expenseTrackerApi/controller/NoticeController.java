package com.example.expenseTrackerApi.controller;

import com.example.expenseTrackerApi.model.Notice;
import com.example.expenseTrackerApi.repository.NoticeRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeRepository noticeRepository;

    @GetMapping("/notices")
    public List<Notice> getNotices() {
        return noticeRepository.findAllActiveNotices();
    }

}