package Locker;

import org.junit.Test;
import org.junit.Assert;

//TODO Given 还有空柜子， 包  When 存包  Then 存包成功，返回票据
//TODO Given 没有空柜子，包  When 存包  Then 存包失败，不返回票据
//TODO Given 合法的票据   When 取包  Then  取包成功
//TODO Given 不合法的票据 When 取包  Then 取包失败

public class LockerTest {

    @Test
    public void test_should_be_get_ticket_when_have_empty_locker() {
        final UserPackage pack = new UserPackage();
        final Locker locker = new Locker();
        final LockerTicket ticket = locker.savePackage(pack);
        Assert.assertNotNull(ticket);
    }

    @Test
    public void test_should_be_get_null_when_locker_is_full() {
        final UserPackage pack = new UserPackage();
        final Locker locker = new Locker();
        final LockerTicket ticket = locker.savePackage(pack);
        Assert.assertNull(ticket);
    }
}
