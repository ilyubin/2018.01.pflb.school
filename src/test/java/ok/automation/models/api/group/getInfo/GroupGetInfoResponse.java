package ok.automation.models.api.group.getInfo;

import ok.automation.models.api.base.Attrs;
import ok.automation.models.api.base.MainPhoto;
import ok.automation.tech.extensions.BaseModel;

public class GroupGetInfoResponse extends BaseModel {
    public String abbreviation;
    public String access_type;
    public String address;
    public String admin_id;
    public Attrs attrs;
    public Boolean business;
    public String category;
    public String city;
    public Boolean comment_as_official;
    public Boolean community;
    public Boolean content_as_official;
    public String country;
    public Long created_ms;
    public String description;
    public Long end_date;
    public Boolean feed_subscription;
    public Integer friends_count;
    public Integer graduate_year;
    public String homepage_name;
    public String homepage_url;
    public Long location_id;
    public Double location_latitude;
    public Double location_longitude;
    public Integer location_zoom;
    public String main_page_tab;
    public MainPhoto main_photo;
    public Integer members_count;
    public Boolean messages_allowed;
    public Integer min_age;
    public String name;
    public Boolean notifications_subscription;
    public String partner_program_status;
    public String phone;
    public String photo_id;
    public Boolean photos_tab_hidden;
    public String picAvatar;
    public Integer possible_members_count;
    public Boolean premium;
    public Boolean privatE; // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public Boolean products_tab_hidden;
    public String ref;
    public String scope_id;
    public String shortname;
    public Long start_date;
    public String status;
    public String subcategory_id;
    public Boolean transfers_allowed;
    public String uid;
    public Boolean video_tab_hidden;
    public Integer year_from;
    public Integer year_to;
}
