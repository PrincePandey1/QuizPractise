package com.example.android.quizpractise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        val username = intent.getStringExtra(Constants.USER_NAME)
        tv_name.text = username

        val totalQues= intent.getIntExtra(Constants.TOTAL_QUESTIONS ,  0)
        val correctAns= intent.getIntExtra(Constants.CORRECT_ANSWERS ,  0)

        score.text = "Your correctAnswer is $correctAns out of $totalQues"

        result_btn.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}