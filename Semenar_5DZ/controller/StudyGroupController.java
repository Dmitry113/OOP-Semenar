package controller;

import java.util.List;

import View.ConsoleView;
import model.Student;
import model.StudyGroup;
import model.Teacher;
import service.StudyGroupService;

public class StudyGroupController {
    private StudyGroupService studyGroupService;
    private ConsoleView view;

    public StudyGroupController(StudyGroupService studyGroupService, ConsoleView view) {
        this.studyGroupService = studyGroupService;
        this.view = view;
    }

    public void formAndDisplayStudyGroup(Teacher teacher, List<Student> students) {
        StudyGroup studyGroup = studyGroupService.createStudyGroup(teacher, students);
        view.displayStudyGroup(studyGroup);
    }
}
