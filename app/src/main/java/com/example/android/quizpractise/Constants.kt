package com.example.android.quizpractise

object Constants {


    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"


    fun getQuestions(): ArrayList<Question> {

        val questionList = ArrayList<Question>()
        val q1 = Question(
            1,
            "Which Country does this Flag belongs to?",
            R.drawable.argentina,
            "Argentina",
            "Armenia",
            "Antarctica",
            "Azerbaijan",
            1
        )
        questionList.add(q1)

        val q2 = Question(
            2,
            "Which Country does this Flag belongs to?",
            R.drawable.america,
            "Argentina",
            "Auckland",
            "America",
            "Andorra",
            3
        )
        questionList.add(q2)

        val q3 = Question(
            3,
            "Which Country does this Flag belongs to?",
            R.drawable.australia,
            "Argentina",
            "Australia",
            "Antarctica",
            "Azerbaijan",
            2
        )
        questionList.add(q3)

        val q4 = Question(
            4,
            "Which Country does this Flag belongs to?",
            R.drawable.brazil,
            "Brazil",
            "Barbados",
            "Belgium",
            "Azerbaijan",
            1
        )
        questionList.add(q4)

        val q5 = Question(
            5,
            "Which Country does this Flag belongs to?",
            R.drawable.india,
            "Argentina",
            "Armenia",
            "Antarctica",
            "India",
            4
        )
        questionList.add(q5)

        val q6 = Question(
            6,
            "Which Country does this Flag belongs to?",
            R.drawable.canada,
            "Belize",
            "Belia",
            "Canada",
            "Cambodia",
            3
        )
        questionList.add(q6)

        val q7 = Question(
            7,
            "Which Country does this Flag belongs to?",
            R.drawable.england,
            "Australia",
            "America",
            "Canada",
            "England",
            4
        )
        questionList.add(q7)

        val q8 = Question(
            8,
            "Which Country does this Flag belongs to?",
            R.drawable.germany,
            "Russia",
            "Germany",
            "Italy",
            "Istanbul",
            2
        )
        questionList.add(q8)

        val q9 = Question(
            9,
            "Which Country does this Flag belongs to?",
            R.drawable.israel,
            "Dubai",
            "SaudiArabia",
            "Bangladesh",
            "Israel",
            4
        )
        questionList.add(q9)

        val q10 = Question(
            10,
            "Which Country does this Flag belongs to?",
            R.drawable.southafrica,
            "SouthAfrica",
            "Kenya",
            "Russia",
            "Taiwan",
            1
        )
        questionList.add(q10)

        return questionList
    }


}


