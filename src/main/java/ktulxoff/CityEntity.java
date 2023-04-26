package ktulxoff;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import java.util.Objects;

@Entity
@Table(name="CITIES", schema = "public", catalog = "baza")
public class CityEntity {

    public CityEntity() {}


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="CITY")
    private String city;


    public void setId(Integer id) {this.id = id;}
    public Integer getId() {return id;}

    public void setCity(String city) {this.city = city;}
    public String getCity() {return city;}


    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", city=\'" + city + "\'" +
                "}";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityEntity that = (CityEntity) o;
        return id.equals(that.id) &&
                city.equals(that.city);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, city);
    }
	
}