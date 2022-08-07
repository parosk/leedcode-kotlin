package medium

/**
You are playing the Bulls and Cows game with your friend.

You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:

The number of "bulls", which are digits in the guess that are in the correct position.
The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.

The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows. Note that both secret and guess may contain duplicate digits.
        */

fun getHintMyAns(secret: String, guess: String): String {
   var bullCount = 0 //right number, right position
    var cowCount = 0 //right number, wrong position
    var countMap = mutableMapOf<Char,Int>()
    val secretChar = secret.toCharArray()
    val guessChar = guess.toCharArray()
    var secretMap = secretChar.mapIndexed { index, c ->  index to c}.toMap()
    secretChar.forEach {
        if(countMap.containsKey(it)){
            val oldValue = countMap[it]
            countMap[it] = oldValue!!+1
        }else{
            countMap[it] = 1
        }
    }

    guessChar.forEachIndexed { index, c ->
        if(secretMap[index] == c){
            bullCount = bullCount + 1
            val oldValue = countMap[c]
            countMap[c] = oldValue!! -1
        }
    }

    guessChar.forEachIndexed { index, c ->
        if(secretMap[index] != c){
           if(countMap.containsKey(c) && countMap[c]!! > 0){
               cowCount = cowCount + 1
               val oldValue = countMap[c]
               countMap[c] = oldValue!! -1
           }
        }
    }

    return "${bullCount}A${cowCount}B"


}

fun main(){
    print(getHintMyAns("1807","7810"))
}