package Locker;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;
import org.junit.rules.ExpectedException;

public class LockerTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_get_ticket_when_save_bag_given_bag_and_locker_is_not_full() throws LockerException {
        final UserPackage pack = new UserPackage();
        final Locker locker = new Locker();
        locker.setLockCount(1);

        final LockerTicket ticket = locker.savePackage(pack);

        Assert.assertNotNull(ticket);
    }

    @Test
    public void should_be_get_reminder_locker_is_full_when_pick_up_given_bag() throws LockerException {

        thrown.expect(LockerException.class);
        thrown.expectMessage(ExceptionMessages.NO_CAPACITY);

        final UserPackage pack = new UserPackage();
        final Locker locker = new Locker();
        locker.setLockCount(0);

        final LockerTicket ticket = locker.savePackage(pack);
    }

    @Test
    public void should_get_package_when_pick_up_given_valid_ticket() throws LockerException {
        final Locker locker = new Locker();
        final UserPackage pack = new UserPackage();
        locker.setLockCount(5);
        final LockerTicket ticket = locker.savePackage(pack);

        final UserPackage pickedPack = locker.pickUp(ticket);

        Assert.assertEquals(pack, pickedPack);
    }

    @Test
    public void should_reminder_invalid_ticket_when_pick_up_given_invalid_ticket() throws LockerException {

        thrown.expect(LockerException.class);
        thrown.expectMessage(ExceptionMessages.INVALID_TICKET);

        Locker locker = new Locker();
        UserPackage pack = new UserPackage();
        LockerTicket ticket = new LockerTicket();

        UserPackage pickedPack = locker.pickUp(ticket);
    }

    @Test
    public void should_reminder_ticket_has_been_used_when_pick_up() throws LockerException {

        thrown.expect(LockerException.class);
        thrown.expectMessage(ExceptionMessages.TICKET_HAS_BEEN_USED);

        final Locker locker = new Locker();
        final UserPackage pack = new UserPackage();
        locker.setLockCount(5);
        final LockerTicket ticket = locker.savePackage(pack);

        locker.pickUp(ticket);
        locker.pickUp(ticket);
    }
}
