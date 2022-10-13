/*
The entire credits goes to Abhay Redkar udemy course Java object oriented programming: Build a chat Application.
I just wrote the code by looking at his videos to understand OOPS concepts
*/


import java.util.Scanner;

/*

    This is a program I created for my comp-sci class. Its similar to a program I wrote on a UDEMY java course.
    This program is free to edit and fork.

 */

public class Main {

    public static void main(String[] args) {

        /*
            Initiating!!!
         */
        Quiz quiz = new Quiz();
        quiz.begin();

    }
}

class Quiz
{
    void begin()
    {

        // This creates our menu that allows users to see options
        System.out.println(" ");
        System.out.println("Hello and welcome, my name is Soren and today you will be playing. . .");
        System.out.println("A lord of the rings trivia! Answer with the corresponding letter! ");

        //creates questions using an array!
        Question[] questions = new Question[5];
        questions[0] = new Question("\nWho was the original and first evil tolkien character chronologically?","Sauron","Morgoth","Melkor","Balrog", new Answer("Melkor"));
        questions[1] = new Question("Who was the composer of the OST of the trilogy?","Howard Shore","Hans Zimmer","Jeremy Soule","Motoi Sakuraba", new Answer("Howard Shore"));
        questions[2] = new Question("Who is the character that lived in the woods not featured in the films?","Radagast","Isildur son of Elendil","Adar","Tom Bombadil", new Answer("Tom Bombadil"));
        questions[3] = new Question("How many volumes were initially planned for the main LOTR trillogy books?","8","6","1","2", new Answer("1"));
        questions[4] = new Question("During what age did the books take place?","3rd","7th","4th","1st", new Answer("3rd"));

        //Creates a score
        int countTotal = 0;
        int countRight = 0;
        int countWrong = 0;

        //Options
        for(Question q: questions) {
            System.out.println(q.getQuestion());
            System.out.println("1 : " +q.getOption1());
            System.out.println("2 : " +q.getOption2());
            System.out.println("3 : " +q.getOption3());
            System.out.println("4 : " +q.getOption4());

            String answer = "";

            char ans;
            System.out.println("Enter your answer");
            Scanner scan = new Scanner(System.in);
            ans = scan.next().charAt(0);


            switch(ans)
            {
                // If ... do ...
                case '1':
                    answer = q.getOption1();
                    break;
                case '2':
                    answer = q.getOption2();
                    break;
                case '3':
                    answer = q.getOption3();
                    break;
                case '4':
                    answer = q.getOption4();
                    break;
                default:break;
            }

            //This is a little design for when you answer
            System.out.println("Your answer " + answer + " " + q.getAnswer());
            if(answer.equals(q.getAnswer().getAnswer()))
            {
                System.out.println("------------------------------------------------------");
                System.out.println("                  Correct Answer                      ");
                System.out.println("------------------------------------------------------");
                countRight++;
            }
            else
            {
                System.out.println("------------------------------------------------------");
                System.out.println("                  Wrong Answer                      ");
                System.out.println("------------------------------------------------------");
                countWrong++;
            }
            System.out.println("============================================================================================");
            countTotal++;
        }

        Result result = new Result(countTotal,countRight,countWrong);
        result.showResult();
    }
}

class Question
{

    //creating strings
    String question;
    String option1;
    String option2;
    String option3;
    String option4;
    Answer answer;

    public Question(String question, String option1, String option2, String option3, String option4, Answer answer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public Answer getAnswer() {
        return answer;
    }
}

class Answer
{
    String answer;

    public Answer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
}

interface IResult
{
    void showResult();
    double showPercentage(int correctAnswers,int totalQuestions);
    String showPerformance(double percentage);
}

class Result implements IResult
{
    int totalQuestions;
    int correctAnswers;
    int wrongAnswers;

    public Result(int totalQuestions, int correctAnswers, int wrongAnswers) {
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.wrongAnswers = wrongAnswers;
    }
    @Override
    public void showResult() {

        //creates interface for score menu
        System.out.println("\n┏┓┏┳━━┳┓┏┓┏━━━━┓\n" +
                "┃┗┛┃━━┫┃┃┃┃ ╭╮ ┃\n" +
                "┃┏┓┃━━┫┃┫┗┫ ╰╯ ┃\n" +
                "┗┛┗┻━━┻━┻━┻━━━━┛");
        System.out.println("Your results!");
        System.out.println("Total Questions " + totalQuestions);
        System.out.println("Number of correct answers " + correctAnswers);
        System.out.println("Number of wrong answers " + wrongAnswers);
        System.out.println("Percentage " + showPercentage(correctAnswers,totalQuestions));
        System.out.println("Your performance " + showPerformance(showPercentage(correctAnswers,totalQuestions)));

    }

    @Override
    public double showPercentage(int correctAnswers, int totalQuestions) {
        return (double) (correctAnswers / (double)totalQuestions) * 100 ;
    }

    @Override
    public String showPerformance(double percentage) {
        String performance = "";

        if(percentage > 60)
        {
            //fun grading system
            performance = " is AWESOME!! Good job!!!";
        }
        else if(percentage < 40)
        {
            performance = " is Not so good :(";
        }

        return performance;

    }
}