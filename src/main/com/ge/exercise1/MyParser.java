package com.ge.exercise1;

import com.ge.exercise1.impl.ApplicationImpl;
import com.google.gson.Gson;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * MyParser will parse the incoming string into appropriate json
 */
public class MyParser implements Parser {
    @Override
    public Application parseApplicationData(String data) {
        String jsonString = getInputJson(data);
        ApplicationImpl appMap = new Gson().fromJson(jsonString,ApplicationImpl.class);
        return appMap;
    }

    /**
     *
     * @param inputString
     * @return
     */
    private String getInputJson(String inputString) {
        Pattern patt = Pattern.compile("[A-Za-z][A-Za-z]+\\(");

        Matcher m = patt.matcher(inputString);
        StringBuffer sBuffer = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sBuffer, "{");
        }
        m.appendTail(sBuffer);
        patt = Pattern.compile("[A-Za-z][A-Za-z]+");
        inputString=sBuffer.toString();
        m = patt.matcher(inputString);
        sBuffer = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sBuffer, "\""+m.group()+"\"");
        }
        m.appendTail(sBuffer);

        inputString=sBuffer.toString();
        patt = Pattern.compile("\\\"\\s\\\"");
        m = patt.matcher(inputString);
        sBuffer = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sBuffer, " ");
        }
        m.appendTail(sBuffer);
        String finalData = sBuffer.toString();
        finalData = finalData.replace(")","}");
        return finalData;
    }

}

