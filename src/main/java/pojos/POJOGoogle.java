package pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class POJOGoogle {
    //address,category,city,country_code,country_name,name,phone,phone_country_code,
    // raw_address,raw_phone,region_code,region_name,text,zip_code,domain
    String address;
    String category;
    String city;
    String country_code;
    String country_name;
    String name;
    String phone;
    String phone_country_code;
    String raw_address;
    String raw_phone;
    String region_code;
    String region_name;
    String text;
    String zip_code;
    String domain;
}
