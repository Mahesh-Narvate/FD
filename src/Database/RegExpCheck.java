/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author rahul
 */
public class RegExpCheck {

    //function for matching UserName and EmailId
    public boolean matchUserName(String input) {
        boolean match = false;

        try {

            String emailregex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

            match = input.trim().matches(emailregex);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return match;

    }

    //function for checking MobileNo
    public boolean matchMobileNo(String input) {
        boolean match = false;

        try {

            String emailregex = "\\d{10}";

            match = input.trim().matches(emailregex);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return match;

    }

    //function for checking password
    public boolean matchPassword(String input) {
        //password should be 6-20 character in length
        boolean match = false;

        try {

            String emailregex = "^[a-zA-Z]{6,20}+$";
//            String emailregex = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

            match = input.trim().matches(emailregex);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return match;

    }

    //function for checking norml text with only characters
    public boolean matchText(String input) {

        boolean match = false;

        try {

        

            String emailregex = "^[a-zA-Z]{1,40}+$";

            match = input.trim().matches(emailregex);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return match;

    }
    
     //function for checking MobileNo
    public boolean matchInteger(String input) {
        boolean match = false;

        try {

            String emailregex = "\\d{10}";

            match = input.trim().matches(emailregex);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return match;

    }
    
    


}
