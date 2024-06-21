package app.bangkit.ishara.ui.game.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.bangkit.ishara.R
import app.bangkit.ishara.ui.custom_view.CustomImageButton
import app.bangkit.ishara.ui.custom_view.ImgButton


class TextQuizFragment : Fragment() {

    private lateinit var customImageButton: CustomImageButton
    private val options: ArrayList<ImgButton> = arrayListOf(
        ImgButton(id = 1, name = "sign_a", isClicked = false),
        ImgButton(id = 2, name = "sign_b", isClicked = false),
        ImgButton(id = 3, name = "sign_c", isClicked = false),
        ImgButton(id = 4, name = "sign_d", isClicked = false),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_text_quiz, container, false)
        customImageButton = view.findViewById(R.id.btn_options)
        customImageButton.options = options
        return view
    }



}

