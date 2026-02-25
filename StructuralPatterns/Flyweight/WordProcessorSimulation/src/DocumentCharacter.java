public class DocumentCharacter implements ILetter{

    private final char character;
    private final String fontType;
    private final int size;

    public DocumentCharacter(char character, String fontType, int size) {
        this.character = character;
        this.fontType = fontType;
        this.size = size;
    }


    @Override
    public void display(int x, int y) {
        System.out.println("Displaying character " + character + " At row "+ x +" and column "+ y);
    }
}
