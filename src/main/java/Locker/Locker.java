package Locker;

import sun.security.krb5.internal.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;

public class Locker {

    private int lockCount;
    private Map<LockerTicket, UserPackage> savedPackages = new HashMap<>();

    public void setLockCount(int count) {
        this.lockCount = count;
    }

    public LockerTicket savePackage(UserPackage pack) {
        if (lockCount == 0) { return null; }
        LockerTicket ticket = new LockerTicket();
        savedPackages.put(ticket, pack);
        return ticket;
    }

    public UserPackage pickUp(LockerTicket ticket) {
        UserPackage pack = savedPackages.get(ticket);
        savedPackages.remove(pack);
        return  pack;
    }
}
