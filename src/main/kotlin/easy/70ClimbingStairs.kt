package easy

fun climbStairs(n: Int): Int {
    val mem = Array(n+1){0}

    fun climbStairAux(n: Int):Int{
        if(n == 1){
            mem[1] = 1
            return 1
        }
        if( n == 2){
            mem[2] = 2
            return 2
        }
        if(mem[n] == 0){
            mem[n] = climbStairAux(n-1) + climbStairAux(n-2)
        }
        return mem[n]
    }
    return climbStairAux(n)
}

fun main(){
    print(climbStairs(4))
}