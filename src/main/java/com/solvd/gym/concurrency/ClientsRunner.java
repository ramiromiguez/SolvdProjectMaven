package com.solvd.gym.concurrency;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientsRunner {
    private static final int TIMEOUT = 1000;
    private static final int EXECUTE_QUERY_TIMEOUT = 500;
    private final static Logger LOG = Logger.getLogger(ClientsRunner.class.getName());
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    public static void main(String[] args) {
	Runnable r = () -> {
	    Thread currentThread = Thread.currentThread();
	    String currentThreadName = currentThread.getName();

	    try {
		Thread.sleep(TIMEOUT);
		while (!CONNECTION_POOL.hasFreeConnections()) {
		    LOG.log(Level.INFO, currentThreadName + " in queue");
		    Thread.sleep(TIMEOUT);
		}
		createConnectionWithThreadName(currentThreadName);
	    } catch (InterruptedException e) {
		LOG.log(Level.INFO, e.getMessage());
	    }
	};
	run(r);
    }

    public static void createConnectionWithThreadName(String threadName) throws InterruptedException {
	Connection connection = CONNECTION_POOL.getConnection();
	connection.pingBD(threadName);
	connection.authBD(threadName);
	connection.infoBD(threadName);
	connection.executeQuery(threadName);
	connection.close(threadName);

	Thread.sleep(EXECUTE_QUERY_TIMEOUT);

	CONNECTION_POOL.releaseConnection(connection);
    }

    public static void run(Runnable r) {
	ArrayList<Thread> threads = new ArrayList<>();
	for (int i = 0; i < 7; i++) {
	    threads.add(new Thread(r, "THREAD " + i));
	    threads.get(i).start();
	}
    }

}
