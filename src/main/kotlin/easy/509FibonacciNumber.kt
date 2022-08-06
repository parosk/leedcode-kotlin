package easy

fun fib(n:Int): Int{
    val mem = Array(n+1){0}

    fun fibAux(n: Int):Int{
        if(n == 0){
            mem[0] = 0
            return 0
        }
        if( n == 1){
            mem[1] = 1
            return 1
        }
       if(mem[n] == 0){
           mem[n] = fibAux(n-1) + fibAux(n-2)
       }
        return mem[n]
    }
     return fibAux(n)
}

fun main(){
    print(fib(3))
}

