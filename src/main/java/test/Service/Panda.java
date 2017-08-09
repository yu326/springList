package test.Service;

/**
 * Created by koreyoshi on 2017/8/9.
 */
public class Panda extends Animal {
    private int height;
    private String food;
    private String name;


    public Panda(){
        this.name = "panda";
    }

//    public String getName() {
//        return name;
//    }

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
