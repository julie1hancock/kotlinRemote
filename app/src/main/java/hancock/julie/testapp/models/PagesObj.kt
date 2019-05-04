package hancock.julie.testapp.models

data class PageObj (

    var name : String,
    var device : String,
    var deviceCode : Int,
    var buttons : MutableList<ButtonObj>
) {
    override fun toString(): String {
        var ss:String = "%s:%s:%d".format(name,device,deviceCode)
        for(i in 0..(buttons.size-1)) {
            ss += buttons[i].toString()
        }
        return ss
    }
}
