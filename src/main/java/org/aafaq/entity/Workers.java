package org.aafaq.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Workers {
    @Id
    private Integer worker_id;
    private String worker_name;
    private String worker_city;

    public Workers(){};

    public String getWorker_city() {
        return worker_city;
    }

    public void setWorker_city(String worker_city) {
        this.worker_city = worker_city;
    }

    public String getWorker_name() {
        return worker_name;
    }

    public void setWorker_name(String worker_name) {
        this.worker_name = worker_name;
    }

    public Integer getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(Integer worker_id) {
        this.worker_id = worker_id;
    }
}
