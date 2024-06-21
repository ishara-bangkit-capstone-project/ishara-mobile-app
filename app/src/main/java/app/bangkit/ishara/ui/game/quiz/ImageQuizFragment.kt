package app.bangkit.ishara.ui.game.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import app.bangkit.ishara.R
import app.bangkit.ishara.ui.custom_view.CustomTextButton
import app.bangkit.ishara.ui.custom_view.TxtButton


class ImageQuizFragment : Fragment() {


    private lateinit var customTextButton: CustomTextButton
    private val options: ArrayList<TxtButton> = arrayListOf(
        TxtButton(id = 1, name = "a", isClicked = false),
        TxtButton(id = 2, name = "b", isClicked = false),
        TxtButton(id = 3, name = "c", isClicked = false),
        TxtButton(id = 4, name = "d", isClicked = false),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_image_quiz, container, false)
        customTextButton = view.findViewById(R.id.btn_options)
        customTextButton.options = options
        return view
    }

}