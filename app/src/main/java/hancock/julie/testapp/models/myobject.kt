package hancock.julie.testapp.models

data class myobject (

    var host : String,
    var password : String,
    var rows : Int,
    var cols : Int,
    var pages : MutableList<PageObj>

)   {
    override fun toString() : String{
        var ss :String = "%s/msg?...%s\n".format(host,password)
        for(i in 0..(pages.size-1)){
            ss += pages[i].toString()
            ss += "\n"
        }
        return ss
    }
    fun getPageFromName(name:String) = pages.find { it.name == name }

}


//<HOST>/msg?code=<CODE>:<DEV>:<DEVCODE>&pass=<PASSWORD>