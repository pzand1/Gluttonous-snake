public class game {
    public static void main(String[] args) {
        map Map = new map(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        snake Snake = new snake(Map, Map.getSize_x() / 2, Map.getSize_y() / 2);
        food Food = new food(Snake, Map);
    }
}
