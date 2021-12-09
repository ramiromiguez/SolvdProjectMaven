package com.solvd.gym.concurrency;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Connection {
    private final static Logger LOG = Logger.getLogger(Connection.class.getName());

    public void pingBD(String message) {
	LOG.log(Level.INFO, "=====PING======= " + message);
    }

    public void authBD(String message) {
	LOG.log(Level.INFO, "=====AUTHORIZE======= " + message);
    }

    public void infoBD(String message) {
	LOG.log(Level.INFO, "=====INFO====== " + message);
    }

    public void executeQuery(String message) {
	LOG.log(Level.INFO, "=====EXECUTE===== " + message);
    }

    public void close(String message) {
	LOG.log(Level.INFO, "=====CLOSE===== " + message);
    }
}
