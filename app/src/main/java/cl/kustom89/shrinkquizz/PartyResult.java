package cl.kustom89.shrinkquizz;

/**
 * Created by kustom89 on 27-03-2018.
 */

public class PartyResult extends PartyAnswer {
    public PartyResult(String answer) {
        super( answer );
    }

    public String score(){
        return procesing();
    }

    private String procesing() {
        String answer = getAnswer();

        if(answer.contains( "5" )){
            return"eres un niño";

        }else if(answer.contains( "10" )){
            return"Bien dale campepon";
        }else {
            return "consigue ayuda";
        }


    }

}
