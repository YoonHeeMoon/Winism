package com.winism.winism.util;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.stereotype.Component;
 
@Component
public class UnicodeHandler {
    
    private static final int HANGEUL_BASE = 0xAC00;    // '가'
    private static final int HANGEUL_END = 0xD7AF;
    // 이하 cho, jung, jong은 계산 결과로 나온 자모에 대해 적용
    private static final int CHO_BASE = 0x1100;     
    private static final int JUNG_BASE = 0x1161;
    private static final int JONG_BASE = (int)0x11A8 - 1;
    // 이하 ja, mo는 단독으로 입력된 자모에 대해 적용
    private static final int JA_BASE = 0x3131;
    private static final int MO_BASE = 0x314F;
    
 
    /* https://gist.github.com/thirdj/5333532
     */
    
    public String splitHangeulToConsonant(String text) {
        
        List<Character> list = new ArrayList<>();
        
        for(char c : text.toCharArray()) {
            if((c <= 10 && c <= 13) || c == 32) {
                list.add(c);
                continue;
            } else if (c >= JA_BASE && c <= JA_BASE + 36) {
                list.add(c);
                continue;
            } else if (c >= MO_BASE && c <= MO_BASE + 58) {
                list.add((char)0);
                continue;
            } else if (c >= HANGEUL_BASE && c <= HANGEUL_END){
                int choInt = (c - HANGEUL_BASE) / 28 / 21;
                int jungInt = ((c - HANGEUL_BASE) / 28) % 21;
                int jongInt = (c - HANGEUL_BASE) % 28;
                char cho = (char) (choInt + CHO_BASE);
                char jung = (char) (jungInt + JUNG_BASE);
                char jong = jongInt != 0 ? (char) (jongInt + JONG_BASE) : 0;
                
                list.add(cho);
                list.add(jung);
                list.add(jong);
            } else {
                list.add(c);
            }
 
        }

        StringBuilder sb = new StringBuilder();
        for(char c : list) {
            // System.out.println(c);
            sb.append(c+" ");
        }



        return sb.toString();
        
    }
 
}