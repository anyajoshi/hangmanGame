import java.net.URL;

public class Animals extends WordCategory {

    public Animals() {
        super("Animals");
        super.addWord("Dog","Dogs are cute");
        super.addWord("Cat","Cats are mean");
        super.addWord("Cow","Cows give milk");
        super.addWord("Pig","Pigs are not clean");
        super.addWord("Lion","Lion is the king of the Jungle");
        super.addWord("Kangaroo","Kangaroos are known for their powerful hind legs, large feet, and ability to hop long distances");
        super.addWord("Monkey","Monkeys are primates known for their agile and active lifestyle. ");
        super.addWord("Panda","Pandas are large bears native to China known for their black and white fur");
        super.addWord("Narwhal","Known for their long, spiral tusks protruding from their heads");
        super.addWord("Dolphins","Highly intelligent marine mammals known for their playful behavior");
        super.addWord("Koala","Characterized by their round ears, large nose, and thick, grey fur");
        super.addWord("Orca","Orcas are highly social and intelligent animals, known for black and white coloration");
        super.addWord("Shark","Sharks are cartilaginous fish found in ocean");
        super.addWord("Octopus","They belong to the class Cephalopoda and are characterized by their soft bodies");
        super.addWord("Fish","Aquatic vertebrates found in freshwater and saltwater environments");
        super.addWord("Starfish","Also known as sea stars");
        super.addWord("Whale","Whales are large marine mammals belonging to the order Cetacea");
        super.addWord("Giraffe","They are tall animals known for their long neck");
        super.addWord("Turtle","Reptiles known for their hard, protective shells and moving very slowly");
        super.addWord("Cheetah","They are very fast land animals native to Africa");
        super.addWord("Bear","They are large mammals known for their strong and tough body");
        super.addWord("Penguin","Flightless birds found primarily in Antarctica");
    }

    public URL getCategoryIcon(){
        URL u = getClass().getResource("resources/aminals.jpeg");
        return u;
    }

}
