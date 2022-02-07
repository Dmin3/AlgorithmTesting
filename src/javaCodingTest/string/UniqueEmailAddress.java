package javaCodingTest.string;

import java.util.HashSet;
import java.util.Set;

// 고유한 이메일
public class UniqueEmailAddress {
    public static void main(String[] args) {

        UniqueEmailAddress a = new UniqueEmailAddress();

        String[] emails = {
                "test.email+james@coding.com",
                "test.e.mail+toto.jane@coding.com",
                "testemail+tom@cod.ing.com"
        };

//        System.out.println(a.solve_1(emails));
        System.out.println(a.solve_spilt(emails));



    }

    //split
    private int solve_spilt(String[] emails) {

        // 중복 제거
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            String[] part = email.split("@");
            String[] localName = part[0].split("\\+");
            set.add(localName[0].replace(".", "") + "@"+ part[1]);
        }

        return set.size();
    }


    private int solve_1(String[] emails) {

        Set<String> set = new HashSet<>();

        for (String email : emails) {
            String localName = makeLocalName(email);
            String domainName = makeDomainName(email);
            set.add(localName + '@' + domainName);
        }
        return set.size();
    }

    private String makeDomainName(String email) {

        email.substring(email.indexOf("@")+1);

        return email;

    }

    private String makeLocalName(String email) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '.') {
                continue;
            }
            if (email.charAt(i) == '+' || email.charAt(i) == '@') {
                break;
            }
            sb.append(email.charAt(i));
        }

        return sb.toString();
    }




}
