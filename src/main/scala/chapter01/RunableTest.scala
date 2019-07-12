package chapter01

object RunableTest {
    class RunableTask extends Runnable {
        override def run(): Unit = println("I am a child thread.")
    }

    def main(args: Array[String]): Unit = {
        val task = new RunableTask()
        new Thread(task).start()
        new Thread(task).start()
    }
}
