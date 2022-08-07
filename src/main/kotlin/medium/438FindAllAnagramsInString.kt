package medium

/**
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 */
fun findAnagramsMyAns(s: String, p: String): List<Int> {
    if (p.length > s.length) return listOf()
    val map = mutableMapOf<Char,Int>()
     p.toCharArray().forEach {
        if(map.containsKey(it)){
            val value = map[it]
            if (value != null) {
                map[it] = value + 1
            }
        }else{
            map[it] = 1
        }
    }

    val result = mutableListOf<Int>()

    for (i in 0 until s.length - (p.length - 1)) {
        var sMap = mutableMapOf<Char,Int>()
        s.substring(i, i + p.length).toCharArray().forEach {
            if(sMap.containsKey(it)){
                val value = sMap[it]
                if (value != null) {
                    sMap[it] = value + 1
                }
            }else{
                sMap[it] = 1
            }
        }

        if(sMap.equals(map)){
            result.add(i)
        }

    }
    return result.toList()
}

fun main() {
    print(findAnagramsMyAns("cbaebabacd", "abc"))
}