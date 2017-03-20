package org.yoking.stream;

import com.google.common.collect.Lists;
import org.yoking.utils.RandomUtils;
import org.yoking.vo.Gender;
import org.yoking.vo.User;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by zhangyuqing on 2017/3/20.
 */
public class StreamTest {

    public static List<User> randomUsers(int number) {
        List<User> users = Lists.newArrayList();

        Random r = new Random();
        for (long i = 1; i <= number; i++) {
            users.add(new User(i, RandomUtils.randomEmail(8), RandomUtils.randomName(3, 5), null, Gender.of(r.nextInt(2))));
        }
        return users;
    }

    public static void streamFilter() {
        List<User> users = randomUsers(5);
        System.out.println("Original users:" + users.toString());

        List<User> filteredUsers = new ArrayList<>();
        users.stream().filter(u -> u.getGender() == Gender.FEMALE).forEach(filteredUsers::add);
        System.out.println("Filtered users:" + filteredUsers.toString());
    }

    public static void reduceStringList() {
        List<String> list = Lists.newArrayList("YW-A3389-D.iqiyi.pps", "20170320", "1610", "10.1.33.116");
        Optional<String> optional = list.stream().reduce((s1, s2) -> s1 + "#" + s2);
        optional.ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        streamFilter();
        reduceStringList();


        System.out.println("Sum: " + Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10).stream().filter(num -> num != null).
                distinct().mapToInt(num -> num * 2).
                peek(System.out::println).skip(2).limit(4).sum());
    }

}
