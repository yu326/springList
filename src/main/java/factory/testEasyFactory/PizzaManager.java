package factory.testEasyFactory;

/**
 * Created by koreyoshi on 2017/8/30.
 */
public class PizzaManager {
    public static Pizza DoPizza(String type) {
        //逻辑
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("clam")) {
            pizza = new ClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        }else{
            throw  new RuntimeException("披萨类型错误");
        }
        return pizza;
    }

}
