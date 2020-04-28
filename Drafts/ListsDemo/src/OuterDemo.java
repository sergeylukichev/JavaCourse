public class OuterDemo {
    public static String message = "Hello World!";
    private String m2 = "test";

    public static class InnerDemo {

        public void print() {
            System.out.println(message);
            //System.out.println(m2);

        }
    }

    public static void main(String[] args) {
        OuterDemo o = new OuterDemo();

        OuterDemo.InnerDemo id = new InnerDemo();
        id.print();


      //  OuterDemo.InnerDemo id = o.new InnerDemo();

        CustomLinkedList<String> ll = new CustomLinkedList<>();
    }
}
