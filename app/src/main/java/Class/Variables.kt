package Class

//class Variables {
//}
fun main(){
    //Numeric variables
    val age:Int =20
    val long_number:Long = 789123128937
    val temperature:Float = 27.33f
    val weight:Double = 64.1231

    //String variables
    val gender:Char = 'M'
    val name:String = "Mariana Velasco"

    //Bool variables
    val isGreater:Boolean = false

    //Collection variables
    val names = arrayOf("Erick", "Sofia", "Javier", "Veronica")

    println(age)
    println("push") //prueba para hacer de nuevo el push porque el primero no funciono
    println("Welcome $name, to your first Kotlin project")
    println (add())
    println (product (5,8))
    printArray(names)

    val numbers = arrayOf(1,2,3,4,5,6,7,8,9,10)
    isEven (numbers)

    println(getDay(1)) //Imprime funcion getDay

    val person = Person ("Fernanda",21) //para la clase Person
    person.displayInformation() //para mandar llamar la funcion con el metodo
    println(person.name)
    println(person.age)//imprimir solo un atributo
}
fun add() :Int{ //funcion añadir
    val x = 10
    val y = 5
    return (x + y) //regresa los valores de la funcion
}
fun product (x: Int, y: Int): Int{
    return (x * y)

}
fun printArray (names:Array<String>){
    println(names)
    for (name in names){ //crea la variable name donde almacena lo que hay en el arreglo names
        println("Hello $name")

    }
}
fun isEven(numbers:Array<Int>){
    for (number in numbers ){
        if (number %2 ==0){
            println("The number $number is even")
        }else {
            println("The number $number is odd")
        }
    }
}
fun getDay(day:Int):String{
    var name=""
    when (day){
        1 -> name = "Monday" //se hace la asignación en una sola línea de lo contrario se ponen llaves
        2 -> name = "Tuesday"
        3 -> name = "Wednesday"
        4 -> name = "Thursday"
        5 -> name = "Friday"
        6 -> name = "Saturday"
        7 -> name = "Sunday"
        else -> name = "Incorrect value"
    }
    return name
}
class Person (val name:String, val age:Int){
    fun displayInformation (){
        println("Name: $name Age: $age")

    }
}
