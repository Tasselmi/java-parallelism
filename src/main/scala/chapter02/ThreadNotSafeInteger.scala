package chapter02

abstract class ThreadNotSafeInteger {

    var value: Int

    def get: Int = value

    def set(value: Int): Unit = {
        this.value = value
    }

}
