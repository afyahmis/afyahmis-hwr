package org.afyahmis.hwr.sharedkernel.domain;

import java.util.UUID;

class TestCar extends BaseEntity<UUID> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestCar(String name) {
        super();
        this.name = name;
    }

    public TestCar(UUID uuid, String name) {
        super(uuid);
        this.name = name;
    }

    @Override
    public String toString() {
        return  getName()+" ["+getId()+"]";
    }
}
