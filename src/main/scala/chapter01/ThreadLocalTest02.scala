package chapter01

object ThreadLocalTest02 {

    val threadLocal = new ThreadLocal[String]()

    def main(args: Array[String]): Unit = {

        threadLocal.set("hello world")

        val threadOne = new Thread(new Runnable {
            override def run(): Unit = {
                //threadLocal是在主线程中设定的，当前线程访问不到，所以返回null，get方法是针对当前线程而言的
                println("threadOne" + ": " + threadLocal.get())
            }
        })

        threadOne.start()

        println("main: " + threadLocal.get())

    }
}
