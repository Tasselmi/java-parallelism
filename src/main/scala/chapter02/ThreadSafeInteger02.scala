package chapter02

abstract class ThreadSafeInteger02 {

    @volatile
    var value: Int

    def get: Int = value

    def set(value: Int): Unit = {
        this.value = value
    }

}
