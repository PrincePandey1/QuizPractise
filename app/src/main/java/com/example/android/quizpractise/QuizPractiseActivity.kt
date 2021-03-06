package com.example.android.quizpractise

import android.content.Intent
import android.graphics.Color
import android.graphics.Color.parseColor
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_practise.*
import kotlinx.android.synthetic.main.activity_quiz_practise.*

class QuizQuestionActivity : AppCompatActivity() , View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswer: Int = 0
    private var mUserName: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_practise)

        mUserName = intent.getStringExtra(Constants.USER_NAME)
        mQuestionsList = Constants.getQuestions()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

        setQuestion()
    }

    private fun setQuestion(){

        val question: Question? = mQuestionsList!![mCurrentPosition - 1]

        defaultOptionsView()
        if (mCurrentPosition == mQuestionsList!!.size){
            btn_submit.text = "FINISH"
        }else{
            btn_submit.text = "SUBMIT"
        }
        ProgressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition " + "/" + ProgressBar.max

        tv_question.text = question!!.question
        tv_image.setImageResource(question.image)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
    }
    private fun defaultOptionsView(){

        val options = ArrayList<TextView>()

        options.add(0,tv_option_one)
        options.add(1,tv_option_two)
        options.add(2,tv_option_three)
        options.add(3,tv_option_four)

        for(option in options){
            option.setTextColor(parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.default_option_border)
        }

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one ,1)
            }

            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two ,2)
            }

            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three ,3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(tv_option_four ,4)
            }
            R.id.btn_submit ->{
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition<=mQuestionsList!!.size ->
                        {
                            setQuestion()
                        }else->{
                        val intent = Intent(this , ResultActivity::class.java)
                        intent.putExtra(Constants.USER_NAME , mUserName)
                        intent.putExtra(Constants.CORRECT_ANSWERS , mCorrectAnswer)
                        intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList!!.size)
                        startActivity(intent)
                        finish()
                    }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer!=mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_border)
                    }else{
                        mCorrectAnswer++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_border)

                    if(mCurrentPosition == mQuestionsList!!.size){
                        btn_submit.text = "FINISH"
                    }else{
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int , drawable: Int){
        when(answer){
            1 ->{
                tv_option_one.background = ContextCompat.getDrawable(this,drawable)
            }
            2 ->{
                tv_option_two.background = ContextCompat.getDrawable(this,drawable)
            }
            3 ->{
                tv_option_three.background = ContextCompat.getDrawable(this,drawable)
            }
            4 ->{
                tv_option_four.background = ContextCompat.getDrawable(this,drawable)
            }
        }
    }

    private fun selectedOptionView(tv: TextView , selectedOptionNum: Int){

        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(parseColor("#363A43"))
        tv.setTypeface(tv.typeface , Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_border)
    }

}
