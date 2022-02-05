package javaCodingTest;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {
    public static void main(String[] args) {

        UniqueEmailAddress a = new UniqueEmailAddress();

        String[] emails = {
                "test.email+james@coding.com",
                "test.e.mail+toto.jane@coding.com",
                "testemail+tom@cod.ing.com"
        };

        System.out.println(a.solve_1(emails));



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
