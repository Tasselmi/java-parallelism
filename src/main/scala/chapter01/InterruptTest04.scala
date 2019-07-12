package chapter01

object InterruptTest04 {

    def main(args: Array[String]): Unit = {

        val threadOne = new Thread(new Runnable {
            override def run(): Unit = {
                //这里与书中也有一定出入，Thread.currentThread无法调用interrupted()
                while (!Thread.interrupted()) { println("I am dead...") }
            }

            println("threadOne isInterrupted: " + Thread.currentThread().isInterrupted)
        })

        threadOne.start()

        threadOne.interrupt()

        threadOne.join()

        println("main thread is over...")
    }

}
