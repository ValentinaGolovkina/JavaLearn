package lvl1_lesson8_Swing;

public class Quiz {

    static String title="English Test. Prepositions.";
    static String task=" Complete with to, at, in or - .";
    static String[] questions = {" 1. Sorry, John's not here. He's ___ work.",
        " 2. It's a lovely day. Let's go ___ the beach.",
        " 3. Sally's boyfriend works ___ an office.",
        " 4. My brother studies maths ___ the University of Manchester.",
        " 5. What time do you go ___ home?"};
    static String[] answers = {"to","at","in"," --- "};
    static String[] rightAnswers = {"at","to","in","at"," --- "};
    static boolean check(int answer, int number){
        if(answers[answer].equals(rightAnswers[number])) return true;
        return false;
    }
}
