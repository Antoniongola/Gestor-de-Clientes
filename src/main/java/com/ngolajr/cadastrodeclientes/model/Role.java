package com.ngolajr.cadastrodeclientes.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

public enum Role {
    ADMIN,
    MANAGER,
    USER
}
