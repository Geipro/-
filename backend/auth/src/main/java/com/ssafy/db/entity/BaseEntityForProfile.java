package com.ssafy.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Profile 기반 Entity
 */
@Getter
@Setter
@MappedSuperclass
public class BaseEntityForProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long profileId = null;
}
