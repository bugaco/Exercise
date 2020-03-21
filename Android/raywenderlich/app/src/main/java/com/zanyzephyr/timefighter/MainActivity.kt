package com.zanyzephyr.timefighter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.PersistableBundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private var score = 0
    private lateinit var tapMeButton: Button
    private lateinit var gameScoreTextView: TextView
    private lateinit var timeLeftTextView: TextView


    private var gameStated = false
    private lateinit var countDownTimer: CountDownTimer
    private var initialCountDown: Long = 60000
    private var countDownInternal: Long = 1000
    private var timeLeftOnTimer: Long = 60000

    companion object {
        private val TAG = MainActivity::class.java.simpleName
        private const val SCORE_KEY = "SCORE_KEY"
        private const val TIME_LEFT_KEY = "TIME_LEFT_KEY"

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(SCORE_KEY, score)
        outState.putLong(TIME_LEFT_KEY, timeLeftOnTimer)
        countDownTimer.cancel()

        Log.d(TAG, "onSaveInstanceState: Saving score: $score & Time left: $timeLeftOnTimer")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "onCreate called. score is $score")

        setContentView(R.layout.activity_main)

        tapMeButton = findViewById(R.id.tapMeButton)
        gameScoreTextView = findViewById(R.id.gameScoreTextView)
        timeLeftTextView = findViewById(R.id.timeLeftTextView)

        if (savedInstanceState != null) {
            score = savedInstanceState.getInt(SCORE_KEY)
            timeLeftOnTimer = savedInstanceState.getLong(TIME_LEFT_KEY)
            restoreGame()
        } else {
            resetGame()
        }

        tapMeButton.setOnClickListener { view ->
            val animation = AnimationUtils.loadAnimation(this, R.anim.bounce)
            view.startAnimation(animation)
            incrementScore()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        showInfo()
        return true
    }

    private fun showInfo() {
        val dialogTitle = String.format("%s%s", getString(R.string.aboutTitle), BuildConfig.VERSION_NAME)
        val dialogMessage = getString(R.string.aboutMessage)

        val builder = AlertDialog.Builder(this)
        builder.setTitle(dialogTitle)
        builder.setMessage(dialogMessage)
        builder.create().show()
    }

    private fun startGame() {
        countDownTimer.start()
        gameStated = true
    }

    private fun incrementScore() {
        if (!gameStated) {
            startGame()
        }

        score += 1
        var newScore = getString(R.string.yourScore, score)
        gameScoreTextView.text = newScore

        val animation = AnimationUtils.loadAnimation(this, R.anim.blink)
        gameScoreTextView.startAnimation(animation)
    }

    private fun resetGame() {
        score = 0
        gameScoreTextView.text = getString(R.string.yourScore, score)

        timeLeftTextView.text = getString(R.string.timeLeft, initialCountDown / 1000)

        countDownTimer = object : CountDownTimer(initialCountDown, countDownInternal) {
            override fun onFinish() {
                endGame()
            }

            override fun onTick(millisUntilFinished: Long) {
                timeLeftOnTimer = millisUntilFinished
                timeLeftTextView.text = getString(R.string.timeLeft, millisUntilFinished / 1000)
            }

        }

        gameStated = false
    }

    private fun restoreGame() {
        gameScoreTextView.text = getString(R.string.yourScore, score)
        timeLeftTextView.text = getString(R.string.timeLeft, timeLeftOnTimer / 1000)

        countDownTimer = object : CountDownTimer(timeLeftOnTimer, countDownInternal) {
            override fun onFinish() {
                endGame()
            }

            override fun onTick(millisUntilFinished: Long) {
                timeLeftOnTimer = millisUntilFinished
                timeLeftTextView.text = getString(R.string.timeLeft, millisUntilFinished / 1000)
            }

        }
        countDownTimer.start()
        gameStated = true
    }

    private fun endGame() {
        Toast.makeText(this, getString(R.string.gameOverMessage, score), Toast.LENGTH_LONG).show()
        resetGame()
    }
}
