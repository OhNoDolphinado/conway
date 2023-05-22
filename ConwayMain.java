public class ConwayMain {
    public static void main(String[] args) {
        Conway c = new Conway(5, 5);
        ConwayGraphics cg = new ConwayGraphics(c.getBoard());
        c.startBoard();
        c.printBoard();
        
        

        // c.run();
    }

}
