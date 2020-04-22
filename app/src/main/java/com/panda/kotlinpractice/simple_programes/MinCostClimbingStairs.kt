package com.panda.kotlinpractice.simple_programes

import kotlin.math.min

fun main() {
    minCostClimbingStairs(intArrayOf(0,31,20,2))
}

fun minCostClimbingStairs(cost: IntArray): Int {
    require(cost.size != 0){"Require non empty array"}
    var total = 0
    var i = 0
    while (i < cost.size - 1){
        if(cost[i] == 0){
            i++
            continue
        }
        if (cost[i] > cost[i+1] || cost[i] == cost[i+1]){
            total += cost[i+1]
            i = i +2

        }else{
            total = total + cost[i]
            i++
        }
    }
    print(" total : $total")
return total
}