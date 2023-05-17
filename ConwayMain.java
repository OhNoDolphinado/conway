public class ConwayMain {
    public static void main(String[] args) {
        Conway c = new Conway(10, 10);
        c.startBoard();
        c.seed(2, 4);
        c.printBoard();
    }
}
