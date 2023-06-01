public class ConwayMain {
    public static void main(String[] args) {
        Conway c = new Conway(15, 1000);
        ConwayGraphics cg = new ConwayGraphics(c);
        c.startBoard();
        c.seed(2, 3);
        c.seed(3, 4);
        c.seed(1, 5);
        c.seed(2, 5);
        c.seed(3, 5);
        // c.printBoard();
        c.run(cg);
        // repaint here?????
    }

}
