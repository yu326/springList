package yu.model;

/**
 * Created by koreyoshi on 2017/8/4.
 */
public class Course {
    //课程id
    private int courseId;
    //课程名称
    private String courseName;
    //课程学习人数
    private int courseStudyNum;
    //课程时常
    private String courseTime;
    //简介
    private String courseDesc;
    //作者
    private String courseAuthor;
    //级别
    private int courseLevel;
    //评分
    private double courseScore;


    public void setCourseId(int courseId){
        this.courseId = courseId;
    }
    public int getCourseId(){
        return this.courseId;
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    public String getCourseName(){
        return this.courseName;
    }

    public void setCourseStudyNum(int courseStudyNum){
        this.courseStudyNum = courseStudyNum;
    }
    public int getCourseStudyNum(){
        return this.courseStudyNum;
    }

    public void setCourseTime(String courseTime){
        this.courseTime = courseTime;
    }
    public String getCourseTime(){
        return this.courseTime;
    }

    public void setCourseDesc(String courseDesc){
        this.courseDesc = courseDesc;
    }
    public String getCourseDesc(){
        return this.courseDesc;
    }

    public void setCourseAuthor(String courseAuthor){
        this.courseAuthor = courseAuthor;
    }
    public String getCourseAuthor(){
        return this.courseAuthor;
    }

    public void setCourseLevel(int courseLevel){
        this.courseLevel = courseLevel;
    }
    public int getCourseLevel(){
        return this.courseLevel;
    }

    public void setCourseScore(double courseScore){
        this.courseScore = courseScore;
    }
    public double getCourseScore(){
        return this.courseScore;
    }

}
