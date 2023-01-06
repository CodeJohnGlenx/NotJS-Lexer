import java.util.regex.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class Lex {
    public static void main(String[] args) {
        // args[0] expects <filename>.njs
        
        try {
            String njsContent = Files.readString(Path.of(args[0]));
            String fileExtension = args[0].substring(args[0].indexOf('.'));
            njsContent += " ";

            // throw Exception if file extension is not ".njs"
            if (!fileExtension.equals(".njs")) {
                throw new Exception("Input File only accepts \".njs\" extension!");
            }

            scan(njsContent, Tokens.PATTERNLIST);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // token
    public static String scan(String content, String[] patternList) {
        Pattern pattern;
        Matcher matcher;
        Pattern identifierPattern = Pattern.compile("^[_a-zA-Z]+\\w*");
        Matcher identifierMatcher;


        while (!content.isEmpty()) {
            boolean found = false;

            for (String p: patternList) {
                pattern = Pattern.compile(p);
                matcher = pattern.matcher(content);

                identifierMatcher = identifierPattern.matcher(content);

                if (identifierMatcher.find(0) == true && matcher.find(0) == true) {
                    String identifierSubString = content.substring(identifierMatcher.start(), identifierMatcher.end());
                    String matcherSubString = content.substring(matcher.start(), matcher.end());

                    if (identifierSubString.equals(matcherSubString)) {
                        System.out.printf("%-50s%s\n", content.substring(matcher.start(), matcher.end()), Tokens.TOKEN.get(p));
                        content = content.substring(matcher.end());
                    } else {
                        System.out.printf("%-50s%s\n", content.substring(identifierMatcher.start(), identifierMatcher.end()), Tokens.TOKEN.get(identifierPattern.pattern()));
                        content = content.substring(identifierMatcher.end());
                    }
                    found = true;
                    break;
                }

                if (matcher.find(0) == true) {
                    if (Tokens.TOKEN.get(p) != "WHITESPACE" && Tokens.TOKEN.get(p) != "SINGLE_LINE_COMMENT" && Tokens.TOKEN.get(p) != "MULTI_LINE_COMMENT") {
                        System.out.printf("%-50s%s\n", content.substring(matcher.start(), matcher.end()), Tokens.TOKEN.get(p));
                    }
                    content = content.substring(matcher.end());
                    found = true;
                    break;
                } 

            }
             
            if (found == false) {
                System.out.printf("%snot found\n", content);
                System.out.println();
                return "Nothing";
            }
        }
        return "Done";
    }
}

/*
TO DO:
* Make a condition that only accepts .njs file 
* Fix Identifier-Other type problem
*/
