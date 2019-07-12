package chapter01

object InterruptTest02 {

    @throws(classOf[InterruptedException])
    def main(args: Array[String]): Unit = {

        val threadOne = new Thread(new Runnable {
            override def run(): Unit = {
                try {
                    println("threadOne begin sleep for 2000 seconds...")
                    Thread.sleep(1000 * 2000)
                    println("threadOne awaking...")
                } catch {
                    case e: InterruptedException => println("threadOne is interrupted while sleeping...")
                }

                println("threadOne leaving normally...")
            }
        })

        threadOne.start()

        Thread.sleep(1000)

        threadOne.interrupt()

        threadOne.join()
        println("main thread is over...")
    }

}
