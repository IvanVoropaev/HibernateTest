package students;

import java.util.List;

import org.hibernate.Session;

import students.entity.Profession;
import students.utils.HibernateUtil;

public class Main {
	
	//добавление новой записи в таблицу PROFESSION
	private void addProfession(String name) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Profession prof = new Profession();
		prof.setProfessionName(name);;
		session.save(prof);
		session.getTransaction().commit();
	}
	
	//возвращение списка профессий
	private List<Profession> listProfession() {
		String query = "from Profession order by professionName";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Profession> result = session.createQuery(query).list();
		session.getTransaction().commit();
		return result;
	}
	
	//удаление записи
	private void deleteEntry(Object o) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(o);
		session.flush();
		session.getTransaction().commit();
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		
		main.addProfession("Profession_1");
        main.addProfession("Profession_2");
        main.addProfession("Profession_3");
        main.addProfession("Profession_4");
        main.addProfession("Profession_5");
        
        List<Profession> result = main.listProfession();
        
        for (Profession r : result)
        	System.out.println(r.getProfessionId() + ": " + r.getProfessionName());
        	//main.deleteEntry(r);
	}
 
}
