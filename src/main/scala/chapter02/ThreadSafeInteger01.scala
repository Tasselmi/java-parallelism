package chapter02

abstract class ThreadSafeInteger01 {

    var value: Int

    def get: Int = {
        this.synchronized {
            value
        }
    }

    def set(value: Int): Unit = {
        this.synchronized {
            this.value = value
        }
    }

}
