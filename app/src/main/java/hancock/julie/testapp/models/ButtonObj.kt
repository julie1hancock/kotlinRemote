package hancock.julie.testapp.models

data class ButtonObj (
    var name : String,
    var code : String
) {
    override fun toString(): String = "(name=%s:code=%s)".format(name,code)
}