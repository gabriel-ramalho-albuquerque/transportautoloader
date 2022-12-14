package com.transportation.autodataload.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "TRIP")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class YellowTripDTO {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "seqGen")
    @SequenceGenerator(name = "seqGen", sequenceName = "seq", initialValue = 1)
    private long id;

    private long vendorId;

    @Column(name = "PICKUP_DATETIME")
    private LocalDate pickupDateTime;

    @Column(name = "DROPOFF_DATETIME")
    private LocalDate dropoffDateTime;

    private int passengerCount;

    private String tripDistance;

    private long rateCodeId;

    private String storeAndFwdFlag;

    private long pickupLocationId;

    private long dropoffLocationId;

    private long tripTypeId;

    @Override
    public String toString() {
        return "YellowTripDTO{" +
                "id=" + id +
                ", vendorId=" + vendorId +
                ", pickupDateTime=" + pickupDateTime +
                ", dropoffDateTime=" + dropoffDateTime +
                ", passengerCount=" + passengerCount +
                ", tripDistance='" + tripDistance + '\'' +
                ", rateCodeId=" + rateCodeId +
                ", storeAndFwdFlag='" + storeAndFwdFlag + '\'' +
                ", pickupLocationId=" + pickupLocationId +
                ", dropoffLocationId=" + dropoffLocationId +
                ", tripTypeId=" + tripTypeId +
                '}';
    }
}
