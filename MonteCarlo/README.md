
//    Formatting:

    //    -- Monty Hall Simulation (Contestant does not switch doors)
    //    Number of simulations run: 1000
    //    Number of successes: 329
    //    Probability of success: 32.9%
    //
    //    -- Monty Hall Simulation (Contestant switches doors)
    //    Number of simulations run: 1000
    //    Number of successes: 699
    //    Probability of success: 69.9%
// Problem description:

    //    The contestant chooses a door.
    //    The game show host chooses a door that doesn't have anything behind it and isn't the door the contestant picked and opens it for the contestant.
    //    The game show host asks the contestant if they would like to change their guess to the only remaining door.
    //    The contest either switches doors or stays with the one they have.
    //    The game show host opens the contestant's door revealing if they have won the prize.
// Requirements:
//    Your program should simulate this scenario 1000 times for each choice and record what the outcome was.
//    You should then report on the probability of winning the prize given each choice.
// Pseudocode:
//     main:
//      call simulation method
//      println(simulations, run, success)
//     method(simulations, success):
//      if(current< 1000): Yeah I know it is inefficient but it works for now
//          simulations run++
//          rand=random number generator out of three
//          if(switch)
//              rand = rand number generator out of two
//          if(rand==0)
//              success++
//          method(simulations run, success)
//      return simulations, run, success


We will be simulating this game with 2 strategies. The first strategy is that every prisoner will randomly pick 50 boxes. 
If all prisoners find their number then record that as a success, otherwise record a failure. You should run this simulation 10000 times (that's ten thousand).

The second strategy is as follows:

    Each prisoner will choose the box at the position that is the same as their number first. Prisoner 20 will start at the 20th box, prisoner 96 will start at the 96th box, and so on.
    The prisoner will then open the box and go to the box at the position that is written in the box. For example, if prisoner 20 opens box 20 and it contains the number 44, then the next box prisoner 20 will pick is the 44th box.
    Repeat the last step until the prisoner either finds their number or has chosen 50 boxes.

If all of the prisoners find their number then record that as a success, otherwise record a failure. You should run this simulation 10000 times also

Your output should match the following (again, your numbers might be slightly different but you should be seeing basically 0% for the first simulation and between 20% and 35% for the second)

-- 100 Prisoners Simulation (Random box selection)
Number of simulations run: 10000
Number of successes: 0
Probability of success: 0%

-- 100 Prisoners Simulation (Matching number selection)
Number of simulations run: 10000
Number of successes: 2110
Probability of success: 21.1%

//First strategy
go through 10000 prisoners
    generate 50 numbers
    make sure 50 numbers do not include any success boxes
    if current prisoner is in 50 num
        move on to next
    else
        return fail