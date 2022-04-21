package com.cydeo.entity;

import com.cydeo.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "payments")
@NoArgsConstructor
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DATE")
    private LocalDate createDate;

    private BigDecimal amount;

    private Status paymentStatus;

    @OneToOne
    @JoinColumn(name = "paymentDetail_id")
    private PaymentDetail paymentDetail;

    public Payment( LocalDate createDate,BigDecimal amount, Status paymentStatus) {
        this.amount = amount;
        this.createDate = createDate;
        this.paymentStatus = paymentStatus;

    }
}
