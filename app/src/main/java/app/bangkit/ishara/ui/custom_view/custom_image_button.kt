package app.bangkit.ishara.ui.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.View

class CustomImageButton : View {
    constructor(context: Context): super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )
}

data class ImgButton(
    val id: Int,
    var x: Float? = 0f,
    var y: Float? = 0f,
    var name: String,
    var isClicked: Boolean,
)