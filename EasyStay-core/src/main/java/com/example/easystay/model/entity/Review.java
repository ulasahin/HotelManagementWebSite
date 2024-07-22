package com.example.easystay.model.entity;

import com.example.easystay.core.report.log.CrudEventListener;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(CrudEventListener.class)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.DATE)
    private Date reviewDate;

    private int rating;
    private String reviewText;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
