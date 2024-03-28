package com.example.expenseTrackerApi.model;

import com.example.expenseTrackerApi.model.base.AbstractIdentifiable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Table(name="contact_messages")
@Getter
@Setter
@RequiredArgsConstructor
public class Contact extends AbstractIdentifiable {

    @Column(name="contact_name")
    private String contactName;

    @Column(name="contact_email")
    private String contactEmail;

    private String subject;

    private String message;

    @Column(name="create_dt")
    private Date createDt;

}
