package com.example.expenseTrackerApi.model;

import com.example.expenseTrackerApi.model.base.AbstractIdentifiable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="contact_messages")
@Getter
@Setter
@RequiredArgsConstructor
public class Customer extends AbstractIdentifiable {

    private String name;

    private String email;

    @JsonIgnore
    private String pwd;

    private String role;

    @Column(name="create_dt")
    private String createDt;
}
