package chapter01

object ThreadLocalTest03 {

    //这里threadLocal必须规定返回类型为ThreadLocal[String]，不然会推导为返回InheritableThreadLocal[String]类型
    //因为InheritableThreadLocal[String]是ThreadLocal[String]的子类
    val threadLocal: ThreadLocal[String] = new InheritableThreadLocal[String]()

    def main(args: Array[String]): Unit = {

        //调用set或者get方法时，会创建当前线程（主线程）的InheritableThreadLocals变量并保存值
        threadLocal.set("hello world")

        //主线程创建子线程时候，会把主线程InheritableThreadLocals里面的本地变量保存一份到子线程的InheritableThreadLocals中
        val threadOne = new Thread(new Runnable {
            override def run(): Unit = {
                println("threadOne" + ": " + threadLocal.get())
            }
        })

        threadOne.start()

        println("main: " + threadLocal.get())

    }
}
