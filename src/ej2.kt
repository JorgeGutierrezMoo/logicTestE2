import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs
import kotlin.system.exitProcess

const val LOWEST_YEAR: Int = 753
const val CURRENT_YEAR: Int = 2021

val possibleYears = arrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
val possibleChars = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
val read = Scanner(System.`in`)

var year1: String = ""
var year2: String = ""

var yearOnly1: Int = 0
var yearOnly2: Int = 0
var eraOnly1 = ""
var eraOnly2 = ""

var correctedYearOnly1: Int = 0
var correctedYearOnly2: Int = 0

var arrayRange1 = arrayListOf<Int>()
var arrayRange2 = arrayListOf<Int>()

var result = arrayListOf<Int>()
var arrayRoman = arrayListOf<String>()
fun main() {

    firstBlock()

    //Isolating the ERA of the Inferior Limit Year. e.g: 753
    yearOnly1 = year1.replace(Regex("[^0-9]"), "").toInt()
    println("Isolated Inferior Year is: $yearOnly1")
    //Isolating the ERA of the Superior Limit Year. e.g: 753
    yearOnly2 = year2.replace(Regex("[^0-9]"), "").toInt()
    println("Isolated Superior Year is: $yearOnly2")

    //Isolating The Inferior Limit Year ERA. e.g: BC or AD
    val auxI1 = year1[year1.length - 1].toString()
    val auxI2 = year1[year1.length - 2].toString()
    eraOnly1 = concat(auxI2, auxI1)
    println("Isolated Inferior Era is: $eraOnly1")

    //Isolating The Superior Limit Year ERA. e.g: BC or AD
    val auxS1 = year2[year2.length - 1].toString()
    val auxS2 = year2[year2.length - 2].toString()
    eraOnly2 = concat(auxS2, auxS1)
    println("Isolated Inferior Era is: $eraOnly2")
    /*
    if (yearOnly1 > LOWEST_YEAR){
        println("***ERROR*** The lowest allowed value for the Isolated Inferior Limit Year is: $LOWEST_YEAR ")
        exitProcess(1)
    }
    if (yearOnly2 > CURRENT_YEAR){
        println("***ERROR*** The highest allowed value for the Isolated Superior Limit Year is: $CURRENT_YEAR ")
        exitProcess(1)
    }
     */

    correctedYearOnly1 = yearOnly1
    correctedYearOnly2 = yearOnly2 + 753

    if (eraOnly1 != eraOnly2){
        if (eraOnly1 == "BC"){
            if (eraOnly1 == "BC"){
                for (i in (correctedYearOnly1) downTo 1){
                    arrayRange1.add(i)
                }
                for (j in 1..(correctedYearOnly2)){
                    arrayRange2.add(j)
                }
                println(arrayRange1)
                println(arrayRange2)
                result = (arrayRange1 + arrayRange2) as ArrayList<Int>
                println(result)
                for (item in arrayRange1) {
                    var year = digitToRoman(item).toString()
                    arrayRoman.add(year)
                }
                println("arrayRoman:")
                println(arrayRoman)
            }
        }else{
            println("***ERROR*** The only allowed values for Era are - BC - and - AD -")
            exitProcess(1)
        }
    }else{
        whenErasAreTheSame()
        println()
        println(arrayRange2)
    }


}


fun digitToRoman(inputYear: Int): String {
    var convertedNumber = ""
    var inputMutableYear: Int = inputYear

    while (inputMutableYear > 0) {
        for ((index, value) in possibleYears.withIndex()) {
            if (inputMutableYear - value >= 0) {
                inputMutableYear -= value
                convertedNumber += possibleChars[index]
                break
            }
        }
    }
    return convertedNumber
}

fun concat(s1: String, s2: String): String {
    return StringBuilder(s1).append(s2).toString()
}

fun firstBlock(){
    //Asking user for expected input
    println("Enter range in the expected format: ")
    val stringInput = readLine()!!
    println(stringInput)
    //Splitting the answer using the "-" symbol
    val arraySplit: List<String> = stringInput.split("-")
    println(arraySplit)
    //Obtaining the Inferior Limit Year in this format. e.g: 753BC
    year1 = arraySplit[0]
    println("Inferior Limit is: $year1")
    //Obtaining the Superior Limit Year in this format. e.g: 2021AD
    year2 = arraySplit[1]
    println("Superior Limit is: $year2")
}

fun whenErasAreTheSame() {

    if (eraOnly1 == eraOnly2){
        if (eraOnly1 == "BC"){
            correctedYearOnly1 = yearOnly1-753
            correctedYearOnly2 = yearOnly2-753
            for (i in correctedYearOnly1 downTo correctedYearOnly2){
                arrayRange2.add(abs(i))
            }
        }
        if (eraOnly1 == "AD"){
            for (i in correctedYearOnly1..correctedYearOnly2){
                arrayRange2.add(i)
            }
        }
    }
}