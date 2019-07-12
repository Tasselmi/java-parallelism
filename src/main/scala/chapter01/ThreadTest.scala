package chapter01

object ThreadTest {
    class MyThread extends Thread {
        override def run(): Unit = println("I am a child thread.")
    }

    def main(args: Array[String]): Unit = {
        val thread = new MyThread()
        thread.start()
    }
}
