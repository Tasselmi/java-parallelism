package chapter01

object SyncTest {

    case class Person(name: String, age: Int)

    val resourceA = Person("liangfan", 14)
    val resourceB = Person("nijuan", 15)

    def main(args: Array[String]): Unit = {
        //线程B休眠了1秒，线程A先获得了共享变量A和B上的监视器锁
        val threadA = new Thread(new Runnable {
            override def run(): Unit = {
                try {
                    //不同于java的synchronized(resourceA)用法，这里需要注意
                    resourceA.synchronized {
                        println("threadA get resourceA lock.")

                        resourceB.synchronized {
                            println("threadA get resourceB lock.")
                            println("threadA release resourceA lock.")
                            resourceA.wait()
                        }
                    }
                }  catch {
                    case e: InterruptedException => e.printStackTrace()
                }
            }
        })

        val threadB = new Thread(new Runnable {
            override def run(): Unit = {
                try {
                    Thread.sleep(1000)

                    resourceA.synchronized {
                        println("threadB get resourceA lock")

                        //这个地方get不到，因为线程A没有释放资源B的监视锁，只释放了A的
                        println("threadB try get resourceB lock...")
                        resourceB.synchronized {
                            println("threadB get resourceB lock")

                            println("threadB release resourceA lock")
                            resourceA.wait()
                        }
                    }
                } catch {
                    case e: InterruptedException => e.printStackTrace()
                }
            }
        })

        threadA.start()
        threadB.start()

        threadA.join()
        threadB.join()

        println("main over...")
    }

}
