import kotlin.random.Random
fun main(args: Array<String>) {
    println("-- Monty Hall Simulation (Contestant does not switch doors")
    var(current, success, switch)=simulationMonty(0,0,false)
    print(current, success)

    println("-- Monty Hall Simulation (Contestant switches doors)")
    var (currentS, successS, switchS)=simulationMonty(0,0,true)
    print(currentS,successS)

    println("-- 100 Prisoners Simulation (Random box selection)")
    var(currentP, successP)= simulationPrisoner(::randomStrategy)
    print(currentP, successP)
    println("-- 100 Prisoners Simulation (Matching number selection)")
    var(currentM, successM)= simulationPrisoner(::matchStrategy)
    print(currentM, successM)
}
fun print(current: Int, success: Int){
    val percentage = (success.toDouble()/current.toDouble()) * 100
    println("Number of simulations run: $current")
    println("Number of Successes: $success")
    println("Probability of success: $percentage%")

}
fun simulationMonty(currentSim: Int, success: Int, switch: Boolean): Triple<Int, Int, Boolean>{
    var suc = success
    val cur = currentSim+1

    var selected = Random.nextInt(0,3)
    val correctDoor = Random.nextInt(0,3)

    if(currentSim<999 ){

        if(switch){
            val openedDoor = getDoor(selected, correctDoor)
            selected= getDoor(selected, openedDoor)
        }

        if(selected==correctDoor){
            suc++
        }

        return simulationMonty(cur,suc, switch)
    }
    return Triple(cur, suc, switch)
}
fun getDoor(selected:Int, correct:Int): Int{
    for(num in 0..3){
        if(selected!= num && correct!=num){
            return num
        }
    }
    return selected
}

fun simulationPrisoner(strategy: (Int, MutableList<Int>) -> Boolean): Pair<Int, Int>{
    var curSim= 0
    var suc = 0

    while(curSim<10000) {
        var prisoner = 0
        var found = true
        var boxes = generateBoxes()
        while (found && prisoner < 100) {
            found = strategy(prisoner, boxes)
            prisoner++
        }

        if (found) {
            suc++
        }
        curSim++
    }
    return Pair(curSim, suc)
}
fun matchStrategy(prisonNumber: Int, boxes: MutableList<Int>):Boolean{
    var opened = 1
    var boxNumber = boxes[prisonNumber]

    while(opened<50 && boxNumber !=prisonNumber){
        boxNumber = boxes[boxNumber]
        opened++
    }
    return boxNumber == prisonNumber
}

fun generateBoxes(): MutableList<Int>{
    val boxes = (0..99).toMutableList()
    boxes.shuffle()
    return boxes
}
fun randomStrategy(prisonNumber:Int, boxes: MutableList<Int>): Boolean{
    var boxNumber: Int
    var opened = 1
    var randBox = Random.nextInt(0,100)
    boxNumber = boxes[randBox]
    while(opened <50 && boxNumber !=prisonNumber){
        randBox = Random.nextInt(0,100)
        boxNumber = boxes[randBox]
        opened++
    }
    if(boxNumber==prisonNumber){
        return true
    }
    return false
}