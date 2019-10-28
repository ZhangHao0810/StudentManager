package bean;

import java.util.Date;

/**
 * @author ZhangHao
 * @date 2019/10/27 22:08
 * @Description： 学生类
 * <p>
 * 一会儿会用DBUTIl来进行数据库的操作,这里的属性名字一定要和数据库的字段名字一致.不然不行.
 *  使用DBUtil 一定要有一个无参的构造.他需要找这个无参构造.内部要用反射机制.newInstance
 */
public class Student {

    private int sid;
    private String name;
    private String gender;
    private String phone;
    private String hobby;
    private String info;
    /**
     * 注意Date要选Util包下的.
     */
    private Date birthday;

    public Student() {
    }

    public Student(int sid,String sname, String gender, String phone, String hobby, String info, Date birthday) {
        this.sid = sid;
        this.name = sname;
        this.gender = gender;
        this.phone = phone;
        this.hobby = hobby;
        this.info = info;
        this.birthday = birthday;
    }
    public Student(String sname, String gender, String phone, String hobby, String info, Date birthday) {
        this.name = sname;
        this.gender = gender;
        this.phone = phone;
        this.hobby = hobby;
        this.info = info;
        this.birthday = birthday;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String sname) {
        this.name = sname;
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
                ", sname='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", hobby='" + hobby + '\'' +
                ", info='" + info + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
