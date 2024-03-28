package com.example.expenseTrackerApi.repository;

import com.example.expenseTrackerApi.model.Card;
import com.example.expenseTrackerApi.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {


}
