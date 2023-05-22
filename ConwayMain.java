public class ConwayMain {
    public static void main(String[] args) {
        Conway c = new Conway(5, 5);
        ConwayGraphics cg = new ConwayGraphics(c.getBoard());
        c.startBoard();
        c.seed(4, 2);
        c.seed(4, 4);
        c.seed(3, 4);
        c.seed(3, 3);
        c.seed(1, 2);
        c.printBoard();
        
        

        // c.run();
    }

}
