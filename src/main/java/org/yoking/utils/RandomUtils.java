package org.yoking.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by zhangyuqing on 2017/3/20.
 */
public class RandomUtils {

    private static final char a = 'a';

    private static final char A = 'A';

    private static final int LETTER_LEN = 26;

    private static final char zero = '0';

    private static final int NUMBER_LEN = 10;

    private static final char AT = '@';

    private static final String[] DOMAINS = { "163.com", "gmail.com", "qq.com", "sina.com", "hotmail.com", "aliyun.com", "yahoo.com", "icloud.com", "126.com", "sohu.com" };

    public static String randomName(int fLen, int lLen) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();

        builder.append((char)(A + random.nextInt(LETTER_LEN)));
        for (int i = 0; i < fLen - 1; i++) {
            builder.append((char)(a + random.nextInt(LETTER_LEN)));
        }

        builder.append(' ');
        builder.append((char)(A + random.nextInt(LETTER_LEN)));
        for (int i = 0; i < lLen - 1; i++) {
            builder.append((char)(a + random.nextInt(LETTER_LEN)));
        }

        return builder.toString();
    }

    public static String randomEmail(int len) {
        StringBuilder builder = new StringBuilder();
        List<Character> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < len / 3; i++) {
            list.add((char)(a + random.nextInt(LETTER_LEN)));
            list.add((char)(A + random.nextInt(LETTER_LEN)));
            list.add((char)(zero + random.nextInt(NUMBER_LEN)));
        }

        switch (len%3) {
            case 2:
                list.add((char)(A + random.nextInt(LETTER_LEN)));
            case 1:
                list.add((char)(a + random.nextInt(LETTER_LEN)));
                break;
            case 0:
                break;
        }
        Collections.shuffle(list);
        for (Character s : list) {
            builder.append(s);
        }
        builder.append(AT);
        builder.append(DOMAINS[random.nextInt(DOMAINS.length)]);
        return builder.toString();
    }
}