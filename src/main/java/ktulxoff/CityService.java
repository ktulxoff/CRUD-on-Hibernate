package ktulxoff;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CityService implements CityDAO {



/*
Добавить объект CityEntity в БД.

CityService cityService = new CityService();
cityService.startSession();

CityEntity cityEntity = new CityEntity();
cityEntity.setCity("SomeCity");
cityEntity.getId();	// -> null
cityService.add(cityEntity);
cityEntity.getId();	// -> id, автоматически полученное из БД

cityService.stopSession();
*/
	public void add(CityEntity cityEntity) {
        Session session = HibernateUtil.getSession();

        session.save(cityEntity);
	}



/*
Получить список объектов CityEntity из БД - createCriteria(CityEntity.class).list().

CityService cityService = new CityService();
cityService.startSession();

List<CityEntity> listCity = cityService.getAllNew();

cityService.stopSession();
*/
	public List<CityEntity> getAll() {
		List<CityEntity> cityEntityList = null;
        Session session = HibernateUtil.getSession();

		cityEntityList = session.createCriteria(CityEntity.class).list();
		return cityEntityList;
	}



/*
Получить объект CityEntity из БД по его id через метод session.load().

CityService cityService = new CityService();
cityService.startSession();

CityEntity cityEntity = cityService.getByIdNew();
//cityEntity.setCity("NewSomeCity");	//Изменения, проделанные с объектом cityEntity, автоматически сохранятся Hibernate'ом в БД после завершения сессии.

cityService.stopSession();
*/
	public CityEntity getById(int id) {
		CityEntity cityEntity = null;
        Session session = HibernateUtil.getSession();

		cityEntity = (CityEntity) session.load(CityEntity.class, id);
		return cityEntity;
	}



/*
Обновить поле БД с заданным id классом CityEntity.

Т.е. передать готовый объект CityEntity в данный метод update() вместе с id нужной строки в БД. 
В БД запись с заданным id будет заменена на данные из переданного объекта.
По сути, разница с методом update() состоит лишь в том, что строчка "cityEntity.setId(id);" переносится из вызывающего кода внутрь тела метода updateById().

CityService cityService = new CityService();
cityService.startSession();

cityEntity = new CityEntity();
cityEntity.setCity("SomeCity");
cityService.updateById(123, cityEntity);

cityService.stopSession();
*/
	public void updateById(int id, CityEntity cityEntity){
        Session session = HibernateUtil.getSession();

		cityEntity.setId(id);
		session.update(cityEntity);
	}



/*
Удалить объект CityEntity с заданным id из БД.

CityService cityService = new CityService();
cityService.startSession();

cityService.removeById(123);

cityService.stopSession();
*/
	public void removeById(int id){
        Session session = HibernateUtil.getSession();

		CityEntity cityEntity = new CityEntity();
		cityEntity.setId(id);
		session.remove(cityEntity);
	}



	public void startSession() {
		HibernateUtil.startSession();
	}



	public void stopSession() {
		HibernateUtil.stopSession();
	}
}