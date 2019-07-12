package chapter01

object JoinTest {

    def main(args: Array[String]): Unit = {
        val threadOne = new Thread(new Runnable {
            override def run(): Unit = {
                println("threadOne begin run !")
                while (true) { }
            }
        })

        val mainThread = Thread.currentThread()

        val threadTwo = new Thread(new Runnable {
            override def run(): Unit = {
                try {
                    Thread.sleep(2000)
                } catch {
                    case e: InterruptedException => e.printStackTrace()
                }

                mainThread.interrupt()
            }
        })

        threadOne.start()
        threadTwo.start()

        try {
            threadOne.join()
        } catch {
            case e: InterruptedException => println("main thread: " + e)
        }
    }

}
