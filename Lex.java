import java.util.regex.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class Lex {
    public static void main(String[] args) {
        // args[0] expects <filename>.njs

        try {
            String njsContent = Files.readString(Path.of(args[0]));
            String fileExtension = args[0].substring(args[0].indexOf('.'));

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

        while (!content.isEmpty()) {
            boolean found = false;

            for (String p: patternList) {
                pattern = Pattern.compile(p);
                matcher = pattern.matcher(content);

                if (matcher.find() == true) {
                    if (Tokens.TOKEN.get(p) != "WHITESPACE") {
                        System.out.printf("%-50s%s\n", content.substring(matcher.start(), matcher.end()), Tokens.TOKEN.get(p));
                     }
                    content = content.substring(matcher.end());
                    found = true;
                    break;
                } 
            }
             

            if (found == false) {
                System.out.printf("%s not found\n", content.charAt(0));
                return "Nothing";
            }
        }
        return "Done";
    }
}

/*
TO DO:
* Make a condition that only accepts .njs file 

*/
