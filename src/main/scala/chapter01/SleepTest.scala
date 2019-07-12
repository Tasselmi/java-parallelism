package chapter01

import java.util.concurrent.locks.ReentrantLock

object SleepTest {
    final val lock = new ReentrantLock()

    @throws(classOf[InterruptedException])
    def main(args: Array[String]): Unit = {
        val threadA = new Thread(new Runnable {
            override def run(): Unit = {
                lock.lock()

                try {
                    println("child threadA is in sleep")
                    Thread.sleep(3000)
                    println("child threadA is in awaked")
                } catch {
                    case e: InterruptedException => e.printStackTrace()
                } finally {
                    lock.unlock()
                }
            }
        })

        val threadB = new Thread(new Runnable {
            override def run(): Unit = {
                lock.lock()

                try {
                    println("child threadB is in sleep")
                    Thread.sleep(3000)
                    println("child threadA is in awaked")
                } catch {
                    case e: InterruptedException => e.printStackTrace()
                } finally {
                    lock.unlock()
                }
            }
        })

        threadA.start()
//        threadB.start()
        Thread.sleep(1000)
        //主线程中断了A线程
        threadA.interrupt()
    }
}
