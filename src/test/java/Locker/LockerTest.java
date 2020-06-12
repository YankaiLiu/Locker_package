package Locker;

import org.junit.Test;
import org.junit.Assert;
import sun.security.krb5.internal.Ticket;

import java.util.concurrent.locks.Lock;

//TODO Given 还有空柜子， 包  When 存包  Then 存包成功，返回票据
//TODO Given 没有空柜子，包  When 存包  Then 存包失败，不返回票据
//TODO Given 合法的票据   When 取包  Then  取包成功
//TODO Given 不合法的票据 When 取包  Then 取包失败

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
}
