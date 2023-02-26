import java.io.File
// Lösningen är tagen från användare soodssr på reddit från posten: https://www.reddit.com/r/adventofcode/comments/r66vow/2021_day_1_solutions/


fun main(){
    fun part1( data: List<String>): Int {
        var previousVal = 0
        var depthInc = 0
        for (i in data) {
            val depth = i.toInt()
            if (previousVal == 0) {
                previousVal = depth
                continue
            }
            if(previousVal < depth) {
                depthInc++
            }
            previousVal= depth
        }
        return depthInc
    }
    fun part2(data: List<String>): Int {
        var arrangedInput = mutableListOf<String>()
        var j = 0
        for(i in data.indices){
            if (data[i].isEmpty()){
                continue
            }
            val elePlusOne = data.getOrNull(i+1)
            val elePlusTwo = data.getOrNull(i+2)
            if(elePlusOne == null || elePlusTwo == null || elePlusOne.isEmpty() || elePlusTwo.isEmpty()) {
                continue
            }
            val sum = (data[i].toInt() + elePlusOne.toInt() + elePlusTwo.toInt()).toString()
            if (arrangedInput.isEmpty()) {
                arrangedInput = mutableListOf(sum)
            }else{
                arrangedInput.add(j,sum)
            }
            j++
        }
        return part1(arrangedInput)
    }

    val data: List<String> = File("src/main/kotlin/Input.txt").readLines()
    println("Part one: ${part1(data)}")
    println("Part two: ${part2(data)}")
}

