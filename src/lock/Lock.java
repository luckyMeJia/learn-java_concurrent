package lock;

public class Lock {
	
	private boolean isLock = false;
	private Thread lockingThread = null;
	
	public synchronized void lock() throws InterruptedException {
		while(isLock) {
		    wait();
		}
		isLock = true;
		lockingThread = Thread.currentThread();
	}
	
	public synchronized void unlock() {
	    if(lockingThread != Thread.currentThread()) {
	        throw new IllegalMonitorStateException("Calling thread has not locked this lock");
	    }
	    isLock = false;
	    lockingThread = null;
	    notify();
	}

}
