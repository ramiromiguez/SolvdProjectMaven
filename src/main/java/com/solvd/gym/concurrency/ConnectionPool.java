package com.solvd.gym.concurrency;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    public static final int CONNECTIONS_LIMIT = 5;

    private static ConnectionPool conectionPoolObject;
    private List<Connection> connectionPool;
    private List<Connection> usedConnections = new ArrayList<>(CONNECTIONS_LIMIT);

    private ConnectionPool() {
	this.connectionPool = new ArrayList<>(CONNECTIONS_LIMIT);
	for (int i = 0; i < CONNECTIONS_LIMIT; i++) {
	    this.connectionPool.add(new Connection());
	}
    }

    public static ConnectionPool getInstance() {
	if (conectionPoolObject == null) {
	    conectionPoolObject = new ConnectionPool();
	}
	return conectionPoolObject;
    }

    public boolean hasFreeConnections() {
	return !connectionPool.isEmpty();
    }

    public synchronized Connection getConnection() {
	if (connectionPool.isEmpty() || usedConnections.size() > CONNECTIONS_LIMIT) {
	    throw new RuntimeException("No available connections!");
	}

	Connection connection = connectionPool.remove(connectionPool.size() - 1);
	usedConnections.add(connection);
	return connection;
    }

    public synchronized boolean releaseConnection(Connection connection) {
	connectionPool.add(connection);
	return usedConnections.remove(connection);
    }
}
