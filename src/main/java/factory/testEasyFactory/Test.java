package factory.testEasyFactory;

/**
 * Created by koreyoshi on 2017/8/30.
 */
public class Test {

    public static void main(String[] args) {
        String pizzaType = "veggie";
        Pizza pizza = PizzaManager.DoPizza(pizzaType);
        String finalPizza = pizza.DoPizza(pizza);
        System.out.println(finalPizza);
    }
}
