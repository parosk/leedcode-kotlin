package medium

import java.util.*

fun lengthOfLongestSubstring(s: String): Int {
    var length = 0
    val chars: Queue<Char> = LinkedList()
    val charSet  = mutableSetOf<Char>()
    for (c in s) {
       if(!charSet.contains(c)){
           charSet.add(c)
           chars.add(c)
           if(chars.size > length){
               length = chars.size
           }
       }else{
           while (chars.peek() != c){
               val removed = chars.remove()
               charSet.remove(removed)
           }
           chars.remove(c)
           chars.add(c)
       }
    }
    print(charSet)
    return length
}

fun main(){
    print(lengthOfLongestSubstring("aabaab!bb"))
}