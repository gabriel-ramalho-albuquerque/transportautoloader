package com.transportation.autodataload.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Trip {

    @Id
    @GeneratedValue
    private long id;

    private long vendorId;

    @Column(name = "PICKUP_DATETIME")
    private LocalDateTime pickupDateTime;

    @Column(name = "DROPOFF_DATETIME")
    private LocalDateTime dropoffDateTime;

    private int passengerCount;

    private String tripDistance;

    private long rateCodeId;

    private String storeAndFwdFlag;

    private long pickupLocationId;

    private long dropoffLocationId;
}