package app.bangkit.ishara.ui.game.quiz

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import app.bangkit.ishara.R
import app.bangkit.ishara.databinding.ActivityQuizBinding
import app.bangkit.ishara.ui.custom_view.ImgButton

class QuizActivity : AppCompatActivity() {

    private lateinit var quizBinding: ActivityQuizBinding

    private var currentStep = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        quizBinding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(quizBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(quizBinding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        showQuizStep(currentStep)

        quizBinding.btnNext.setOnClickListener {
            currentStep++
            showQuizStep(currentStep)
        }

        val options: ArrayList<ImgButton> = arrayListOf(
            ImgButton(id = 1, name = "A1", isClicked = false),
            ImgButton(id = 2, name = "A2", isClicked = false),
            ImgButton(id = 3, name = "B1", isClicked = false),
            ImgButton(id = 4, name = "A4", isClicked = false),
        )
    }

    private fun showQuizStep(step: Int) {
        val fragment: Fragment = when (step) {
            1 -> ImageQuizFragment()
            2 -> TextQuizFragment()
            else -> SequenceQuizFragment()
            //TODO: tambahkan ml quiz
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .commit()
    }
}