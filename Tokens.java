import java.util.Hashtable;

public class Tokens {
    public static final String[] PATTERNLIST = {
        // data types
        "^String",  // STRING_TYPE
        "^int",  // INT_TYPE
        "^char",  // CHAR_TYPE
        "^float",  // FLOAT_TYPE
        //"^double",  // DOUBLE_TYPE
        "^bool",   // BOOL_TYPE

        // keywords


        // reserved words
        "^[_a-zA-Z]+\\w*",  // IDENTIFIER

        // literals
        "^\".*\"",  // STRING_LITERAL
        "^'.'",  // CHAR_LITERAL
        "^([0-9]+([.][0-9]*)|([0-9]*[.][0-9]+))",  // FLOAT_LITERAL
        "^[0-9]+",  // INT_LITERAL
        "^true|false",  // BOOL_LITERAL

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
        "^;", // SEMICOLON

        "^\\s+", // WHITESPACE
    };

    public static final Hashtable<String, String> TOKEN = new Hashtable<String, String>() {{
        // data types
        put("^String", "STRING_TYPE");
        put("^int", "INT_TYPE");
        put("^char", "CHAR_TYPE");
        put("^float", "FLOAT_TYPE");
        put("^bool", "BOOL_TYPE");

        put("^[_a-zA-Z]+\\w*", "IDENTIFIER");

        // literals
        put("^\".*\"", "STRING_LITERAL");
        put("^'.'", "CHAR_LITERAL");
        put("^[0-9]+", "INT_LITERAL");
        put("^([0-9]+([.][0-9]*)|([0-9]*[.][0-9]+))", "FLOAT_LITERAL");
        put("^true|false", "BOOL_LITERAL");

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
        put("^;", "SEMICOLON");

        put("^\\s+", "WHITESPACE");
    }};
}


