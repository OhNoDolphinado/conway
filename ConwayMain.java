public class ConwayMain {
    public static void main(String[] args) {
        Conway c = new Conway(10, 10);
        c.startBoard();
        c.seed(0, 0);
        c.seed(2, 1);
        c.seed(0, 4);

        c.seed(0, 1);
        c.seed(2, 3);
        c.seed(1, 1);
        c.seed(2, 1);
        c.seed(3, 1);
        c.seed(4, 1);

        c.run();
    }
}
