package dani.kayumbuca.api.v1.model;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "servers")

public class ServerModel implements Serializable {
    private static  final  long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String private_ip;
    @Column
    private String public_ip;

    public String getPublic_ip() {
        return public_ip;
    }
    public void setPublic_ip(String public_ip) {
        this.public_ip = public_ip;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrivate_ip() {
        return private_ip;
    }

    public void setPrivate_ip(String private_ip) {
        this.private_ip = private_ip;
    }
}
