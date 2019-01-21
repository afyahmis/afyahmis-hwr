package org.afyahmis.hwr.sharedkernel.domain;

import javax.persistence.Entity;

@Entity
public abstract class AggregateRoot<TId> extends BaseEntity<TId> {
}
