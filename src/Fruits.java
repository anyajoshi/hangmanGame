import java.net.URL;


public class Fruits extends WordCategory {

    public Fruits() {

        super("Fruits");
        super.addWord("Apple","Apple keeps a doctor away");
        super.addWord("Banana","Is sweet");
        super.addWord("Strawberry","The best berry");
        super.addWord("Pears","Fiber");
        super.addWord("Watermelon","Are huge");
        super.addWord("Pineapple", "Tropical fruit with a sweet and tangy taste, known for its spiky skin and juicy yellow flesh.");
        super.addWord("Mango", "Exotic fruit with a sweet and tropical flavor, often called the 'king of fruits'.");
        super.addWord("Grapes", "Small, juicy fruits that grow in clusters on vines, available in various colors such as green, red, and purple.");
        super.addWord("Kiwi", "Small, fuzzy fruit with green flesh and tiny black seeds, known for its tart flavor and high vitamin C content.");
        super.addWord("Orange", "Citrus fruit with a bright orange skin and juicy, segmented flesh, famous for its high vitamin C content.");
        super.addWord("Peach", "Soft, fuzzy fruit with a sweet and juicy flesh, often used in desserts, jams, and preserves.");
        super.addWord("Cherry", "Small, round fruit with a sweet and tart flavor, available in various colors such as red, black, and yellow.");
        super.addWord("Blueberry", "Small, round berries with a sweet and tangy flavor, known for their antioxidant properties and health benefits.");
        super.addWord("Raspberry", "Small, delicate berries with a sweet and slightly tart flavor, often used in desserts, jams, and sauces.");
        super.addWord("Plum", "Sweet and juicy fruit with smooth skin, available in various colors such as red, purple, and yellow.");


    }

    public URL getCategoryIcon(){
        URL u = getClass().getResource("resources/fruits.jpeg");
        return u;
    }

}
