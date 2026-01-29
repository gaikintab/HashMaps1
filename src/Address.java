import java.util.Objects;

public class Address {
    String country;
    String city;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city);
    }

    @Override
    public boolean equals(Object object) {
        Address address = (Address) object;
        return this.country.equals(address.country) && this.city.equals(address.city);
    }
}
