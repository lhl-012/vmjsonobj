package com.liu.app

import org.jsoup.Jsoup
import org.junit.Test

class CorTest {
    @Test
    fun freshToken() {
        val url="https://www.open-open.com/github/view/github2019-08-08.html"
        val doc=Jsoup.connect(url).get()
        val lis=doc.select("tbody").select("tr")
        for (tr in lis){
            //tr.select(".table-language")[0].text()=="Java" ||
            if(tr.select(".table-language")[0].text()=="Kotlin"){
                println("${tr.select(".table-description")[0].text()}\nhttps://github.com/${tr.select(".table-name")[0].text()}")
            }
        }
    }
}