package chapter01

object InterruptTest03 {

    def main(args: Array[String]): Unit = {

        val threadOne = new Thread(new Runnable {
            override def run(): Unit = {
                while (true) { }
            }
        })

        threadOne.start()

        threadOne.interrupt()

        println("isInterrupted: " + threadOne.isInterrupted)

        //这里与书本里面有一定出入，因为interrupted()是判断当前线程是否终端，所以直接编译报错
        //所以在当前线程（主线程中）threadOne无法调用interrupted()方法，而下面的主线程可以调用
        //println("isInterrupted: " + threadOne.interrupted())

        println("isInterrupted: " + Thread.interrupted())
        println("isInterrupted: " + threadOne.isInterrupted)

        threadOne.join()
        println("main thread is over...")
    }

}
