public class ConwayMain {
    public static void main(String[] args) {
        Conway c = new Conway(5, 5);
        c.startBoard();
        c.seed(0, 0);
        c.seed(0, 1);
        c.seed(1, 0);
       
        

        c.run();
    }
}
