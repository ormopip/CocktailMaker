package com.formacion.cocktailmaker.components

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import com.formacion.cocktailmaker.R

class AlcoholComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    enum class AlcoholType {
        Alcoholic,
        NonAlcoholic,
        OptionalAlcohol
    }
    
    private val imageView: ImageView

    var state: AlcoholType = AlcoholType.NonAlcoholic
        set(value) {
            field = value
            selectImage()
        }
    
    init {
        imageView = inflate(context, R.layout.component_alcohol, this)
            .findViewById(R.id.iv_alcohol)
    }

    private fun selectImage() = imageView.setImageResource(
        when(state){
            AlcoholType.NonAlcoholic -> R.drawable.ic_no_alcohol
            AlcoholType.OptionalAlcohol -> R.drawable.ic_alcohol_optional
            AlcoholType.Alcoholic -> R.drawable.ic_alcohol
        }
    )
}
