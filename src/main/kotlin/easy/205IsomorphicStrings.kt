package easy
/**
 * Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters.
No two characters may map to the same character, but a character may map to itself.
*/
fun isIsomorphicSolution(s: String, t: String): Boolean {
    if(s.equals(t)) return true
    if(s.length != t.length) return false
    val mapSToT = mutableMapOf<Char, Char>()
    val mapTToS = mutableMapOf<Char, Char>()
    val sChars = s.toCharArray()
    val tChars = t.toCharArray()

    for(i in sChars.indices){
        if(!mapSToT.containsKey(sChars[i]) && !mapTToS.containsKey(tChars[i])){

            mapSToT[sChars[i]] = tChars[i]
            mapTToS[tChars[i]] = sChars[i]
        }else{
            if(mapSToT[sChars[i]] != tChars[i] || mapTToS[tChars[i]] != sChars[i] ){
                return false
            }
        }
    }
    return true
}





fun isIsomorphicMyAns(s: String, t: String): Boolean {
    if(s.equals(t)) return true
    if(s.length != t.length) return false
    val map = mutableMapOf<Char, Char>()
    val sChars = s.toCharArray()
    val tChars = t.toCharArray()

    for(i in sChars.indices){
        if(!map.containsKey(sChars[i])){

            // containsValue os O(N)
                // make the whole solution O(n^2)
                    // use 2 map for 1 to 1 mapping
            if(map.containsValue(tChars[i])){
                return false
            }
            map[sChars[i]] = tChars[i]
        }else{
            if(map[sChars[i]] != tChars[i]){
                return false
            }
        }
    }
    return true
}

fun main(){
    val s = "badc"
    val t = "baba"
    print(isIsomorphicSolution(s,t))

}