import java.util.Hashtable;

public class Tokens {

    // list of regular expressions
    public static final String[] PATTERNLIST = {
        // comments
        "^#.*",  // SINGLE_LINE_COMMENT
        "^'''(.|[\r\n]|)*?'''",  // MULTI_LINE_COMMENT

        // data types
        "^String",  // STRING_TYPE
        "^int",  // INT_TYPE
        "^char",  // CHAR_TYPE
        "^float",  // FLOAT_TYPE
        "^bool",   // BOOL_TYPE

        // reserved word (for now)
        "^double",  // DOUBLE_TYPE

        // keywords
        "^input",  // INPUT
        "^in",  // IN
        "^not",  // NOT
        "^try",  // TRY
        "^except",  // EXCEPT
        "^return",  // RETURN
        "elif",  // ELSE_IF
        "^else",  // ELSE
        "^if",  // IF
        "^for",  // FOR
        "^do",  // DO
        "^while",  // WHILE
        "^output",  // OUTPUT
        "^switch",  // SWITCH
        "^continue",  // CONTINUE
        "^finally",   // FINALLY
        "^break",  // BREAK
        "^default",  // DEFAULT
        "^case",  // CASE

        // reserved words
        "^var",  // VAR
        "^let",  // LET
        "^const",  // CONST
        "^final",  // FINAL

        // literals
        "^(\"[^\"]*\")",  // STRING_LITERAL
        "^'.'",  // CHAR_LITERAL
        "^([0-9]+([.][0-9]*)|^([0-9]*[.][0-9]+))",  // FLOAT_LITERAL
        "^[0-9]+",  // INT_LITERAL
        "^(true)|^(false)",  // BOOL_LITERAL

        // relational operators 
        "^[=][=]",  // EQUAL_TO
        "^[!][=]",  // NOT_EQUAL_TO
        "^[>][=]",  // GREATER_THAN_EQUAL_TO
        "^[>]",  // GREATER_THAN 
        "^[<]=",  // LESS_THAN_EQUAL_TO
        "^[<]",  // LESS_THAN

        // logical operators
        "^[!]",  // NOT
        "^[&][&]",  // AND
        "^[|][|]",  // OR
        
        // unary operators
        "^[+][+]",  // INCREMENT
        "^[-][-]",  // DECREMENT

        // assignment operators 
        "^=",  // ASSIGNMENT
        "^[+]=",  // ADDITION_ASSIGNMENT
        "^[-]=",  // SUBTRACTION_ASSIGNMENT
        "^[*][*]=",  // EXPONENTIATION_ASSIGNMENT
        "^[*]=",  // MULTIPLICATION_ASSIGNMENT
        "^[/][/]=",  // FLOOR_DIVISION_ASSIGNMENT
        "^[/]=",  // DIVISION_ASSIGNMENT
        "^[%]=",  // MODULUS_ASSIGNMENT

        // arithmetic operators
        "^[+]",  // ADDITION
        "^-",  // SUBTRACTION
        "^[*][*]",  // EXPONENTIATION
        "^[*]",  // MULTIPLICATION
        "^//",  // FLOOR_DIVISION  
        "^/",  // DIVISION
        "^%",  // MODULUS

        // punctuations
        "^[;]", // SEMICOLON
        "^[:]",  // COLON
        "^[(]",  // LEFT_PARENTHESIS
        "^[)]",  // RIGHT_PARENTHESIS
        "^[{]",  // LEFT_CURLY_BRACKET
        "^[}]",  // RIGHT_CURLY_BRACKET
        "^[?]",  // QUESTION_MARK
        "^\\[",  // LEFT_SQUARE_BRACKET
        "^\\]",  // RIGHT_SQUARE_BRACKET
        "^[,]",  // COMMA

        // whitespace
        "^\\s+", // WHITESPACE

        // identifier
        "^[_a-zA-Z]+\\w*",  // IDENTIFIER
    };

    // Token equivalent of regular expression
    public static final Hashtable<String, String> TOKEN = new Hashtable<String, String>() {{
        // data types
        put("^String", "STRING_TYPE");
        put("^int", "INT_TYPE");
        put("^char", "CHAR_TYPE");
        put("^float", "FLOAT_TYPE");
        put("^bool", "BOOL_TYPE");

        // reserved word (for now)
        put("^double", "DOUBLE_TYPE");

        // keywords
        put("^input", "INPUT");
        put("^in", "IN");
        put("^not", "NOT");
        put("^try", "TRY");
        put("^except", "EXCEPT");
        put("^return", "RETURN");
        put("elif", "ELSE_IF");
        put("^else", "ELSE");
        put("^if", "IF");
        put("^for", "FOR");
        put("^do", "DO");
        put("^while", "WHILE");
        put("^output", "OUTPUT");
        put("^switch", "SWITCH");
        put("^continue", "CONTINUE");
        put("^finally", "FINALLY");
        put("^break", "BREAK");
        put("^default", "DEFAULT");
        put("^case",  "CASE");

        // reserved words
        put("^var", "VAR");
        put("^let", "LET");
        put("^const", "CONST");
        put("^final", "FINAL");
        
        // literals
        put("^(\"[^\"]*\")", "STRING_LITERAL");
        put("^'.'", "CHAR_LITERAL");
        put("^[0-9]+", "INT_LITERAL");
        put("^([0-9]+([.][0-9]*)|^([0-9]*[.][0-9]+))", "FLOAT_LITERAL");
        put("^(true)|^(false)", "BOOL_LITERAL");

        // relational operators
        put("^[=][=]", "EQUAL_TO");
        put("^[!][=]", "NOT_EQUAL_TO");
        put("^[>][=]", "GREATER_THAN_EQUAL_TO");
        put("^[>]", "GREATER_THAN");
        put("^[<]=", "LESS_THAN_EQUAL_TO");
        put("^[<]", "LESS_THAN");

        // logical operators
        put("^[!]", "NOT");
        put("^[&][&]", "AND");
        put("^[|][|]", "OR");

        //  unary operators
        put("^[+][+]", "INCREMENT");
        put("^[-][-]", "DECREMENT");

        // assignment operators
        put("^[+]=", "ADDITION_ASSIGNMENT");
        put("^[-]=", "SUBTRACTION_ASSIGNMENT");
        put("^[*][*]=", "EXPONENTIATION_ASSIGNMENT");
        put("^[*]=", "MULTIPLICATION_ASSIGNMENT");
        put("^[/][/]=", "FLOOR_DIVISION_ASSIGNMENT");
        put("^[/]=", "DIVISION_ASSIGNMENT");
        put("^[%]=", "MODULUS_ASSIGNMENT"); 
        put("^=", "ASSIGNMENT");

        // arithmetic operators        
        put("^[+]", "ADDITION");  
        put("^-", "SUBTRACTION");  
        put("^[*][*]", "EXPONENTIATION"); 
        put("^[*]", "MULTIPLICATION");  
        put("^//", "FLOOR_DIVISION");    
        put("^/", "DIVISION");  
        put("^%", "MODULUS");  
        
        // punctuations
        put("^[;]", "SEMICOLON");
        put("^[:]", "COLON");
        put("^[(]", "LEFT_PARENTHESIS");
        put("^[)]", "RIGHT_PARENTHESIS");
        put("^[{]", "LEFT_CURLY_BRACKET");
        put("^[}]", "RIGHT_CURLY_BRACKET");
        put("^[?]", "QUESTION_MARK");
        put("^\\[", "LEFT_SQUARE_BRACKET");
        put("^\\]", "RIGHT_SQUARE_BRACKET");
        put("^[,]", "COMMA");

        // whitespace
        put("^\\s+", "WHITESPACE");

        // comments
        put("^#.*", "SINGLE_LINE_COMMENT");
        put("^'''(.|[\r\n]|)*?'''",  "MULTI_LINE_COMMENT");

        // identifier
        put("^[_a-zA-Z]+\\w*", "IDENTIFIER");
    }};
}


