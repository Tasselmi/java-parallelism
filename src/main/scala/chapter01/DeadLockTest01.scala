package chapter01

object DeadLockTest01 {

    case class Person(name: String, age: Int)

    val resourceA = Person("liangfan", 14)
    val resourceB = Person("nijuan", 15)

    def main(args: Array[String]): Unit = {
        //线程B休眠了1秒，线程A先获得了共享变量A和B上的监视器锁
        val threadA = new Thread(new Runnable {
            override def run(): Unit = {
                resourceA.synchronized {
                    println(Thread.currentThread() + " get resourceA")

                    try {
                        Thread.sleep(1000)
                    } catch {
                        case e: InterruptedException => e.printStackTrace()
                    }

                    println(Thread.currentThread() + " waiting get resourceB")
                    resourceB.synchronized {
                        println(Thread.currentThread() + " get resourceB")
                    }
                }
            }
        })

        val threadB = new Thread(new Runnable {
            override def run(): Unit = {
                resourceB.synchronized {
                    println(Thread.currentThread() + " get resourceB")

                    try {
                        Thread.sleep(1000)
                    } catch {
                        case e: InterruptedException => e.printStackTrace()
                    }

                    println(Thread.currentThread() + " waiting get resourceA")
                    resourceA.synchronized {
                        println(Thread.currentThread() + " get resourceA")
                    }
                }
            }
        })

        threadA.start()
        threadB.start()
    }

}
