import java.util.HashMap;
import java.util.Map;

public class LetterFactory {

    private static final Map<Character, ILetter> characterCache = new HashMap<>();

    public static ILetter createLetter(char character) {
        if(characterCache.containsKey(character)){
            return characterCache.get(character);
        }
        else{
            DocumentCharacter characterObj=new DocumentCharacter(character,"Arial",10);
            characterCache.put(character,characterObj);
            return characterObj;
        }

    }
    public static int getTotalCharacter(){
        return characterCache.size();
    }
}
