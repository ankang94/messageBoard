package com.ankang.msgboard.infrastructure.utils;

import com.google.common.collect.Sets;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;

@Component
public class SensitiveWordFilter {

    public boolean check(String str) {
        //初始化敏感词库
        if (SensitiveWordUtil.sensitiveWordMap == null) {
            SensitiveWordUtil.init(fetchSensitiveWords());
        }
        return SensitiveWordUtil.contains(str);
    }

    /**
     * 获取敏感词
     * @return
     */
    private Set<String> fetchSensitiveWords() {
        Set<String> sensitiveWordSet = Sets.newHashSet();
        InputStream inputStream = SensitiveWordFilter.class.getClassLoader().getResourceAsStream("CensorWords.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                sensitiveWordSet.add(str);
            }
        } catch (Exception e) {
            return sensitiveWordSet;
        } finally {
            try {
                bufferedReader.close();
                inputStream.close();
            } catch (IOException e) {}
        }
        return sensitiveWordSet;
    }
}
