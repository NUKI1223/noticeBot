package com.telegram.noticebot.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Entity
@Table(name = "notes")
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String text;
    @Column
    private Date dateOfCreating;
    @Column
    private Date dateOfDeletion;

}
