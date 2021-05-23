package com.insomnia.java.design.singleton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author insomnia
 */
public class ExecutorThread implements Runnable{

    private  static final Logger LOG = LogManager.getLogger(ExecutorThread.class);
    @Override
    public void run() {
        LazyDoubleCheckSingleton instance = LazyDoubleCheckSingleton.getInstance();
        LOG.info(Thread.currentThread().getName() + ":" + instance);
    }
}
