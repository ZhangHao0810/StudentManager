package bean;

import java.util.Date;

/**
 * @author ZhangHao
 * @date 2019/10/27 22:08
 * @Description： 学生类
 * <p>
 * 一会儿会用DBUTIl来进行数据库的操作,这里的属性名字一定要和数据库的字段名字一致.不然不行.
 */
public class Student {

    private int sid;
    private String sname;
    private String gender;
    private String phone;
    private String hobby;
    private String info;
    /**
     * 注意Date要选Util包下的.
     */
    private Date birthday;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", hobby='" + hobby + '\'' +
                ", info='" + info + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
