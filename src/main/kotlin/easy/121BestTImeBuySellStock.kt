package easy

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
fun maxProfitMyAns(prices: IntArray): Int {
    var profit = 0
    var min : Int? =null
    for(price in prices){

        if(min == null){
            min = price
        }else{
            if(price == min) continue
            if(price > min ){
                if( profit < price - min){
                    profit = price - min
                }else {
                    continue
                }
            }else{
                min = price
            }

        }
    }
    return profit
}

fun main(){
    val input = intArrayOf(7,6,4,3,1)
    print(maxProfitMyAns(input))
}