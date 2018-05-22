package eiei.rockpapersciscor

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var userFace: Int = 0

    val PAPER: Int = 1
    val HAMMER: Int = 3
    val COACH: Int = 2

    private var userScore: Int = 0
    private var botScore: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1.visibility = View.INVISIBLE
        button2.visibility = View.INVISIBLE
        button3.visibility = View.INVISIBLE
    }

    fun startButtonClicked(view: View) {
        button1.visibility = View.VISIBLE
        button2.visibility = View.VISIBLE
        button3.visibility = View.VISIBLE
    }

    fun buttonClicked(view: View) {
        if (view == button1) {
            leftImage.setImageResource(R.drawable.hammer)
            this.userFace = HAMMER
        } else if (view == button2) {
            leftImage.setImageResource(R.drawable.coach)
            this.userFace = COACH
        } else if (view == button3) {
            leftImage.setImageResource(R.drawable.paper)
            this.userFace = PAPER
        }
        gameLogic()
    }

    fun gameLogic() {
        var face = 1 + Random().nextInt(3)
        if (face == PAPER) {
            rightImage.setImageResource(R.drawable.paper)
            if (this.userFace == HAMMER)
                this.botScore++;
            else if (this.userFace == COACH)
                this.userScore++;
        } else if (face == COACH) {
            rightImage.setImageResource(R.drawable.coach)
            if (this.userFace == PAPER)
                this.botScore++;
            else if (this.userFace == HAMMER)
                this.userScore++;
        } else if (face == HAMMER) {
            rightImage.setImageResource(R.drawable.hammer)
            if (this.userFace == COACH)
                this.botScore++;
            else if (this.userFace == PAPER)
                this.userScore++;
        }

        uScore.setText("ME : " + this.userScore)
        bScore.setText("BOT : " + this.botScore)
    }
}
