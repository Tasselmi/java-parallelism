package chapter01

object YieldTest {
    class YieldClass extends Runnable {
        override def run(): Unit = {
            for (i <- 0 to 4) {
                if (i % 5 == 0) println(Thread.currentThread() + " yield cpu...")

                //yield让出了当前线程占用的cpu剩余的时间片，等别的线程执行完了还会再回来执行
                //而sleep不会让出当前线程，会一直霸占，醒来接着执行
                Thread.`yield`()
            }
            println(Thread.currentThread() + " is over...")
        }
    }

    object YieldClass {
        def apply: YieldClass = new YieldClass() {
            val t = new Thread(this)
            t.start()
        }
    }

    def main(args: Array[String]): Unit = {
        YieldClass.apply
        YieldClass.apply
        YieldClass.apply
    }
}
