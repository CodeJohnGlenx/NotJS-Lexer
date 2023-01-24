import java.util.regex.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.io.FileWriter;

public class Lex {
    public static void main(String[] args) {
        // args[0] expects <filename>.njs
        
        try {
            // convert .njs file into Java String
            String njsContent = Files.readString(Path.of(args[0]));
            String fileExtension = args[0].substring(args[0].indexOf('.'));
            njsContent += " ";
            ArrayList<String[]> lexemeTokenList;

            // throw Exception if file extension is not ".njs"
            if (!fileExtension.equals(".njs")) {
                throw new Exception("Input File only accepts \".njs\" extension!");
            }

            // perform scanning
            lexemeTokenList = scan(njsContent, Tokens.PATTERNLIST);
            if (lexemeTokenList != null) {
                // write lexeme and token to SymbolTable.txt
                FileWriter lexWriter = new FileWriter("LexOut.txt");
                for (String[] lexemeToken: lexemeTokenList) {
                    lexWriter.write(String.format("%-50s%s\n", lexemeToken[0], lexemeToken[1]));
                }
                lexWriter.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Scanning of Token
    // content - the string the will be scanned
    // patternList - a list of regular expressions 
    public static ArrayList<String[]> scan(String content, String[] patternList) {
        Pattern pattern;
        Matcher matcher;
        ArrayList<String[]> lexemeTokenList = new ArrayList<>();

        // identiferPattern and identifierMatcher for special cases
        Pattern identifierPattern = Pattern.compile("^[_a-zA-Z]+\\w*");
        Matcher identifierMatcher;

        // while content contains possible lexems
        while (!content.isEmpty()) {
            boolean found = false;

            // iterate every regular expressions
            for (String p: patternList) {
                pattern = Pattern.compile(p);
                matcher = pattern.matcher(content);

                // for identifier
                identifierMatcher = identifierPattern.matcher(content);

                // if both regular expression of identifier and some patternList p (e.g. keywords/reserved_words/bool_literal) matches
                if (identifierMatcher.find(0) == true && matcher.find(0) == true) {
                    String identifierSubString = content.substring(identifierMatcher.start(), identifierMatcher.end());
                    String matcherSubString = content.substring(matcher.start(), matcher.end());

                    // lexeme is a (keyword/reserved_word/bool_literal)
                    if (identifierSubString.equals(matcherSubString)) {
                        System.out.printf("%-50s%s\n", content.substring(matcher.start(), matcher.end()), Tokens.TOKEN.get(p));
                        lexemeTokenList.add(new String[] {content.substring(matcher.start(), matcher.end()), Tokens.TOKEN.get(p)});
                        content = content.substring(matcher.end());
                    // lexeme is an identifier
                    } else {
                        System.out.printf("%-50s%s\n", content.substring(identifierMatcher.start(), identifierMatcher.end()), Tokens.TOKEN.get(identifierPattern.pattern()));
                        lexemeTokenList.add(new String[] {content.substring(identifierMatcher.start(), identifierMatcher.end()), Tokens.TOKEN.get(identifierPattern.pattern())});
                        content = content.substring(identifierMatcher.end());
                    }
                    found = true;
                    break;
                }

                // lexeme belongs to other form of token (e.g. semicolon/increment/int_literal etc.)
                if (matcher.find(0) == true) {
                    if (Tokens.TOKEN.get(p) != "WHITESPACE" && Tokens.TOKEN.get(p) != "MULTI_LINE_COMMENT") {
                        // break down STRING_LITERAL into different tokens
                        if (Tokens.TOKEN.get(p) == "STRING_LITERAL") {
                            System.out.printf("%-50s%s\n", "\"", Tokens.STRTOKENS.get("open_quote"));
                            lexemeTokenList.add(new String[] {"\"", Tokens.STRTOKENS.get("open_quote")});

                            String strContent = content.substring(matcher.start(), matcher.end());
                            if (strContent.length() > 2) {
                                strContent = strContent.substring(1, strContent.length()-1);
                                while (!strContent.isEmpty()) {
                                    for (String s: Tokens.STRPATTERNLIST) {
                                        Pattern strPattern = Pattern.compile(s);
                                        Matcher strMatcher = strPattern.matcher(strContent);
    
                                        if (strMatcher.find(0) == true) {
                                            System.out.printf("%-50s%s\n", strContent.substring(strMatcher.start(), strMatcher.end()), Tokens.STRTOKENS.get(s));
                                            lexemeTokenList.add(new String[] {strContent.substring(strMatcher.start(), strMatcher.end()), Tokens.STRTOKENS.get(s)});
                                            strContent = strContent.substring(strMatcher.end());
                                            break;
                                        } else {
                                        }
                                    }
                                }
                            }

                            System.out.printf("%-50s%s\n", "\"", Tokens.STRTOKENS.get("close_quote"));
                            lexemeTokenList.add(new String[] {"\"", Tokens.STRTOKENS.get("close_quote")});

                        // break down CHAR_LITERAL into different tokens
                        } else  if (Tokens.TOKEN.get(p) == "CHAR_LITERAL") {
                            System.out.printf("%-50s%s\n", "\'", Tokens.CHARTOKENS.get("open_quote"));
                            lexemeTokenList.add(new String[] {"\'", Tokens.CHARTOKENS.get("open_quote")});
                        
                            String charContent = content.substring(matcher.start(), matcher.end());
                            if (charContent.length() > 2) {
                                charContent = charContent.substring(1, charContent.length()-1);
                                while (!charContent.isEmpty()) {
                                    for (String s: Tokens.CHARPATTERNLIST) {
                                        Pattern charPattern = Pattern.compile(s);
                                        Matcher charMatcher = charPattern.matcher(charContent);
                        
                                        if (charMatcher.find(0) == true) {
                                            System.out.printf("%-50s%s\n", charContent.substring(charMatcher.start(), charMatcher.end()), Tokens.CHARTOKENS.get(s));
                                            lexemeTokenList.add(new String[] {charContent.substring(charMatcher.start(), charMatcher.end()), Tokens.CHARTOKENS.get(s)});
                                            charContent = charContent.substring(charMatcher.end());
                                            break;
                                        } else {
                                        }
                                    }
                                }
                            }
                        
                            System.out.printf("%-50s%s\n", "\'", Tokens.CHARTOKENS.get("close_quote"));
                            lexemeTokenList.add(new String[] {"\'", Tokens.CHARTOKENS.get("close_quote")});
                        }
                        
                        else {
                            System.out.printf("%-50s%s\n", content.substring(matcher.start(), matcher.end()), Tokens.TOKEN.get(p));
                            lexemeTokenList.add(new String[] {content.substring(matcher.start(), matcher.end()), Tokens.TOKEN.get(p)});
                        }
                    }
                    content = content.substring(matcher.end());
                    found = true;
                    break;
                } 

            }
            
            // symbol or lexeme is unrecognizable
            if (found == false) {
                String error = String.format("%s", content.charAt(0));
                System.out.printf("%-50s%s\n", error, "NOT_RECOGNIZED_AS_TOKEN");
                System.out.println("\n/*Lex Scanner Interrupted.*/\n");

                //return new ArrayList<>() {{add(new String[] {error, "NOT_RECOGNIZED_AS_TOKEN"});}};
                return null;
            }
        }
        return lexemeTokenList;
    }
}

