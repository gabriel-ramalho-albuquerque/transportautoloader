package com.transportation.autodataload.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    @Id
    private long id;
    private String borough;
    private String zone;
    @Column(name = "SERVICE_ZONE")
    private String serviceZone;

    public long getId() {
        return id;
    }

    public String getBorough() {
        return borough;
    }

    public String getZone() {
        return zone;
    }

    public String getServiceZone() {
        return serviceZone;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBorough(String borough) {
        this.borough = borough;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public void setServiceZone(String serviceZone) {
        this.serviceZone = serviceZone;
    }

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
