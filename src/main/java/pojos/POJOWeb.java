package pojos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class POJOWeb {
    //root_domain	domain_suffix	language	legal_name	main_city	main_country	main_region	phone	site_name	tld	s_category
    String root_domain;
    String domain_suffix;
    String language;
    String legal_name;
    String main_city;
    String main_country;
    String main_region;
    String phone;
    String site_name;
    String tld; // country code
    String s_category;

}
