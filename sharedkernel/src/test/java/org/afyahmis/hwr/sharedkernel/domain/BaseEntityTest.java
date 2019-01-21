package org.afyahmis.hwr.sharedkernel.domain;

import org.afyahmis.hwr.sharedkernel.utils.LiveGuid;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class BaseEntityTest {


    TestCar toyota = new TestCar("Toyota");
    TestCar mazda = new TestCar(LiveGuid.NewId(), "Mazda");

    @Test
    public void should_have_id_for_UUID() {
        assertNotNull(toyota.getId());
        System.out.println(toyota);
    }

    @Test
    public void should_have_assigned_id() {
        assertNotNull(mazda.getId());
        System.out.println(mazda);
    }

    @Test
    public void should_check_equality() {
        UUID idA = LiveGuid.NewId();
        UUID idB = LiveGuid.Random();
        TestCar A = new TestCar(idA, "CarA");
        TestCar B = new TestCar(idB, "CarB");
        TestCar C = new TestCar(idA, "CarC");
        TestCar D = new TestCar(idB, "CarD");
        TestCar X = A;
        TestCar Y = B;

        assertEquals(A, C);
        assertEquals(D, B);
        assertEquals(A, X);

        assertNotEquals(A, B);
        assertNotEquals(D, C);
        assertNotEquals(Y, C);

        System.out.println(A);
        System.out.println(C);
        System.out.println(B);
        System.out.println(D);
    }
}

