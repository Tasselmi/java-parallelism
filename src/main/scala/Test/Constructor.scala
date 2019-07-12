package Test

object Constructor {
    class Student(id:Int){
        def this(id:Int, name:String)={
            this(id)
            println(id+" "+name)
        }
        println(id)
    }

    def main(args:Array[String]){
        new Student(101)
        new Student(100,"Minsu")

        val l = List(1, 2, 3)
    }
}
