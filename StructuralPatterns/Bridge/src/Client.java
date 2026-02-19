
public class Client {
    public static void main(String[] args) {
        System.out.println("Welcome to Bridge Design Pattern");

        LivingThings dog=new Dog(new LungBreathing());
        LivingThings fish=new Fish(new GillBreathing());
        LivingThings tree=new Tree(new Photosynthesis());

        dog.breath();
        fish.breath();
        tree.breath();
    }
}