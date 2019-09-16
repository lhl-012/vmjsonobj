package com.liu.app

import org.junit.Test
import java.util.concurrent.Executors

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
//        val json="{\"age\":1,\"adds\":null}"
//        println(LJson.fromJson<User>(json))
//        val json="{\"age\":1,\"adds\":{}}"
//        println(LJson.fromJson<User>(json))
//        println(LJson.toJson(User(1,Adds(1))))
        val pool=Executors.newFixedThreadPool(1)
        for (i in 0 until 10){
            pool.execute {
                try {
                    println("$i is runing")
                }catch (e:Exception){
                    println("$i exp")
                }
            }
        }
    }

    data class User(val age:Int?,val adds:Adds?)
    data class Adds(val shop:Int?)
}
