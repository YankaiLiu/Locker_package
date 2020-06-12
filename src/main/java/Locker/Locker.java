package Locker;

public class Locker {

    private int lockCount;

    public void setLockCount(int count) {
        this.lockCount = count;
    }

    public LockerTicket savePackage(UserPackage pack) {
        if (lockCount == 0) { return null; }
        return new LockerTicket();
    }
}
