package com.zenyte.discord.cores

import java.util.concurrent.ThreadFactory
import java.util.concurrent.atomic.AtomicInteger

/**
 * A thread factory for spawning threads for the
 * slow executor service.
 * @author David O'Neill
 */
internal class SlowThreadFactory(private val handler: Thread.UncaughtExceptionHandler) : ThreadFactory {
    
    private val group: ThreadGroup
    private val threadNumber = AtomicInteger(1)
    private val namePrefix: String
    
    init {
        val s = System.getSecurityManager()
        group = if (s != null) s.threadGroup else Thread.currentThread().threadGroup
        namePrefix = "Slow Pool-" + poolNumber.getAndIncrement() + "-thread-"
    }
    
    override fun newThread(r: Runnable): Thread {
        val t = Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0)
        if (t.isDaemon)
            t.isDaemon = false
        if (t.priority != Thread.MIN_PRIORITY)
            t.priority = Thread.MIN_PRIORITY
        t.uncaughtExceptionHandler = handler
        return t
    }
    
    companion object {
        private val poolNumber = AtomicInteger(1)
    }
    
}