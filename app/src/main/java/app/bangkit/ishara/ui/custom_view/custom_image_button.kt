package app.bangkit.ishara.ui.custom_view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.core.content.res.ResourcesCompat
import app.bangkit.ishara.R

class CustomImageButton : View {

    private val backgroundPaint = Paint()
    var options: ArrayList<ImgButton> = arrayListOf()
        set(value) {
            field = value
            requestLayout()
        }
    var imgButton: ImgButton? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    )

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = getDefaultSize(suggestedMinimumWidth, widthMeasureSpec)
        val height = getDefaultSize(suggestedMinimumHeight, heightMeasureSpec)

        val halfOfHeight = height / 2
        val halfOfWidth = width / 2
        var value = -450F

        for (i in options.indices) {
            if (i.mod(2) == 0) {
                options[i].apply {
                    x = halfOfWidth - 300F
                    y = halfOfHeight + value
                }
            } else {
                options[i].apply {
                    x = halfOfWidth + 100F
                    y = halfOfHeight + value
                }
                value += 300F
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        for (option in options) {
            drawButton(canvas, option)
        }
    }

    private fun drawButton(canvas: Canvas?, imgButton: ImgButton) {
        if (imgButton.isClicked) {
            backgroundPaint.color = ResourcesCompat.getColor(resources, R.color.darkBlue, null)
        } else {
            backgroundPaint.color = ResourcesCompat.getColor(resources, R.color.white, null)
        }

        canvas?.save()

        canvas?.translate(imgButton.x as Float, imgButton.y as Float)
        val backgroundPath = Path()
        backgroundPath.addRect(0F, 0F, 245F, 240F, Path.Direction.CCW)
        canvas?.drawPath(backgroundPath, backgroundPaint)

        val drawableId = resources.getIdentifier(imgButton.name, "drawable", context.packageName)
        val bitmap = BitmapFactory.decodeResource(resources, drawableId)
        bitmap?.let {
            val scaledBitmap = Bitmap.createScaledBitmap(it, 200, 200, false)
            canvas?.drawBitmap(scaledBitmap, 25f, 25f, null)
        }

        canvas?.restore()
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val halfOfHeight = height / 2
        val halfOfWidth = width / 2

        val widthColumnOne = (halfOfWidth - 300F)..(halfOfWidth - 100F)
        val widthColumnTwo = (halfOfWidth + 100F)..(halfOfWidth + 300F)

        val heightRowOne = (halfOfHeight - 600F)..(halfOfHeight - 400F)
        val heightRowTwo = (halfOfHeight - 300F)..(halfOfHeight - 100F)

        if (event?.action == MotionEvent.ACTION_DOWN) {
            // Memeriksa apakah event terjadi di salah satu kotak
            for (i in options.indices) {
                val imgButton = options[i]
                when {
                    event.x >= imgButton.x!! && event.x <= imgButton.x!! + 200F &&
                            event.y >= imgButton.y!! && event.y <= imgButton.y!! + 225F -> {
                        options(i)
                        return true
                    }
                }
            }
        }
        return false
    }

    private fun options(position: Int) {
        for (imgButton in options) {
            imgButton.isClicked = false
        }
        options[position].apply {
            imgButton = this
            isClicked = true
        }
        invalidate()
    }
}

data class ImgButton(
    val id: Int,
    var x: Float? = 0f,
    var y: Float? = 0f,
    var name: String,
    var isClicked: Boolean,
)
