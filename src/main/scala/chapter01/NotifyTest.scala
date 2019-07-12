package chapter01

object NotifyTest {
    @volatile //不稳定的、可变的
    var resourceA = new Object()

    def main(args: Array[String]): Unit = {
        val threadA = new Thread(new Runnable {
            override def run(): Unit = {
                resourceA.synchronized {
                    println("threadA get resourceA lock.")
                    try {
                        println("threadA begin wait")
                        resourceA.wait()
                        println("threadA end wait")
                    } catch {
                        case e: InterruptedException => e.printStackTrace()
                    }
                }
            }
        })

        val threadB = new Thread(new Runnable {
            override def run(): Unit = {
                resourceA.synchronized {
                    println("threadB get resourceA lock.")
                    try {
                        println("threadB begin wait")
                        resourceA.wait()
                        println("threadB end wait")
                    } catch {
                        case e: InterruptedException => e.printStackTrace()
                    }
                }
            }
        })

        val threadC = new Thread(new Runnable {
            override def run(): Unit = {
                resourceA.synchronized {
                    println("threadC begin notify")
                    //resourceA.notify()
                    resourceA.notifyAll()
                }
            }
        })

        threadA.start()
        threadB.start()

        //Thread.sleep(2000)
        threadC.start()

        threadA.join()
        threadB.join()
        threadC.join()

        println("main over...")
    }
}
