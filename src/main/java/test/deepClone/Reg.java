package test.deepClone;

/**
 * Created by koreyoshi on 2017/9/6.
 */
public class Reg implements Cloneable {

    static class Body implements Cloneable {
        public Head head;

        public Body() {
        }

        public Body(Head head) {
            this.head = head;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            Body newBody = (Body) super.clone();
            newBody.head = (Head) head.clone();
            return newBody;
        }

    }

    static class Head implements Cloneable {
//        public Face face;
//
//        public Head() {
//        }
//
//        public Head(Face face) {
//            this.face = face;
//        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            Head newHead = (Head) super.clone();
//            newHead.face = (Face) this.face.clone();
            return newHead;
//            return super.clone();
        }
    }

//    static class Face implements Cloneable {
//
//    }
    static class Face implements Cloneable{
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Body body = new Body(new Head());

        Body body1 = (Body) body.clone();

        System.out.println("body == body1 : " + (body == body1));

        System.out.println("body.head == body1.head : " + (body.head == body1.head));

//        System.out.println("body.head.face == body1.head.face : " + (body.head.face == body1.head.face));
    }
}
