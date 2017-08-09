package test.Service;

/**
 * Created by koreyoshi on 2017/8/9.
 */
public  class  Animal {

    private int height;
    private String food;
    private static String name = "yu";

    public Animal(){
        this.name = "animals";
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFood() {
        return food;

    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


}
