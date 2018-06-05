package com.imao.demo.quartz;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;
import org.apache.log4j.Logger;


public class ThreadPoolManager
{
	private static final Logger log = Logger.getLogger(ThreadPoolManager.class);  
    private static Hashtable<String,ThreadPoolManager> tb =  new Hashtable<String,ThreadPoolManager>();

    // 线程池维护线程的最少数量
    private final static int CORE_POOL_SIZE = 100;

    // 线程池维护线程的最大数量
    private final static int MAX_POOL_SIZE = 5000;

    // 线程池维护线程所允许的空闲时间
    private final static int KEEP_ALIVE_TIME = 180;

    // 线程池所使用的缓冲队列大小
    private final static int WORK_QUEUE_SIZE = 500000;

    // 请求Request缓冲队列
    Queue<Runnable> msgQueue = new LinkedList<Runnable>();

    // 访问请求Request缓存的调度线程
    final Runnable accessBufferThread = new Runnable()
    {
        public void run()
        {
            // 查看是否有待定请求，如果有，则添加到线程池中
            if( hasMoreAcquire() )
            {
            	Runnable task = ( Runnable ) msgQueue.poll();
                threadPool.execute( task );
            }
        }
    };

   
    //handler - 由于超出线程范围和队列容量而使执行被阻塞时所使用的处理程序
    final RejectedExecutionHandler handler = new RejectedExecutionHandler()
    {
        public void rejectedExecution( Runnable r, ThreadPoolExecutor executor )
        {
        	log.debug((Runnable )r+" request 放入队列中重新等待执行");
            msgQueue.offer(( Runnable ) r  );
        }
    };


    // 管理线程池
    final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
            CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS,
            new ArrayBlockingQueue( WORK_QUEUE_SIZE ),this.handler);

    // 调度线程池
    final ScheduledExecutorService scheduler = Executors
            .newScheduledThreadPool( 1 );

    //定时调度
    final ScheduledFuture taskHandler = scheduler.scheduleAtFixedRate(
            accessBufferThread, 0, 1, TimeUnit.SECONDS );

    
    
    /**
     * 根据key取得对应实例
     * @param key
     * @return
     */
    public static synchronized ThreadPoolManager getInstance( String key )
    {
    	ThreadPoolManager obj = tb.get(key);
    	System.out.println(key+"-----------------------key");
    	if( obj == null )
    	{
    		log.debug("new thread pool :"+key);
    		obj = new ThreadPoolManager();
    		System.out.println(obj+"-----------------------obj");
    		tb.put(key, obj);
    	}
    	
        return obj;
    }

    private ThreadPoolManager(){}

    private boolean hasMoreAcquire()
    {
        return !msgQueue.isEmpty();
    }

    public void addTask( Runnable task )
    {
        threadPool.execute( task );
    }
}

 

 

