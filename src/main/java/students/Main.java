package students;

import students.entity.Profession;
import java.util.List;
import students.dao.StudentDAO;
import students.entity.Applicant;
import students.entity.Subject;
 
public class Main {
 
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
 
        // ���������� ����� ���������
        Subject subject = new Subject();
        subject.setSubjectName("Mathematics");
        dao.addSubject(subject);
        subject = new Subject();
        subject.setSubjectName("Chemistry");
        dao.addSubject(subject);
        subject = new Subject();
        subject.setSubjectName("Logic");
        dao.addSubject(subject);
 
        System.out.println("List of SUBJECTS");
        System.out.println("----------------");
        List<Subject> sbList = dao.findSubject();
        // � ������ �� �������, ��� �������� ���� �� ��������� � ���������� - ���������� = 0
        for (Subject a : sbList) {
            System.out.println(a.getSubjectId() + ":" + a.getSubjectName() +
                    ". Number of profession:" + a.getProfessionList().size());
        }
 
        // ������ ������� ���������
        Profession profession = new Profession();
        profession.setProfessionName("Programmer");
        // ������ ���������, ������� ���� ������� ��� ���� ���������
        // �������� ��������, ��� � ������ Profession �� ������� ������ ������
        // ����� �� ���� NullPointerException
        profession.getSubjectList().add(sbList.get(0));
        profession.getSubjectList().add(sbList.get(2));
        dao.addProfession(profession);
        profession = new Profession();
        profession.setProfessionName("Biologist");
        profession.getSubjectList().add(sbList.get(1));
        profession.getSubjectList().add(sbList.get(2));
        // ������� ��������� �� ID � ������� ��� ���� ������� ��� �����
        Long id = dao.addProfession(profession);
        profession = dao.getProfession(id);
        profession.getSubjectList().add(sbList.get(0));
        dao.updateProfession(profession);
 
        // ������� ������ ���������
        System.out.println();
        System.out.println("List of PROFESSIONS");
        System.out.println("-------------------");
        List<Profession> prList = dao.findProfession();
        for (Profession a : prList) {
            System.out.println(a.getProfessionId() + ":" + a.getProfessionName());
        }
 
        System.out.println();
        System.out.println("List of SUBJECTS");
        System.out.println("----------------");
        sbList = dao.findSubject();
        // � ������ �� �������, ��� �������� ������ ��������� � ���������� - ���������� > 0
        for (Subject a : sbList) {
            System.out.println(a.getSubjectId() + ":" + a.getSubjectName() +
                    ". Number of profession:" + a.getProfessionList().size());
        }
 
        // � ������ �������� ����� ������������
        Applicant applicant = new Applicant();
        applicant.setFirstName("John");
        applicant.setMiddleName("M");
        applicant.setLastName("Danny");
        // ������ ���������
        applicant.setProfession(prList.get(0));
        applicant.setEntranceYear(2009);
        dao.addApplicant(applicant);
        applicant = new Applicant();
        applicant.setFirstName("Poul");
        applicant.setMiddleName("H");
        applicant.setLastName("Tride");
        // ������ ���������
        applicant.setProfession(prList.get(1));
        applicant.setEntranceYear(2009);
        dao.addApplicant(applicant);
 
        System.out.println();
        System.out.println("List of APPLICANTS");
        System.out.println("------------------");
        List<Applicant> apList = dao.findApplicant();
        for (Applicant a : apList) {
            System.out.println(a.getFirstName().trim() + ":" + a.getLastName().trim() + " - " + a.getProfession().getProfessionName().trim());
        // ���� ������ �����������, �� ������� �������� �� ������ - ��������� �� ����������������
        // �� ��� ����� ���������� ����������� � StudentDAO (����� findApplicant()).
        //System.out.println(a.getProfession().getSubjectList().size());
        }
 
    }
}