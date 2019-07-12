package chapter01

object ThreadLocalTest01 {

    val localVariable = new ThreadLocal[String]()

    def tPrint(str: String): Unit = {
        println(str + ":" + localVariable.get())
        localVariable.remove()
    }

    def main(args: Array[String]): Unit = {

        val threadOne = new Thread(new Runnable {
            override def run(): Unit = {
                localVariable.set("threadOne local variable")
                tPrint("threadOne")
                println("threadOne remove after" + ": " + localVariable.get())
            }
        })

        val threadTwo = new Thread(new Runnable {
            override def run(): Unit = {
                localVariable.set("threadTwo local variable")
                tPrint("threadTwo")
                println("threadTwo remove after" + ": " + localVariable.get())
            }
        })

        threadOne.start()
        threadTwo.start()

    }
}
