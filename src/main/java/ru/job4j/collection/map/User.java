package ru.job4j.collection.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", children=" + children +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    public static void main(String[] args) {
        Calendar birthday = Calendar.getInstance();
        User user1 = new User("Vasiliy", 2, birthday);
        User user2 = new User("Vasiliy", 2, birthday);
        int hash1 = user1.hashCode() ^ (user1.hashCode() >>> 16);
        int hash2 = user2.hashCode() ^ (user2.hashCode() >>> 16);
        int bucket1 = hash1 & 15;
        int bucket2 = hash2 & 15;
        Map<User, Object> map = new HashMap<>(16);
        map.put(user1, new Object());
        map.put(user2, new Object());
        for(User e : map.keySet()){
            System.out.println(e);
        }
        System.out.println(hash1);
        System.out.println(bucket1);
        System.out.println(hash2);
        System.out.println(bucket2);
    }
}


