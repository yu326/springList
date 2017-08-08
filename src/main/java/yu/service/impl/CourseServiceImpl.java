package yu.service.impl;

import yu.model.Course;
import yu.service.CourseService;

/**
 * Created by koreyoshi on 2017/8/4.
 */
public class CourseServiceImpl implements CourseService {
    public Course getCourseById(int courseId){
        Course course = new Course();
        course.setCourseId(courseId);
        course.setCourseName("JAVA入门");
        course.setCourseAuthor("yu");
        course.setCourseDesc("本课程针对JAVA小白新手推出.");
        course.setCourseLevel(1);
        course.setCourseScore(9.23);
        course.setCourseStudyNum(236);
        course.setCourseTime("3小时24分钟");
        return course;
    }
}
