import java.io.File
fun problemOne( data: List<Int>) : Int {

    var y = 0
    var x = 0
    for (a in 0 .. data.size -1){

        if (data[a] > x && x != 0){
            y++}
        x= data[a]

    }
    return y

}
//jag hittade windowed funktionen när jag kollade lite på hur man kunde göra det här och den verkade mycket bättre än sättet jag gjorde det på först.
fun problemTwo(data: List<Int>) : Int {
    var change = 0
    data.windowed(3,1).map{it.sum()}.reduce{a,b -> if (b> a) change++; b}
    return change
}




fun main(){

    val data: List<Int> = File("src/main/kotlin/Input.txt").readLines().map{it.toInt()}

    println(problemOne(data))
    println(problemTwo(data))





}