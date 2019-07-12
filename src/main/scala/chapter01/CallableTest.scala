package chapter01

import java.util.concurrent.{Callable, ExecutorService, FutureTask, ExecutionException}

object CallableTest {
    //注意这里Callable是需要携带类型参数的
    class CallerTask extends Callable[String] {
        override def call() = "hello"
    }

    def main(args: Array[String]): Unit = {
        val futureTask = new FutureTask[String](new CallerTask())
        new Thread(futureTask).start()

        try {
            //最大的优点就是能够get到返回值
            val result = futureTask.get()
            println(result)
        } catch {
            case e: ExecutionException => e.printStackTrace()
        }
    }
}
