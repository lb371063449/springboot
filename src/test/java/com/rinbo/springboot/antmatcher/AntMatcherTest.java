package com.rinbo.springboot.antmatcher;

import org.junit.Test;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

public class AntMatcherTest {

    @Test
    public void testMatcherOnChart() {
        PathMatcher matcher = new AntPathMatcher();
        System.out.println(matcher.match("/com/t?st.jsp", "/com/txst.jsp"));
        System.out.println(matcher.match("/com/t?st.jsp", "/com/tast.jsp"));
        System.out.println(matcher.match("/com/t?st.jsp", "/com/txst.jsp"));
    }
}
