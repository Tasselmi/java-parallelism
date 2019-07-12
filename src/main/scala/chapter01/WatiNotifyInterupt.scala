package chapter01

object WatiNotifyInterupt {

    val obj = new Object()

    //使用throws关键字或throws注释来声明异常
    @throws(classOf[InterruptedException])
    def main(args: Array[String]): Unit = {
        val threadA = new Thread(new Runnable {
            override def run(): Unit = {
                try {
                    println("---begin---")
                    obj.synchronized {
                        obj.wait()
                    }
                    println("---end---")
                } catch {
                    case e: InterruptedException => e.printStackTrace()
                }
            }
        })

        threadA.start()

        Thread.sleep(1000)

        println("---begin interrupt threadA---")
        threadA.interrupt()
        println("---end interupt threadA---")
    }

}
