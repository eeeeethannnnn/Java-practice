//I worked on the homework assignment alone, using only course materials.
/** * Program for CheeseDriver.
 * @author Shen-Yi Cheng
 * @version 1.0
 */
public class CheeseDriver {
    /**
     * @param args for main method.
     */
    public static void main(String[] args) {
        Cheese a = new Cheese(10, "a");
        Cheese aa = new Cheese(10, "a");
        Cheese aaa = new Cheese(10, "aaa");
        Cheese b = new Cheese(20, "b");
        Cheese c = new Cheese(30, "c");
        Cheese d = new Cheese(40, "d");
        Cheese e = new Cheese(50, "e");
        CheeseConnoisseur v =  new CheeseConnoisseur();
        CheeseConnoisseur w =  new CheeseConnoisseur("w", 20, b);
        CheeseConnoisseur x =  new CheeseConnoisseur("x", 20, c);
        CheeseConnoisseur y =  new CheeseConnoisseur("y", 20, d);
        CheeseConnoisseur z =  new CheeseConnoisseur("z", 20, e);

        System.out.println("===initialize===");
        v.trade(a);
        System.out.println(v.getName() + " " + v.getCheese() + " " + v.getMoney());
        System.out.println(w.getName() + " " + w.getCheese() + " " + w.getMoney());
        System.out.println(x.getName() + " " + x.getCheese() + " " + x.getMoney());
        System.out.println(y.getName() + " " + y.getCheese() + " " + y.getMoney());
        System.out.println(z.getName() + " " + z.getCheese() + " " + z.getMoney());
        System.out.println("===initialize===");
        System.out.println("===test equal===");
        System.out.println(a.equals(aa));
        System.out.println(a.equals(b));
        System.out.println("===test equal===");
        v.trade(aaa);
        w.trade(x);
        y.trade(z);
        System.out.println("===1st round===");
        System.out.println(v.getName() + " " + v.getCheese() + " " + v.getMoney());
        System.out.println(w.getName() + " " + w.getCheese() + " " + w.getMoney());
        System.out.println(x.getName() + " " + x.getCheese() + " " + x.getMoney());
        System.out.println(y.getName() + " " + y.getCheese() + " " + y.getMoney());
        System.out.println(z.getName() + " " + z.getCheese() + " " + z.getMoney());
        System.out.println("===1st round===");
        v.trade(a);
        w.trade(x);
        y.trade(z);
        System.out.println("===2nd round===");
        System.out.println(v.getName() + " " + v.getCheese() + " " + v.getMoney());
        System.out.println(w.getName() + " " + w.getCheese() + " " + w.getMoney());
        System.out.println(x.getName() + " " + x.getCheese() + " " + x.getMoney());
        System.out.println(y.getName() + " " + y.getCheese() + " " + y.getMoney());
        System.out.println(z.getName() + " " + z.getCheese() + " " + z.getMoney());
        System.out.println("===2nd round===");
        v.trade(aaa);
        w.trade(x);
        y.trade(z);
        System.out.println("===3rd round===");
        System.out.println(v.getName() + " " + v.getCheese() + " " + v.getMoney());
        System.out.println(w.getName() + " " + w.getCheese() + " " + w.getMoney());
        System.out.println(x.getName() + " " + x.getCheese() + " " + x.getMoney());
        System.out.println(y.getName() + " " + y.getCheese() + " " + y.getMoney());
        System.out.println(z.getName() + " " + z.getCheese() + " " + z.getMoney());
        System.out.println("===3rd round===");
        v.trade(a);
        w.trade(x);
        y.trade(z);
        System.out.println("===4th round===");
        System.out.println(v.getName() + " " + v.getCheese() + " " + v.getMoney());
        System.out.println(w.getName() + " " + w.getCheese() + " " + w.getMoney());
        System.out.println(x.getName() + " " + x.getCheese() + " " + x.getMoney());
        System.out.println(y.getName() + " " + y.getCheese() + " " + y.getMoney());
        System.out.println(z.getName() + " " + z.getCheese() + " " + z.getMoney());
        System.out.println("===4th round===");

        CheeseConnoisseur s =  new CheeseConnoisseur("s", 10, a);
        CheeseConnoisseur t =  new CheeseConnoisseur("t", 10, e);
        System.out.println(s.getName() + " " + s.getCheese() + " " + s.getMoney());
        System.out.println(t.getName() + " " + t.getCheese() + " " + t.getMoney());
        s.trade(t);
        System.out.println(s.getName() + " " + s.getCheese() + " " + s.getMoney());
        System.out.println(t.getName() + " " + t.getCheese() + " " + t.getMoney());

    }
}
