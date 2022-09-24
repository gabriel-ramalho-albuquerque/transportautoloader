package com.transportation.autodataload.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Location {

    @Id
    private long id;
    private String borough;
    private String zone;
    @Column(name = "SERVICE_ZONE")
    private String serviceZone;

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", borough='" + borough + '\'' +
                ", zone='" + zone + '\'' +
                ", serviceZone='" + serviceZone + '\'' +
                '}';
    }
}
