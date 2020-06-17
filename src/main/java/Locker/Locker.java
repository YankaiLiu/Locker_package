package Locker;

import sun.security.krb5.internal.Ticket;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Locker {

    private int lockCount;
    private Map<LockerTicket, UserPackage> savedPackages = new HashMap<>();
    private Set<LockerTicket> usedTickets = new HashSet();

    public void setLockCount(int count) {
        this.lockCount = count;
    }

    public LockerTicket savePackage(UserPackage pack) throws LockerException {
        if (savedPackages.size() == lockCount) {
            throw new LockerException(ExceptionMessages.NO_CAPACITY);
        }
        LockerTicket ticket = new LockerTicket();
        savedPackages.put(ticket, pack);
        return ticket;
    }

    public UserPackage pickUp(LockerTicket ticket) throws LockerException {
        if (usedTickets.contains(ticket)) {
            throw new LockerException(ExceptionMessages.TICKET_HAS_BEEN_USED);
        }
        UserPackage pack = savedPackages.get(ticket);
        if (pack != null) {
            savedPackages.remove(pack);
            usedTickets.add(ticket);
            return  pack;
        }
        throw new LockerException(ExceptionMessages.INVALID_TICKET);
    }
}
