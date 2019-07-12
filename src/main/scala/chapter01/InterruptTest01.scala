package chapter01

object InterruptTest01 {

    @throws(classOf[InterruptedException])
    def main(args: Array[String]): Unit = {

        val thread = new Thread(new Runnable {
            override def run(): Unit = {
                while (!Thread.currentThread().isInterrupted) {
                    println(Thread.currentThread() + " hello")
                }
            }
        })

        //子线程启动
        thread.start()

        //主线程休眠1秒
        Thread.sleep(1000)

        println("main thread interrupt child thread")
        //打断子线程；如果不打断子线程，那么while后面的println会一直打印下去
        thread.interrupt()

        //等待子线程执行完毕
        thread.join()
        println("main is over...")
    }

}
