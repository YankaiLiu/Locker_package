package Locker;

import java.util.concurrent.locks.Lock;

public class LockerException extends Exception {

    public LockerException(String message) {
        super(message);
    }
}
