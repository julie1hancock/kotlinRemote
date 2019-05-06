package hancock.julie.testapp.models

import org.json.JSONObject
import java.lang.IllegalArgumentException

object  Model {

    var singleton : myobject

    init{
        var emptyArrayOfPageObj : MutableList<PageObj> = arrayListOf()
        singleton =
            myobject("", "", 0, 0, emptyArrayOfPageObj)
    }

    fun readJSON(json:String): Boolean {
        val root = JSONObject(json)

        /*set singleton*/
        singleton.host = root.getString("host")
        singleton.password = root.getString("password")
        singleton.rows = root.getInt("rows")
        singleton.cols = root.getInt("cols")


        /*set up pages*/
        val pagesJSON = root.getJSONArray ("pages")
        var pages : MutableList<PageObj> = arrayListOf()

        for (i in 0..(pagesJSON.length() - 1)) {
            val pageItem = pagesJSON.getJSONObject(i)

            /*set up buttons*/
            var buttons : MutableList<ButtonObj> = arrayListOf()
            val buttonsJSON = pageItem.getJSONArray ("buttons")

            for (i in 0..(buttonsJSON.length() - 1)) {
                var buttonItem = buttonsJSON[i]
        
                var castedButton: JSONObject
                if(buttonItem is JSONObject) {
                    castedButton = buttonItem
                    var myButton = ButtonObj(
                        castedButton.getString("name"),
                        castedButton.getString("code")
                    )
                    buttons.add(myButton)
                }
                else throw IllegalArgumentException()
            }
            var page = PageObj(
                pageItem.getString("name"),
                pageItem.getString("device"),
                pageItem.getInt("deviceCode"),
                buttons
            )
            pages.add(page)
        }

        singleton.pages = pages
        return true
    }

    fun getPageByName(name:String) = singleton.getPageFromName(name)

}


