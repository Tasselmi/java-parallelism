package chapter02

import scala.concurrent.util.Unsafe
//import sun.misc.Unsafe

object UnsafeTest01 {

    final val unsafe = Unsafe.instance

    private var state: Long = 0

    //import UnsafeTest01._

    //val stateOffset: Long

    try {
        val stateOffset = unsafe.objectFieldOffset(UnsafeTest01.getClass.getDeclaredField("state"))
    } catch {
        case ex: Exception => {
            println(ex.getLocalizedMessage)
            throw new Error(ex)
        }
    }

    def main(args: Array[String]): Unit = {
        val success = unsafe.compareAndSwapInt(UnsafeTest01, state, 0, 1)
        println(success)
    }

}

//object UnsafeTest01 {
//
//}
