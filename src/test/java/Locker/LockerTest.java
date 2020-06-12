package Locker;

import org.junit.Test;
import org.junit.Assert;

public class LockerTest {

    @Test
    public void test_should_be_get_ticket_when_have_empty_locker() {
        //Given
        final UserPackage pack = new UserPackage();
        final Locker locker = new Locker();
        locker.setLockCount(1);

        //When
        final LockerTicket ticket = locker.savePackage(pack);

        //Then
        Assert.assertNotNull(ticket);
    }

    @Test
    public void test_should_be_get_null_when_locker_is_full() {
        //Given
        final UserPackage pack = new UserPackage();
        final Locker locker = new Locker();
        locker.setLockCount(0);

        //When
        final LockerTicket ticket = locker.savePackage(pack);

        //Then
        Assert.assertNull(ticket);
    }

    @Test
    public void test_should_be_get_package_when_ticket_is_valid() {
        //Given
        final Locker locker = new Locker();
        final UserPackage pack = new UserPackage();
        locker.setLockCount(5);
        final LockerTicket ticket = locker.savePackage(pack);

        //When
        final UserPackage pickedPack = locker.pickUp(ticket);

        //Then
        Assert.assertEquals(pack, pickedPack);
    }

    @Test
    public void test_should_be_get_null_when_ticket_is_invalid() {
        //Given
        final Locker locker = new Locker();
        final UserPackage pack = new UserPackage();
        final LockerTicket ticket = new LockerTicket();

        //when
        final UserPackage pickedPack = locker.pickUp(ticket);

        //Then
        Assert.assertNull(pickedPack);
    }
}
