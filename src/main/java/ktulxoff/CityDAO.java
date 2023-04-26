package ktulxoff;

import java.util.List;

public interface CityDAO {

	//create
	void add(CityEntity cityEntity);

	//read
	List<CityEntity> getAll();
	CityEntity getById(int id);

	//update
	void updateById(int id, CityEntity cityEntity);

	//delete
	void removeById(int id);
	
	
	
	public void startSession();
	public void stopSession();
}
